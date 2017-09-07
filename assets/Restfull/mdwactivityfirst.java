/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package Restfull;

import com.centurylink.mdw.util.log.StandardLogger.LogLevel;
import com.centurylink.mdw.util.timer.Tracked;
import com.centurylink.mdw.java.JavaExecutionException;
import com.centurylink.mdw.activity.ActivityException;
import com.centurylink.mdw.model.request.Request;
import com.centurylink.mdw.model.workflow.ActivityRuntimeContext;
import com.centurylink.mdw.workflow.activity.DefaultActivityImpl;

/**
 * MDW general activity.
 */
@Tracked(LogLevel.TRACE)
public class mdwactivityfirst extends DefaultActivityImpl {

    /**
     * Here's where the main processing for the activity is performed.
     *     
     * @return the activity result (aka completion code)
     */
    @Override
    public Object execute(ActivityRuntimeContext runtimeContext) throws ActivityException {
        // TODO Auto-generated method stub
    	
    	System.out.println("hellojksjkasjh");
    	System.out.println("hi this is the first pass");
        return "NO";
    }
    
}
