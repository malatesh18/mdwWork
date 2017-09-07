/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.noebill.adj;

import java.util.List;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;
import com.centurylink.qbat.common.Error;

import io.swagger.annotations.ApiModel;



/**
 * Dynamic Java workflow asset.
 */
@ApiModel(value = "QbatNoEbillAdjServiceResponseItems", description="QbatNoEbillAdjServiceResponseItems")
public class QbatNoEbillAdjServiceResponseItems implements Jsonable
{
	private String adjRefId;
	private String returnCode;
	private String status;
	private String statusText;
	
	

    public  QbatNoEbillAdjServiceResponseItems(JSONObject json) {
   	 	bind(json);  
    }



	public QbatNoEbillAdjServiceResponseItems(String adjRefId, String returnCode, String status, String statusText) {
		super();
		this.adjRefId = adjRefId;
		this.returnCode = returnCode;
		this.status = status;
		this.statusText = statusText;
	}



	public String getAdjRefId() {
		return adjRefId;
	}



	public void setAdjRefId(String adjRefId) {
		this.adjRefId = adjRefId;
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

	
}
