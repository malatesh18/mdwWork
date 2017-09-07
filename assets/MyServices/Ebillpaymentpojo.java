/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package MyServices;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Dynamic Java workflow asset.
 */

@JsonIgnoreProperties(ignoreUnknown = true)

public class Ebillpaymentpojo implements java.io.Serializable
{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonProperty("BTN")
	private String  BTN;
	
	@JsonProperty("CustomerCode")
	private String CustomerCode;
	
	
	@JsonProperty("AdjustmentType")
	private String AdjustmentType; 
	
	@JsonProperty("BillDate")
	private String BillDate; 
	
	@JsonProperty("EntityCode")
	private String EntityCode; 
	@JsonProperty("ChargeType")
	private String ChargeType; 
	@JsonProperty("USOC")
	private String USOC; 
	@JsonProperty("ReasonCode")
	private String ReasonCode; 
	@JsonProperty("SettlementCode")
	private String SettlementCode; 
	
	@JsonProperty("AdjustmentAmount")
	private String AdjustmentAmount;
	
	@JsonProperty("AdjustmentNote")
	private String AdjustmentNote;
	
	@JsonProperty("PermNote")
	private String PermNote;
	@JsonProperty("TaxAreaCode")
	private String TaxAreaCode;
	
	public String getBTN() {
		return BTN;
	}
	public void setBTN(String bTN) {
		BTN = bTN;
	}
	public String getBillDate() {
		return BillDate;
	}
	public void setBillDate(String billDate) {
		BillDate = billDate;
	}
	public String getEntityCode() {
		return EntityCode;
	}
	public void setEntityCode(String entityCode) {
		EntityCode = entityCode;
	}
	public String getChargeType() {
		return ChargeType;
	}
	public void setChargeType(String chargeType) {
		ChargeType = chargeType;
	}
	public String getUSOC() {
		return USOC;
	}
	public void setUSOC(String uSOC) {
		USOC = uSOC;
	}
	public String getReasonCode() {
		return ReasonCode;
	}
	public void setReasonCode(String reasonCode) {
		ReasonCode = reasonCode;
	}
	public String getSettlementCode() {
		return SettlementCode;
	}
	public void setSettlementCode(String settlementCode) {
		SettlementCode = settlementCode;
	}
	public String getAdjustmentAmount() {
		return AdjustmentAmount;
	}
	public void setAdjustmentAmount(String adjustmentAmount) {
		AdjustmentAmount = adjustmentAmount;
	}
	public String getAdjustmentNote() {
		return AdjustmentNote;
	}
	public void setAdjustmentNote(String adjustmentNote) {
		AdjustmentNote = adjustmentNote;
	}
	public String getPermNote() {
		return PermNote;
	}
	public void setPermNote(String permNote) {
		PermNote = permNote;
	}
	public String getTaxAreaCode() {
		return TaxAreaCode;
	}
	public void setTaxAreaCode(String taxAreaCode) {
		TaxAreaCode = taxAreaCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getCustomerCode() {
		return CustomerCode;
	}
	public void setCustomerCode(String customerCode) {
		CustomerCode = customerCode;
	}
	public String getAdjustmentType() {
		return AdjustmentType;
	}
	public void setAdjustmentType(String adjustmentType) {
		AdjustmentType = adjustmentType;
	}
	
	
}
