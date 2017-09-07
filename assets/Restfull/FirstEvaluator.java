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
import com.centurylink.mdw.workflow.activity.AbstractEvaluator;
import com.centurylink.mdw.activity.ActivityException;

/**
 * MDW evaluator activity.
 */
 @Tracked(LogLevel.TRACE)
public class FirstEvaluator extends AbstractEvaluator
{
  /**
   * Returns the outcome of the evaluation.
   */
  public Object evaluate() throws ActivityException
  {
    // TODO Auto-generated method stub
	  
	  
    return "GO";
  }
}
