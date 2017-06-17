package org.simon.zhao.spring.batch.record;

/**
 * @author Zhaozhou
 * @date 2017/5/22
 */
public class VpalRecondItem {
	private String transType;
	private String transDate;
	private String transTime;
	private String bankOrdNo;
	private String transAmount;
	private String transNo;
	private String uasNo;
	private String usaOriginNo;

	public String getTransType() {
		return transType;
	}

	public void setTransType(String transType) {
		this.transType = transType;
	}

	public String getTransDate() {
		return transDate;
	}

	public void setTransDate(String transDate) {
		this.transDate = transDate;
	}

	public String getBankOrdNo() {
		return bankOrdNo;
	}

	public void setBankOrdNo(String bankOrdNo) {
		this.bankOrdNo = bankOrdNo;
	}

	public String getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(String transAmount) {
		this.transAmount = transAmount;
	}

	public String getTransNo() {
		return transNo;
	}

	public void setTransNo(String transNo) {
		this.transNo = transNo;
	}

	public String getUasNo() {
		return uasNo;
	}

	public void setUasNo(String uasNo) {
		this.uasNo = uasNo;
	}

	public String getUsaOriginNo() {
		return usaOriginNo;
	}

	public void setUsaOriginNo(String usaOriginNo) {
		this.usaOriginNo = usaOriginNo;
	}

	public String getTransTime() {return transTime;}

	public void setTransTime(String transTime) {this.transTime = transTime;}

	@Override
	public String toString() {
		return "VpalRecondItem{" +
				"transType='" + transType + '\'' +
				", transDate='" + transDate + '\'' +
				", transTime='" + transTime + '\'' +
				", bankOrdNo='" + bankOrdNo + '\'' +
				", transAmount='" + transAmount + '\'' +
				", transNo='" + transNo + '\'' +
				", uasNo='" + uasNo + '\'' +
				", usaOriginNo='" + usaOriginNo + '\'' +
				'}';
	}
}
