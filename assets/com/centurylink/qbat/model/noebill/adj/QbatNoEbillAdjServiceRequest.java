/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package com.centurylink.qbat.model.noebill.adj;

import java.util.List;

import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@ApiModel(value = "QbatNoEbillAdjServiceRequest", description="QbatNoEbillAdjServiceRequest")
public class QbatNoEbillAdjServiceRequest  implements Jsonable
{

		
		@ApiModelProperty(required=true, value="Customer rep operator id")
		private String operatorId;  
		
		@ApiModelProperty(required=true, value="Adjustment Note used for Adjustment")
	    private String adjustmentNote; 
		
		public String getOperatorId() {
			return operatorId;
		}



		public void setOperatorId(String operatorId) {
			this.operatorId = operatorId;
		}



		public String getAdjustmentNote() {
			return adjustmentNote;
		}



		public void setAdjustmentNote(String adjustmentNote) {
			this.adjustmentNote = adjustmentNote;
		}



		public List<QbatNoEbillAdjServiceRequestItems> getQbatNoEbillAdjServiceRequestItems() {
			return qbatNoEbillAdjServiceRequestItems;
		}



		public void setQbatNoEbillAdjServiceRequestItems(
				List<QbatNoEbillAdjServiceRequestItems> qbatNoEbillAdjServiceRequestItems) {
			this.qbatNoEbillAdjServiceRequestItems = qbatNoEbillAdjServiceRequestItems;
		}



		@ApiModelProperty(required=true, value="crisNoEbillAdjRequestItems")
		private List<QbatNoEbillAdjServiceRequestItems> qbatNoEbillAdjServiceRequestItems;
		
		
		
		/**
	     * @param json
	     * 
	     */
	    public QbatNoEbillAdjServiceRequest(JSONObject json) {
	    	 bind(json);  
	    }

		
	
}
