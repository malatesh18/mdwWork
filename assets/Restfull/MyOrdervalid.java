/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package Restfull;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.XML;

import com.centurylink.mdw.activity.ActivityException;
import com.centurylink.mdw.model.workflow.ActivityRuntimeContext;
import com.centurylink.mdw.util.log.StandardLogger.LogLevel;
import com.centurylink.mdw.util.timer.Tracked;
import com.centurylink.mdw.workflow.activity.DefaultActivityImpl;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qwest.xmlSchema.qbat.qbatProcessRequest.ProcessRequestDocument;
import com.qwest.xmlSchema.qbat.qbatProcessRequest.ProcessRequestTypeT;
import com.qwest.xmlSchema.qbat.qbatProcessRequest.QbatProcessRequestT;
import com.qwest.xmlSchema.qbat.taskRequest.TaskRequestT;


import MyServices.processpojo;

/**
 * MDW general activity.
 */
@Tracked(LogLevel.TRACE)
public class MyOrdervalid extends DefaultActivityImpl {

    /**
     * Here's where the main processing for the activity is performed.
     *     
     * @return the activity result (aka completion code)
     */
	// C mProcessRequest=null;
	private static Logger mLogger = LogManager.getLogger(MyOrdervalid.class);    
	@Override
	@JsonIgnoreProperties(ignoreUnknown = true)
	public Object execute(ActivityRuntimeContext runtimeContext) throws ActivityException {
    	mLogger.info("Validating order...");
         boolean valid = false;
         try {
        	 processpojo po=null;
        	 JSONObject jsonObj = (JSONObject) getVariableValue("request");
        	 /*String ARRefId = (String) jsonObj.get("ARRefId");
        	 setVariableValue("ARRefId", ARRefId);
        	 String TaskRequest = (String) jsonObj.get("TaskRequest");
        	 setVariableValue("TaskRequest", TaskRequest);*/
        	 
        	 
        	// System.out.println("www"+jsonObj);
        	 byte[] jsonData = jsonObj.toString().getBytes();
  	       ObjectMapper mapper=new ObjectMapper();
			po=mapper.readValue(jsonData, processpojo.class);
        	 //String xml_data = XML.toString(jsonObj);
        	 //System.out.println(xml_data);
        	// XsdGen gen = new XsdGen();
        	
        	 ProcessRequestDocument mProcessRequest = ProcessRequestDocument.Factory.newInstance();
             QbatProcessRequestT mReqT = mProcessRequest.addNewProcessRequest();
             mReqT.setARRefId(po.getARRefId());
             mReqT.setRequestType(po.getRequestType());
             mReqT.setRequestSubType(po.getRequestSubType());
             mReqT.setProcessRequestType(ProcessRequestTypeT.QB_TRANSMIT_AR);
           
             TaskRequestT task = mReqT.addNewTaskRequest();
            task.setARRefId(po.getTaskRequest().getARRefId());
            task.setCreateUser(po.getTaskRequest().getCreateUser());
            String msg = "Success";
            valid = msg.equals("Success");

            setVariableValue("validationResult",msg);

             System.out.println(mProcessRequest);
         } catch (Exception ex) {
             throw new ActivityException(ex.getMessage(), ex);
         }
        
         return valid;

    
}
	/*private void setVariableValue(String string, String orderId) {
		// TODO Auto-generated method stub
		
	}
	private JSONObject getVariableValue(String string) {
		// TODO Auto-generated method stub
		return null;
	}*/
}

/*String orderId = (String) jsonObj.get("orderId");
setVariableValue("orderId", orderId);
String msg = "Success";
System.out.println("sucess"+jsonObj+"order"+orderId);
if (!jsonObj.has("orderId")){
    msg = "Missing order ID.";
}
else if (!Character.isDigit(orderId.charAt(0))) {
    msg = "Order ID must begin with a digit.";	        
}
valid = msg.equals("Success");

setVariableValue("validationResult",msg);

// return valid;
*/            
