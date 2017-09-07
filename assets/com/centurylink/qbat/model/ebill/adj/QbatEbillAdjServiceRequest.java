/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.ebill.adj;

import java.util.List;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "QbatEbillAdjServiceRequest", description="QbatEbillAdjServiceRequest")
public class QbatEbillAdjServiceRequest  implements Jsonable
{
	
		@ApiModelProperty(required=true, value="Adjustment Note used for Adjustment")
	    private String adjustmentNote; 
		
		@ApiModelProperty(required=true, value="Customer rep operator id")
		private String operatorId;  
		
		@ApiModelProperty(required=true, value="Qbat Ebill Adjustment Service Request Items")
		private List<QbatEbillAdjServiceRequestItems> qbatEbillAdjServiceRequestItems;

		
		public String getAdjustmentNote() {
			return adjustmentNote;
		}

		public void setAdjustmentNote(String adjustmentNote) {
			this.adjustmentNote = adjustmentNote;
		}

		public String getOperatorId() {
			return operatorId;
		}

		public void setOperatorId(String operatorId) {
			this.operatorId = operatorId;
		}

		public List<QbatEbillAdjServiceRequestItems> getQbatEbillAdjServiceRequestItems() {
			return qbatEbillAdjServiceRequestItems;
		}
		
		public void setQbatEbillAdjServiceRequestItems(List<QbatEbillAdjServiceRequestItems> qbatEbillAdjServiceRequestItems) {
			this.qbatEbillAdjServiceRequestItems = qbatEbillAdjServiceRequestItems;
		}
		
		/**
	     * @param json
	     * 
	     */
	    public QbatEbillAdjServiceRequest(JSONObject json) {
	    	 bind(json);   //populate this object by eleminating delimiter
	    } 
		
}
