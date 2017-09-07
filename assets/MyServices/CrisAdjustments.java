/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package MyServices;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.centurylink.mdw.common.service.ServiceException;
import com.centurylink.mdw.common.service.types.StatusMessage;
import com.centurylink.mdw.services.ServiceLocator;
import com.centurylink.mdw.services.WorkflowServices;
import com.centurylink.mdw.services.rest.JsonRestService;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Dynamic Java workflow asset.
 * @param <PersonResponse>
 */
@Path("/person")
@Api("Person order")
/*@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)*/
public class CrisAdjustments  extends JsonRestService
{
	 /**
	 * 
	 */
	

	
	   @GET
	   @ApiOperation(value = "Find person by e-mail",
	              notes = "Find  person by e-mail", response = Ebillpaymentpojo.class)
	public Response findPerson(
			  @ApiParam(value = "E-Mail address to lookup for", required = true)
			   @QueryParam("email") final String email) {
				return null;

	 }
	    
	 
	 @POST
	 @ApiOperation(value = "Create new personss",
 notes = "Create new person", response = pojoclass.class)
	
	 @ApiImplicitParams({
		    @ApiImplicitParam(name = "BTN", value = "CRIS account number", required = true, type = "String" , paramType = "query"),
		   @ApiImplicitParam(name = "Customer Code", value = "Unique customer code for the BTN", required = false, dataType = "string", paramType = "form"),
		    @ApiImplicitParam(name = "Adjustment Type ", value = "Credit or Debit", required = true,dataType = "string", paramType = "form"),
		    @ApiImplicitParam(name = "BillDate", value = "The invoice we want to adjust.", required = true, paramType = "form"),
		    @ApiImplicitParam(name = "EntityCode", value = "CRIS Entity Code", required = true, paramType = "form"),
		    @ApiImplicitParam(name = "ChargeType", value = "See attached field definition document", required = true, paramType = "form"),
		    @ApiImplicitParam(name = "USOC", value = "See attached field definition document", required = false, paramType = "form"),
		    @ApiImplicitParam(name = "ReasonCode", value = "Adjustment reason code. ", required = true, paramType = "form"),
		    @ApiImplicitParam(name = "SettlementCode",  required = false, paramType = "form"),
		    @ApiImplicitParam(name = "AdjustmentAmount",  required = true, paramType = "form"),
		    @ApiImplicitParam(name = "AdjustmentClassification", value = "See attached field definition document", required = true, paramType = "form"),
		    @ApiImplicitParam(name = "AdjustmentNote", value = "Any note the business wants on the billing request that is being created in QBAT. This could be a canned value.", required = true, paramType = "form"),
		    @ApiImplicitParam(name = "Perm Note", value = "See attached field definition document", required = false, paramType = "form"),
	    @ApiImplicitParam(name = "Tax", value = "Optional override of the Tax Area code that is on the account.", required = false, paramType = "query",type="string"),

	 })
	 @JsonIgnoreProperties(ignoreUnknown = true)
	 public JSONObject post (String path, JSONObject content, Map<String, String> headers ){
		  Ebillpaymentpojo st = null;
		 System.out.println("Creating a person"+path+content);
	       byte[] jsonData = content.toString().getBytes();
	       ObjectMapper mapper=new ObjectMapper();
mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
System.out.println(jsonData);

		
		
				try {
				

					st=mapper.readValue(jsonData, Ebillpaymentpojo.class);
					
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		
		 

	
System.out.println("Btn"+st.getBTN()+" "+"customercode"+st.getCustomerCode()+st.getPermNote());
	    return null;
	 }
	
}
