/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.noebill.tax;

import java.util.List;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;
import com.centurylink.qbat.common.Error;

import io.swagger.annotations.ApiModel;



/**
 * Dynamic Java workflow asset.
 */
@ApiModel(value = "QbatNoEbillTaxServiceResponseItems", description="QbatNoEbillTaxServiceResponseItems")
public class QbatNoEbillTaxServiceResponseItems implements Jsonable
{

	private String returnCode;
	private String status;
	private String statusText;
	
	private String taxAmount;
	
	

    public QbatNoEbillTaxServiceResponseItems(String returnCode, String status, String statusText, String taxAmount) {
		super();
		this.returnCode = returnCode;
		this.status = status;
		this.statusText = statusText;
		this.taxAmount = taxAmount;
	}



	public  QbatNoEbillTaxServiceResponseItems(JSONObject json) {
   	 	bind(json);  
    }



	public String getReturnCode() {
		return returnCode;
	}



	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}



	public String getStatus() {
		return status;
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



	public String getTaxAmount() {
		return taxAmount;
	}



	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	
	

}
