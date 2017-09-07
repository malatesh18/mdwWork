/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.noebill.tax;

import java.util.List;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;
import com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceRequestItems;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "QbatNoEbillTaxServiceRequest", description="QbatNoEbillTaxServiceRequest")
public class QbatNoEbillTaxServiceRequest  implements Jsonable
{

	@ApiModelProperty(required=true, value="Customer rep operator id")
	private String operatorId;  		
		
	@ApiModelProperty(required=true, value="QbatNoEbillTaxServiceRequestItems")
	private List<QbatNoEbillTaxServiceRequestItems> qbatNoEbillTaxServiceRequestItems;
		
		/**
	     * @param json
	     * 
	     */
	    public QbatNoEbillTaxServiceRequest(JSONObject json) {
	    	 bind(json);  
	    }

	
		
	
}
