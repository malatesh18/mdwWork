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
import com.centurylink.qbat.model.ebill.tax.QbatEbillTaxServiceRequest;
import com.centurylink.qbat.model.ebill.tax.QbatEbillTaxServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * MDW general activity.
 */
@Path("/computeEbillTax")
@Api("Ebill Tax Calculation Service")
@Tracked(LogLevel.TRACE)
public class QbatEbillTaxService extends JsonRestService { 
	@Override	
	@ApiOperation(
			value="computes Ebill Tax",
			notes="Reads QbatEbillTaxServiceRequest and computes Ebill Tax", 
			response=QbatEbillTaxServiceResponse.class)
	 @ApiImplicitParams({
	        @ApiImplicitParam(
	        		name="QbatEbillAdjServiceRequest", 
	        		paramType="body", 
	        		required=true, 
	        		dataType="com.centurylink.qbat.model.ebill.tax.QbatEbillTaxServiceRequest")
	    })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Missing elements, Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	
	 public JSONObject post(String path, JSONObject content, Map<String, String> headers) throws ServiceException{
	      
		Map<String,Object> stringParams = new HashMap<String,Object>();
		QbatEbillTaxServiceRequest qbatEbillTaxServiceRequest = null;
		
		try	{
			qbatEbillTaxServiceRequest = new QbatEbillTaxServiceRequest(content.getJSONObject("QbatEbillTaxServiceRequest"));
			
			System.out.println("******* "+qbatEbillTaxServiceRequest.getOperatorId()+" ****");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	      
	      System.out.println("QbatEbillTaxServiceRequest Processed");
	      
	      return content;
	 }
    
}