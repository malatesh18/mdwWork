/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package QbatMicroService;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Path;

import org.json.JSONObject;

import com.centurylink.mdw.common.service.ServiceException;
import com.centurylink.mdw.services.rest.JsonRestService;
import com.centurylink.mdw.util.log.StandardLogger.LogLevel;
import com.centurylink.mdw.util.timer.Tracked;
import com.centurylink.qbat.model.ebill.adj.QbatEbillAdjServiceRequest;
import com.centurylink.qbat.model.ebill.adj.QbatEbillAdjServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * MDW general activity.
 */
@Path("/createEbillAdjustment")
@Api("Qbat Ebill Adjustment Micro Service")
@Tracked(LogLevel.TRACE)
public class QbatEbillAdjustmentService extends JsonRestService { 
	@Override 
	@ApiOperation(
			value="Creates Ebill Adjusment",
			notes="Reads QbatEbillAdjServiceRequest and Creates Ebill Adjusment", 
			response=QbatEbillAdjServiceResponse.class) 
	 @ApiImplicitParams({
	    @ApiImplicitParam(
	    	name="QbatEbillAdjServiceRequest",
	    	value="QbatEbillAdjServiceRequest", 
	    	paramType="body", 
	    	required=true, 
	    	dataType="com.centurylink.qbat.model.ebill.adj.QbatEbillAdjServiceRequest")
	    })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Missing elements, Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })	
	
	 public JSONObject post(String path, JSONObject content, Map<String, String> headers) throws ServiceException{
	      
		Map<String,Object> stringParams = new HashMap<String,Object>();
		QbatEbillAdjServiceRequest  qbatEbillAdjServiceRequest = null;
		
		try	{
			qbatEbillAdjServiceRequest = new QbatEbillAdjServiceRequest(content.getJSONObject("QbatEbillAdjServiceRequest"));
			
			System.out.println("*********************************");
					
					System.out.println(qbatEbillAdjServiceRequest.getAdjustmentNote());
					//
					System.out.println("*********************************");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	      
	      System.out.println("QbatEbillAdjServiceRequest Processed");
	      
	      return content;
	 }
    
}