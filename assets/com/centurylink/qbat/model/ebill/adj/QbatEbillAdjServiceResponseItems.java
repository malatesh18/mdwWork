/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.ebill.adj;

import java.util.List;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;
import com.centurylink.qbat.common.Error;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Dynamic Java workflow asset.
 */
@ApiModel(value = "QbatEbillAdjServiceResponseItems", description="QbatEbillAdjServiceResponseItems")
public class QbatEbillAdjServiceResponseItems implements Jsonable
{
	
	

	@ApiModelProperty(required=true, value="ChargeId, this will be same chargeId received in the request")
	private String chargeId;
	
	private String returnCode;
	private String status;
	private String statusText;
	private String adjRefId;
	
    
	
    
    public String getAdjRefId() {
		return adjRefId;
	}

	public void setAdjRefId(String adjRefId) {
		this.adjRefId = adjRefId;
	}

	public String getChargeId() {
  		return chargeId;
  	}
    
    public String getStatus() {
		return status;
	}
	
	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusText() {
		return statusText;
	}

	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}
    
	
    

}
