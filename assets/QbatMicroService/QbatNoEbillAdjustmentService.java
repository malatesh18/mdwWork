/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package QbatMicroService;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

import javax.ws.rs.Path;

import org.json.JSONObject;

import com.centurylink.mdw.common.service.ServiceException;

import com.centurylink.mdw.services.rest.JsonRestService;
import com.centurylink.mdw.util.log.StandardLogger.LogLevel;
import com.centurylink.mdw.util.timer.Tracked;
import com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceRequest;
import com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceResponse;
import com.qwest.xmlSchema.qbat.userProfile.UserProfileInfoT;

import MyServices.ConstructChild;
import MyServices.ConstructChildAccount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * MDW general activity.
 */
@Path("/createNoEbillAdjustment")
@Api("Qbat No Ebill Adjustment Micro Service")
@Tracked(LogLevel.TRACE)
public class QbatNoEbillAdjustmentService extends JsonRestService { 
	@Override 	
	@ApiOperation(
			value="Creates No Ebill Adjusment",
			notes="Reads QbatNoEbillAdjServiceRequest and Creates No Ebill Adjusment", 
			response=QbatNoEbillAdjServiceResponse.class)
	 @ApiImplicitParams({
	        @ApiImplicitParam(
	        		name="CrisNoEbillAdjServiceRequest", 
	        		paramType="body", 
	        		required=true, 
	        		dataType="com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceRequest")
	    })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Missing elements, Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	
	
	
	
	
	
	 public JSONObject post(String path, JSONObject content, Map<String, String> headers) throws ServiceException{
	      
		@SuppressWarnings("unused")
		Map<String,Object>  stringParams = new HashMap<String,Object>();
		QbatNoEbillAdjServiceRequest  qbatNoEbillAdjServiceRequest = null;
		
		UserProfileInfoT aUserProfileInfo = null;
		long aTotalRecords = 0;
		 ExecutorService execSvc = null;
		try {
			qbatNoEbillAdjServiceRequest = new QbatNoEbillAdjServiceRequest(content.getJSONObject("QbatNoEbillAdjServiceRequest"));			
			System.out.println("SSS"+qbatNoEbillAdjServiceRequest.getQbatNoEbillAdjServiceRequestItems().iterator().next().getAdjustmentAmount());
			ConstructChildAccount constructchild=new ConstructChildAccount();
			
			constructchild.constructChildBR(qbatNoEbillAdjServiceRequest, aUserProfileInfo, aTotalRecords, execSvc);
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	      
	      System.out.println("QbatNoEbillAdjustmentService Processed");
	      
	      return content;
	 }
    
}