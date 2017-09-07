/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.ebill.tax;

import java.util.List;

import com.centurylink.mdw.model.Jsonable;
import com.centurylink.qbat.model.ebill.adj.QbatEbillAdjServiceResponseItems;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Dynamic Java workflow asset.
 */
@ApiModel(value = "QbatEbillTaxServiceResponse", description="QbatEbillTaxServiceResponse")
public class QbatEbillTaxServiceResponse implements Jsonable
{
	public QbatEbillTaxServiceResponse(List<QbatEbillTaxServiceResponseItems> qbatEbillTaxServiceResponseItems) {
		super();
		this.qbatEbillTaxServiceResponseItems = qbatEbillTaxServiceResponseItems;
	}

	@ApiModelProperty(required=true, value="Individual Item Response")
	private List<QbatEbillTaxServiceResponseItems> qbatEbillTaxServiceResponseItems;

	public List<QbatEbillTaxServiceResponseItems> getQbatEbillTaxServiceResponseItems() {
		return qbatEbillTaxServiceResponseItems;
	}

	public void setQbatEbillTaxServiceResponseItems(
			List<QbatEbillTaxServiceResponseItems> qbatEbillTaxServiceResponseItems) {
		this.qbatEbillTaxServiceResponseItems = qbatEbillTaxServiceResponseItems;
	}

	
		

}
