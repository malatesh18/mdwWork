/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package MyServices;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Dynamic Java workflow asset.
 */
public class processpojo implements java.io.Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("TaskRequest")
	private TaskRequest TaskRequest;

	@JsonProperty("ARRefId")
	private Long ARRefId;
	
	public String getRequestType() {
		return RequestType;
	}

	public void setRequestType(String requestType) {
		RequestType = requestType;
	}

	public String getRequestSubType() {
		return RequestSubType;
	}

	public void setRequestSubType(String requestSubType) {
		RequestSubType = requestSubType;
	}

	@JsonProperty("RequestType")
	private String RequestType;
	@JsonProperty("RequestSubType")
	private String RequestSubType;


    public TaskRequest getTaskRequest ()
    {
        return TaskRequest;
    }

    public void setTaskRequest (TaskRequest TaskRequest)
    {
        this.TaskRequest = TaskRequest;
    }

  

    public Long getARRefId() {
		return ARRefId;
	}

	public void setARRefId(Long aRRefId) {
		ARRefId = aRRefId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
    public String toString()
    {
        return "ClassPojo [TaskRequest = "+TaskRequest+", ARRefId = "+ARRefId+"]";
    };
	
}
