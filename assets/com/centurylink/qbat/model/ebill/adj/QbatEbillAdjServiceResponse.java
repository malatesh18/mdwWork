/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.ebill.adj;

import java.util.List;

import com.centurylink.mdw.model.Jsonable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Dynamic Java workflow asset.
 */
@ApiModel(value = "QbatEbillAdjServiceResponse", description="QbatEbillAdjServiceResponse")
public class QbatEbillAdjServiceResponse implements Jsonable
{
    @ApiModelProperty(required=true, value="Individual Item Response")
	private List<QbatEbillAdjServiceResponseItems> qbatEbillAdjServiceResponseItems;
    

	public List<QbatEbillAdjServiceResponseItems> getQbatEbillAdjServiceResponseItems() {
		return qbatEbillAdjServiceResponseItems;
	}

	public void setQbatEbillAdjServiceResponseItems(
			List<QbatEbillAdjServiceResponseItems> qbatEbillAdjServiceResponseItems) {
		this.qbatEbillAdjServiceResponseItems = qbatEbillAdjServiceResponseItems;
	}
    
    

}
