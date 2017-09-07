/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package MyServices;


import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.centurylink.mdw.services.rest.JsonRestService;

import io.swagger.annotations.Api;


//com.centurylink.mdw.common.service.ServiceException;

/**
 * Dynamic Java workflow asset.
 */
@Path("/hello")
@Api("centhery link order")
public class Geter extends JsonRestService
{
	@GET
	@Path("/{param}")
//@Produces(MediaType.TEXT_PLAIN)
	  public JSONObject get(@PathParam("param") String msg,Map<String, String>  headers)
	{
		  pojoclass po=new pojoclass();
		  
		 String output = "Jersey say : " + msg;

			return null;
	}
	/*public JSONObject get(String param, Map<String, String> headers) throws ServiceException
	{
	      Map<String,Object> stringParams = new HashMap<String,Object>();
	      WorkflowServices workflowServices = ServiceLocator.getWorkflowServices();
	      System.out.println("rest");
	      
	    		 Object response = 
	    			
	    				 workflowServices.invokeServiceProcess("Restfull/OrderProcess", param, null, stringParams, headers);	    		 return (JSONObject) response;
	    				// String output = "Jersey say : " + param;
	}*/
	
}
