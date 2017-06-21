package org.simon.zhao.spring.batch.processor;

import org.apache.commons.lang3.StringUtils;
import org.simon.zhao.spring.batch.record.SPDBReconItem;
import org.simon.zhao.spring.batch.record.VpalRecondItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

/**
 * @author jason.gao
 * @date 2017/6/1
 */
public class SPDBItemProcessor implements ItemProcessor<SPDBReconItem, VpalRecondItem> {

	private static final Logger logger = LoggerFactory.getLogger(SPDBItemProcessor.class);

	@Override
	public VpalRecondItem process(SPDBReconItem spdbItem) throws Exception {
		VpalRecondItem vpalItem = new VpalRecondItem();

		String transType = txnTypeConvert(spdbItem.getTxType());
		if (StringUtils.isBlank(transType)) {
			logger.warn("#DIRTY_DATA# transType not right, transType={}, {}", transType, spdbItem);
			return null;
		}

		vpalItem.setTransType(transType);	//交易类型
		vpalItem.setBankOrdNo(spdbItem.getBankRespNo());				//银行交易流水号=商户侧请求流水
		vpalItem.setTransAmount(txnAmoutConvert(spdbItem.getTxAmount()) );	//TODO 统计3个文件中的所有交易金额之和
		//用UAS交易流水号作为条件，查fcg_deduct_spdb表获取交易日期、交易时间（create_time拆分）、transaction_id支付引擎流水号、bank_req_order_no UAS交易流水号
//		vpalItem.setTransDate();
//		vpalItem.setTransTime();
//		vpalItem.setTransNo();						支付引擎流水号需要查询数据库补全
		vpalItem.setUasNo(spdbItem.getMerchantReqNo());						//UAS交易流水号 = 商户侧请求流水
		vpalItem.setUsaOriginNo(spdbItem.getMerchantReqNo());					//因为没有退款交易，所以和UAS交易流水号相同
		return vpalItem;
	}

	//交易类型转换 浦发对账文件交易类型转换成唯品支付对账文件交易类型
	private String txnTypeConvert( String type ) {
		return "1";
	}

	//交易金额转换 浦发对账文件交易金额转换成唯品支付对账文件的交易金额
	private String txnAmoutConvert(String amount) {
		if ( StringUtils.isBlank(amount) ) {
			return "";
		}

		try{
			BigDecimal result =  new BigDecimal(amount).multiply(new BigDecimal(100)).setScale(0);
			return "" + Math.abs(result.longValue()) ;
		}catch(Exception e){
			return "";
		}
	}

}
