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
import com.centurylink.qbat.model.noebill.tax.QbatNoEbillTaxServiceRequest;
import com.centurylink.qbat.model.noebill.tax.QbatNoEbillTaxServiceResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * MDW general activity.
 */
@Path("/computeNoEbillTax")
@Api("NoEbill Tax Calculation Service")
@Tracked(LogLevel.TRACE)
public class QbatNoEbillTaxService extends JsonRestService { 
	@Override 	
	@ApiOperation(
			value="compute NoEbill Tax",
			notes="compute NoEbill Tax", 
			response=QbatNoEbillTaxServiceResponse.class)
	 @ApiImplicitParams({
	        @ApiImplicitParam(
	        		name="QbatNoEbillAdjServiceRequest", 
	        		paramType="body", 
	        		required=true, 
	        		dataType="com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceRequest")
	    })
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "OK"),
			@ApiResponse(code = 400, message = "Missing elements, Invalid Request"),
			@ApiResponse(code = 500, message = "Internal Server Error") })
	
	 public JSONObject post(String path, JSONObject content, Map<String, String> headers) throws ServiceException{
	      
		Map<String,Object> stringParams = new HashMap<String,Object>();
		QbatNoEbillTaxServiceRequest qbatNoEbillTaxServiceRequest = null;
		
		try
		{
			System.out.println("****************");
			qbatNoEbillTaxServiceRequest = new QbatNoEbillTaxServiceRequest(content.getJSONObject("QbatNoEbillTaxServiceRequest"));	
	
		} catch (Exception e) {
			e.printStackTrace();
		}
	      
	      System.out.println("QbatNoEbillTaxServiceRequest Processed");
	      
	      return content;
	 }
    
}