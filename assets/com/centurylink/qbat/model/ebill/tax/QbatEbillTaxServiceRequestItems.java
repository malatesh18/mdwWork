/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.ebill.tax;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QbatEbillTaxServiceRequestItems", description="QbatEbillTaxServiceRequestItems")
public class QbatEbillTaxServiceRequestItems  implements Jsonable
{
	@ApiModelProperty(required=true, value="ChargeId, Value should be in the format btn_cc_billdate_structseq_salesforceid eg:- 3073627100_201_5/22/2017_12_sf")
	private String chargeId;
	
	@ApiModelProperty(required=true, value="Reason Code used for calculating Tax")
    private String adjustmentReasonCode;

	
	@ApiModelProperty(required=true, value="Adjustment Amount for Tax Calculation")
	private String adjustmentAmount;
	
	
	@ApiModelProperty(required=true, value="CREDIT/DEBIT, By default its CREDIT")
	private String adjustmentType;

	
	public QbatEbillTaxServiceRequestItems(String chargeId, String adjustmentReasonCode, String adjustmentAmount,
			String adjustmentType) {
		super();
		this.chargeId = chargeId;
		this.adjustmentReasonCode = adjustmentReasonCode;
		this.adjustmentAmount = adjustmentAmount;
		this.adjustmentType = adjustmentType;
	}


	public String getChargeId() {
		return chargeId;
	}


	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}


	public String getAdjustmentReasonCode() {
		return adjustmentReasonCode;
	}


	public void setAdjustmentReasonCode(String adjustmentReasonCode) {
		this.adjustmentReasonCode = adjustmentReasonCode;
	}


	public String getAdjustmentAmount() {
		return adjustmentAmount;
	}


	public void setAdjustmentAmount(String adjustmentAmount) {
		this.adjustmentAmount = adjustmentAmount;
	}


	public String getAdjustmentType() {
		return adjustmentType;
	}


	public void setAdjustmentType(String adjustmentType) {
		this.adjustmentType = adjustmentType;
	}


	/**
     * @param json
     * 
     */
    public QbatEbillTaxServiceRequestItems(JSONObject json) {
    	 bind(json);  
    }

}
