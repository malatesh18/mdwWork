/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package MyServices;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Path;

import org.json.JSONObject;

import com.centurylink.mdw.common.service.ServiceException;
import com.centurylink.mdw.common.service.types.StatusMessage;
import com.centurylink.mdw.services.ServiceLocator;
import com.centurylink.mdw.services.WorkflowServices;
import com.centurylink.mdw.services.rest.JsonRestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
/**
 * Dynamic Java workflow asset.
 */
@Path("/Order")
@Api("centery link order")
public class Orders extends JsonRestService
{
	@Override
	 @ApiOperation(value="Create an order",
	  notes="Does not actually create anything as yet.", response=StatusMessage.class)
	  @ApiImplicitParams({@ApiImplicitParam(name="Order", paramType="body", dataType="MyServices.Order")})

	 public JSONObject post(String path, JSONObject content, Map<String, String> headers) throws ServiceException
	{
	      Map<String,Object> stringParams = new HashMap<String,Object>();
	      WorkflowServices workflowServices = ServiceLocator.getWorkflowServices();
	      System.out.println("rest"+content);
	    		 Object response = 
	    				 workflowServices.invokeServiceProcess("Restfull/OrderProcess", content, null, stringParams, headers);
	    		 return (JSONObject) response;
	  }

}
