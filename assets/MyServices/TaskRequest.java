/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package MyServices;



import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * Dynamic Java workflow asset.
 */

public class TaskRequest implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@JsonProperty("CreateUser")

	 private String CreateUser;
	@JsonProperty("ARRefId")
	    private Long ARRefId;

	    public String getCreateUser ()
	    {
	        return CreateUser;
	    }

	    public void setCreateUser (String CreateUser)
	    {
	        this.CreateUser = CreateUser;
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
	        return "ClassPojo [CreateUser = "+CreateUser+", ARRefId = "+ARRefId+"]";
	    }
	
}
