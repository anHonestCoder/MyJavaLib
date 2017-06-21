package org.simon.zhao.spring.batch.record;

/**
 * @author jason.gao
 * @date 2017/6/1
 *
 * 浦发银行原对账文件字段解析实体类
 */
public class SPDBReconItem {
	
	/*
	 * 	银行侧提供交易对账文件，商户通过浦发银行文件传输平台（WTP）获取对账文件：
	 *	商户号，商户名称，二级商户号，二级商户名，交易类型，交易日期，商户侧请求流水，银行侧响应流水，交易账号，交易账号名称，交易账号行号，交易账号行名，入账日期，入账时间，交易金额，手续费
	 */
	private String merchantId;			//商户号
	private String merchantName;		//商户名称
	private String secondMerchantId;	//二级商户号
	private String secondMerchantName;	//二级商户名
	private String txType;				//交易类型
	private String txDate;				//交易日期
	private String merchantReqNo;		//商户侧请求流水
	private String bankRespNo;			//银行侧响应流水
	private String txAccount;			//交易账号
	private String txAccountName;		//交易账号名称
	private String txAccountLineNo;		//交易账号行号
	private String txAccountLineName;	//交易账号行名
	private String accountedDate;		//入账日期
	private String accountedTime;		//入账时间
	private String txAmount;			//交易金额
	private String fee;					//手续费
	
	public SPDBReconItem() {

	}

	public String getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getSecondMerchantId() {
		return secondMerchantId;
	}

	public void setSecondMerchantId(String secondMerchantId) {
		this.secondMerchantId = secondMerchantId;
	}

	public String getSecondMerchantName() {
		return secondMerchantName;
	}

	public void setSecondMerchantName(String secondMerchantName) {
		this.secondMerchantName = secondMerchantName;
	}

	public String getTxType() {
		return txType;
	}

	public void setTxType(String txType) {
		this.txType = txType;
	}

	public String getTxDate() {
		return txDate;
	}

	public void setTxDate(String txDate) {
		this.txDate = txDate;
	}

	public String getMerchantReqNo() {
		return merchantReqNo;
	}

	public void setMerchantReqNo(String merchantReqNo) {
		this.merchantReqNo = merchantReqNo;
	}

	public String getBankRespNo() {
		return bankRespNo;
	}

	public void setBankRespNo(String bankRespNo) {
		this.bankRespNo = bankRespNo;
	}

	public String getTxAccount() {
		return txAccount;
	}

	public void setTxAccount(String txAccount) {
		this.txAccount = txAccount;
	}

	public String getTxAccountName() {
		return txAccountName;
	}

	public void setTxAccountName(String txAccountName) {
		this.txAccountName = txAccountName;
	}

	public String getTxAccountLineNo() {
		return txAccountLineNo;
	}

	public void setTxAccountLineNo(String txAccountLineNo) {
		this.txAccountLineNo = txAccountLineNo;
	}

	public String getTxAccountLineName() {
		return txAccountLineName;
	}

	public void setTxAccountLineName(String txAccountLineName) {
		this.txAccountLineName = txAccountLineName;
	}

	public String getAccountedDate() {
		return accountedDate;
	}

	public void setAccountedDate(String accountedDate) {
		this.accountedDate = accountedDate;
	}

	public String getAccountedTime() {
		return accountedTime;
	}

	public void setAccountedTime(String accountedTime) {
		this.accountedTime = accountedTime;
	}

	public String getTxAmount() {
		return txAmount;
	}

	public void setTxAmount(String txAmount) {
		this.txAmount = txAmount;
	}

	public String getFee() {
		return fee;
	}

	public void setFee(String fee) {
		this.fee = fee;
	}


	@Override
	public String toString() {
		return "SPDBReconItem{" +
				"merchantId='" + merchantId + '\'' +
				", merchantName='" + merchantName + '\'' +
				", secondMerchantId='" + secondMerchantId + '\'' +
				", secondMerchantName='" + secondMerchantName + '\'' +
				", txType='" + txType + '\'' +
				", txDate='" + txDate + '\'' +
				", merchantReqNo='" + merchantReqNo + '\'' +
				", merchantRespNo='" + bankRespNo + '\'' +
				", txAccount='" + txAccount + '\'' +
				", txAccountName='" + txAccountName + '\'' +
				", txAccountLineNo='" + txAccountLineNo + '\'' +
				", txAccountLineName='" + txAccountLineName + '\'' +
				", accountedDate='" + accountedDate + '\'' +
				", AccountedTime='" + accountedTime + '\'' +
				", txAmount='" + txAmount + '\'' +
				", fee='" + fee + '\'' +
				'}';
	}

}