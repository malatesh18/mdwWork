/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.noebill.tax;

import java.util.List;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;

import com.centurylink.qbat.common.Error;
import com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceResponseItems;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Dynamic Java workflow asset.
 */
@ApiModel(value = "QbatNoEbillTaxServiceResponse", description="QbatNoEbillTaxServiceResponse")
public class QbatNoEbillTaxServiceResponse implements Jsonable
{

  
	@ApiModelProperty(required=true, value="Individual Item Status")
	private List<QbatNoEbillTaxServiceResponseItems> qbatNoEbillTaxServiceResponseItems;
	
	public QbatNoEbillTaxServiceResponse(List<QbatNoEbillTaxServiceResponseItems> qbatNoEbillTaxServiceResponseItems) {
		super();
		this.qbatNoEbillTaxServiceResponseItems = qbatNoEbillTaxServiceResponseItems;
	}
	
	public  QbatNoEbillTaxServiceResponse(JSONObject json) {
   	 bind(json);  
   }

	public List<QbatNoEbillTaxServiceResponseItems> getQbatNoEbillTaxServiceResponseItems() {
		return qbatNoEbillTaxServiceResponseItems;
	}

	public void setQbatNoEbillTaxServiceResponseItems(
			List<QbatNoEbillTaxServiceResponseItems> qbatNoEbillTaxServiceResponseItems) {
		this.qbatNoEbillTaxServiceResponseItems = qbatNoEbillTaxServiceResponseItems;
	}

}
