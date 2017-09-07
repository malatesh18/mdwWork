/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.noebill.tax;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QbatNoEbillTaxServiceRequestItems", description="QbatNoEbillTaxServiceRequestItems")
public class QbatNoEbillTaxServiceRequestItems  implements Jsonable
{
	@ApiModelProperty(required=false, value="State prefix code")
	private String prefix;
	@ApiModelProperty(required=true, value="Billing telephone number")
  	private String btn;
	@ApiModelProperty(required=true, value="Customer code")		 
    private String customerCode;			
	@ApiModelProperty(required=false, value="Suffix")		 
    private String suffix;		
	@ApiModelProperty(required=true, value="Type of adjustment, (CREDIT/DEBIT)")		
    private String adjustmentType ;		
	@ApiModelProperty(required=true, value="Invoice date")		
    private String invoiceDate;
	@ApiModelProperty(required=true, value="The entity code used for Adjustment")
	private String entityCode;
	@ApiModelProperty(required=true, value="The charge type used for Adjustment")
    private String chargeType;
	@ApiModelProperty(required=false, value="The USOC used for Adjustment")
    private String usoc;
	@ApiModelProperty(required=true, value="Reason Code used for Adjustment")
    private String reasonCode;
	@ApiModelProperty(required=false, value="Settlement Code used for Adjustment")
    private String settlementCode;
	@ApiModelProperty(required=true, value="Adjustment Amount used for Adjustment")
    private String adjustmentAmount;
	@ApiModelProperty(required=true, value="Adjustment Classification, U-Adjust to Satisfy, C-Billing/Service Error ")
    private String adjustmentClassification;  
	@ApiModelProperty(required=false, value="Tax Area Code  used for Adjustment")
    private String taxAreaCode;
	
	
		
	public QbatNoEbillTaxServiceRequestItems(String prefix, String btn, String customerCode, String suffix,
			String adjustmentType, String invoiceDate, String entityCode, String chargeType, String usoc,
			String reasonCode, String settlementCode, String adjustmentAmount, String adjustmentClassification,
			String taxAreaCode) {
		super();
		this.prefix = prefix;
		this.btn = btn;
		this.customerCode = customerCode;
		this.suffix = suffix;
		this.adjustmentType = adjustmentType;
		this.invoiceDate = invoiceDate;
		this.entityCode = entityCode;
		this.chargeType = chargeType;
		this.usoc = usoc;
		this.reasonCode = reasonCode;
		this.settlementCode = settlementCode;
		this.adjustmentAmount = adjustmentAmount;
		this.adjustmentClassification = adjustmentClassification;
		this.taxAreaCode = taxAreaCode;
	}



	public String getPrefix() {
		return prefix;
	}



	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}



	public String getBtn() {
		return btn;
	}



	public void setBtn(String btn) {
		this.btn = btn;
	}



	public String getCustomerCode() {
		return customerCode;
	}



	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}



	public String getSuffix() {
		return suffix;
	}



	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}



	public String getAdjustmentType() {
		return adjustmentType;
	}



	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}



	public String getInvoiceDate() {
		return invoiceDate;
	}



	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}



	public String getEntityCode() {
		return entityCode;
	}



	public void setEntityCode(String entityCode) {
		this.entityCode = entityCode;
	}



	public String getChargeType() {
		return chargeType;
	}



	public void setChargeType(String chargeType) {
		this.chargeType = chargeType;
	}



	public String getUsoc() {
		return usoc;
	}



	public void setUsoc(String usoc) {
		this.usoc = usoc;
	}



	public String getReasonCode() {
		return reasonCode;
	}



	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}



	public String getSettlementCode() {
		return settlementCode;
	}



	public void setSettlementCode(String settlementCode) {
		this.settlementCode = settlementCode;
	}



	public String getAdjustmentAmount() {
		return adjustmentAmount;
	}



	public void setAdjustmentAmount(String adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}



	public String getAdjustmentClassification() {
		return adjustmentClassification;
	}



	public void setAdjustmentClassification(String adjustmentClassification) {
		this.adjustmentClassification = adjustmentClassification;
	}



	public String getTaxAreaCode() {
		return taxAreaCode;
	}



	public void setTaxAreaCode(String taxAreaCode) {
		this.taxAreaCode = taxAreaCode;
	}



	/**
     * @param json
     * 
     */
    public QbatNoEbillTaxServiceRequestItems(JSONObject json) {
    	 bind(json);  
    }

}
