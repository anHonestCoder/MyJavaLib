package org.simon.zhao.spring.batch.record;

import java.io.Serializable;

/**
 * @author Zhaozhou
 * @date 2017/5/12
 *
 * 建行原对账文件字段解析实体类
 */
public class CCBReconItem implements Serializable{

	private String shopNo;			//15位商户号
	private String posRefNo;		//发生消费或分期的POS编号
	private String txDate;			//交易日期
	private String txTime;			//交易时间
	private String orderNo;			//订单编号
	private String posTxSqNo;		//POS交易序号
	private String acctNo;			//交易账户
	private String txAmt;			//交易金额
	private String decAmt;			//手续费
	private String entrDate;		//记账日期
	private String authNo;			//授权号
	private String payType;			//支付类型标识
	private String acctType;		//卡类型标识
	private String tradNo;			//商户流水号
	private String tradNoOrg;		//原交易的商户方流水号

	public CCBReconItem() {

	}

	public String getShopNo() {
		return shopNo;
	}

	public void setShopNo(String shopNo) {
		this.shopNo = shopNo;
	}

	public String getPosRefNo() {
		return posRefNo;
	}

	public void setPosRefNo(String posRefNo) {
		this.posRefNo = posRefNo;
	}

	public String getTxDate() {
		return txDate;
	}

	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}

	public String getTxTime() {
		return txTime;
	}

	public void setTxTime(String txTime) {
		this.txTime = txTime;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public String getPosTxSqNo() {
		return posTxSqNo;
	}

	public void setPosTxSqNo(String posTxSqNo) {
		this.posTxSqNo = posTxSqNo;
	}

	public String getAcctNo() {
		return acctNo;
	}

	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}

	public String getTxAmt() {
		return txAmt;
	}

	public void setTxAmt(String txAmt) {
		this.txAmt = txAmt;
	}

	public String getDecAmt() {
		return decAmt;
	}

	public void setDecAmt(String decAmt) {
		this.decAmt = decAmt;
	}

	public String getEntrDate() {
		return entrDate;
	}

	public void setEntrDate(String entrDate) {
		this.entrDate = entrDate;
	}

	public String getAuthNo() {
		return authNo;
	}

	public void setAuthNo(String authNo) {
		this.authNo = authNo;
	}

	public String getPayType() {
		return payType;
	}

	public void setPayType(String payType) {
		this.payType = payType;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getTradNo() {
		return tradNo;
	}

	public void setTradNo(String tradNo) {
		this.tradNo = tradNo;
	}

	public String getTradNoOrg() {
		return tradNoOrg;
	}

	public void setTradNoOrg(String tradNoOrg) {
		this.tradNoOrg = tradNoOrg;
	}

	@Override
	public String toString() {
		return "CCBReconItem{" +
				"shopNo='" + shopNo + '\'' +
				", posRefNo='" + posRefNo + '\'' +
				", txDate='" + txDate + '\'' +
				", txTime='" + txTime + '\'' +
				", orderNo='" + orderNo + '\'' +
				", posTxSqNo='" + posTxSqNo + '\'' +
				", acctNo='" + acctNo + '\'' +
				", txAmt='" + txAmt + '\'' +
				", decAmt='" + decAmt + '\'' +
				", entrDate='" + entrDate + '\'' +
				", authNo='" + authNo + '\'' +
				", payType='" + payType + '\'' +
				", acctType='" + acctType + '\'' +
				", tradNo='" + tradNo + '\'' +
				", tradNoOrg='" + tradNoOrg + '\'' +
				'}';
	}
}
