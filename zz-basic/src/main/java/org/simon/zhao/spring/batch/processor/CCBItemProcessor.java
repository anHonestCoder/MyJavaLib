package org.simon.zhao.spring.batch.processor;

import org.apache.commons.lang3.StringUtils;
import org.simon.zhao.spring.batch.record.CCBReconItem;
import org.simon.zhao.spring.batch.record.VpalRecondItem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import java.math.BigDecimal;

/**
 * @author Zhaozhou
 * @date 2017/5/22
 */
public class CCBItemProcessor implements ItemProcessor<CCBReconItem, VpalRecondItem> {

	private static final Logger logger = LoggerFactory.getLogger(CCBItemProcessor.class);

	@Override
	public VpalRecondItem process(CCBReconItem ccbItem) throws Exception {
		VpalRecondItem vpalItem = new VpalRecondItem();

		String transType = txnTypeConvert(ccbItem.getPayType());
		if (StringUtils.isBlank(transType)) {
			logger.warn("#CCB_DIRTY_DATA# transType not right, transType={}, {}", transType, ccbItem);
			return null;
		}

		vpalItem.setTransType( transType );
		vpalItem.setTransDate(ccbItem.getTxDate());
		vpalItem.setTransTime(ccbItem.getTxTime());
//		vpalItem.setBankOrdNo();					银行交易流水号需要查询数据库补全
		vpalItem.setTransAmount( txnAmoutConvert(ccbItem.getTxAmt()) );
//		vpalItem.setTransNo();						支付引擎流水号需要查询数据库补全

		String orderNo = ccbItem.getOrderNo();
		if (StringUtils.isBlank(orderNo)) {
			logger.warn("#CCB_DIRTY_DATA# orderNo not right, orderNo={}, {}", orderNo, ccbItem);
			return null;
		}
		vpalItem.setUasNo(orderNo);

//		vpalItem.setUsaOriginNo(item.getOrderNo());
		return vpalItem;
	}

	//交易类型转换 建行对账文件交易类型转换成唯品支付对账文件交易类型
	private String txnTypeConvert( String type ) {
		return "1";
	}

	//交易金额转换 建行对账文件交易金额转换成唯品支付对账文件的交易金额
	private String txnAmoutConvert( String amount ) {
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
