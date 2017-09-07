/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package ClientServices;


import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.centurylink.mdw.common.service.types.Resource;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

//import org.glassfish.jersey.client.ClientConfig;



/**
 * Dynamic Java workflow asset.
 */

public class ClientRestfull implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String args[]) 
	{
		try {

			Client client = Client.create();

			WebResource webResource = client
			   .resource("http://localhost:8080/mdw/services/MyServices/Order");
			JSONObject json=new JSONObject();
			json.put("ARRefId", 123213);
			json.put("RequestType", "ADJUSTMENT");
			json.put("RequestSubType", "CREDIT");
			JSONObject task=new JSONObject();
			task.put("ARRefId",  123213);
			task.put("CreateUser", "kkk");
			json.put("TaskRequest",task);
			//String input ="{\"orderId\":\"96778\"}";
			System.out.println(json);
			/*ClientResponse response =webResource.type(MediaType.APPLICATION_OCTET_STREAM)
			   .post(ClientResponse.class, json);*/
			ClientResponse response=webResource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class,json.toString());
			System.out.println(response);

			if (response.getStatus() != 200) {
				throw new RuntimeException("Failed : HTTP error code : "
				     + response.getStatus());
			}

			System.out.println("Output from Server .... \n");
			String output = response.getEntity(String.class);
			System.out.println(output);
			System.out.println(output);
		  } catch (Exception e) {

			e.printStackTrace();

		  }

	}

	
}
