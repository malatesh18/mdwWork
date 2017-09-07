
package com.centurylink.qbat.common;


import org.json.JSONObject;

import com.centurylink.mdw.model.Jsonable;



public class Error implements Jsonable
{

    private String errorCode;
    private String errorMessage;
    private String errorType;
    
    public Error (JSONObject json) {
      	 bind(json);  
    }
    
    public Error () {
   }
    
    /**
    * 
    * @param errorMessage
    * @param errorCode
    */
    public Error(String errorCode, String errorMessage, String errorType) {
    super();
    this.errorCode = errorCode;
    this.errorMessage = errorMessage;
    this.errorType= errorType;
    }
    
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

}
