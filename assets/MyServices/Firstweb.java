/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package MyServices;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONObject;

import com.centurylink.mdw.common.service.ServiceException;
import com.centurylink.mdw.services.ServiceLocator;
import com.centurylink.mdw.services.WorkflowServices;



/**
 * Dynamic Java workflow asset.
 */
@Path("/Help")
public class Firstweb 
{
	@GET
	//@Path("/ok")
	@Produces(MediaType.APPLICATION_JSON)
	  public String sayPlainTextHello()
	{
		System.out.println("higgggggg");
	    return "Hello this is  Jersey";
	}
}
	/*public JSONObject get(String path) throws ServiceException
	{
		 WorkflowServices workflowServices= ServiceLocator.getWorkflowServices();
		 Object response=workflowServices.invokeServiceProcess(arg0, arg1, arg2, arg3, arg4);
		System.out.println("ff f");
		
		return (JSONObject) response ;
		
	}*/
	

