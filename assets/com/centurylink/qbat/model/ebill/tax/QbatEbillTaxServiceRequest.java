/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.ebill.tax;

import java.util.List;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;
import com.centurylink.qbat.model.ebill.adj.QbatEbillAdjServiceRequestItems;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "QbatEbillTaxServiceRequest", description="QbatEbillTaxServiceRequest")
public class QbatEbillTaxServiceRequest  implements Jsonable
{
		

	@ApiModelProperty(required=true, value="Customer rep operator id")
	private String operatorId;  
	
	@ApiModelProperty(required=true, value="Qbat Ebill Tax Service Request Items")
	private List<QbatEbillTaxServiceRequestItems> qbatEbillTaxServiceRequestItems;
	
	
	public QbatEbillTaxServiceRequest(String operatorId,
			List<QbatEbillTaxServiceRequestItems> qbatEbillTaxServiceRequestItems) {
		super();
		this.operatorId = operatorId;
		this.qbatEbillTaxServiceRequestItems = qbatEbillTaxServiceRequestItems;
	}

	public String getOperatorId() {
		return operatorId;
	}

	public void setOperatorId(String operatorId) {
		this.operatorId = operatorId;
	}

	public List<QbatEbillTaxServiceRequestItems> getQbatEbillTaxServiceRequestItems() {
		return qbatEbillTaxServiceRequestItems;
	}

	public void setQbatEbillTaxServiceRequestItems(List<QbatEbillTaxServiceRequestItems> qbatEbillTaxServiceRequestItems) {
		this.qbatEbillTaxServiceRequestItems = qbatEbillTaxServiceRequestItems;
	}

	
		/**
	     * @param json
	     * 
	     */
	    public QbatEbillTaxServiceRequest(JSONObject json) {
	    	 bind(json);   //populate this object by eleminating delimiter
	    }

		
		

		
}
