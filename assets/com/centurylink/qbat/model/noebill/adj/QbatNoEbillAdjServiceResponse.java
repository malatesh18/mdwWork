/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.noebill.adj;

import java.util.List;

import com.centurylink.mdw.model.Jsonable;
import com.centurylink.qbat.model.ebill.adj.QbatEbillAdjServiceResponseItems;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;



/**
 * Dynamic Java workflow asset.
 */
@ApiModel(value = "QbatNoEbillAdjServiceResponse", description="QbatNoEbillAdjServiceResponse")
public class QbatNoEbillAdjServiceResponse implements Jsonable
{   
		
    @ApiModelProperty(required=true, value="Individual Item Status")
	private List<QbatNoEbillAdjServiceResponseItems> qbatNoEbillAdjServiceResponseItems;

	public List<QbatNoEbillAdjServiceResponseItems> getQbatNoEbillAdjServiceResponseItems() {
		return qbatNoEbillAdjServiceResponseItems;
	}

	public void setQbatNoEbillAdjServiceResponseItems(
			List<QbatNoEbillAdjServiceResponseItems> qbatNoEbillAdjServiceResponseItems) {
		this.qbatNoEbillAdjServiceResponseItems = qbatNoEbillAdjServiceResponseItems;
	}
    

}
