/**
 * Copyright (c) 2016 CenturyLink, Inc. All Rights Reserved.
 */

package MyServices;

import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ExecutorService;

import com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceRequest;
import com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceRequestItems;
import com.centurylink.qbat.model.noebill.adj.QbatNoEbillAdjServiceResponse;
import com.qwest.xmlSchema.qbat.accountInfo.CustomerAccountInfoExtT;
import com.qwest.xmlSchema.qbat.accountInfo.CustomerAccountInfoT;
import com.qwest.xmlSchema.qbat.billingRequest.BillingRequestT;
import com.qwest.xmlSchema.qbat.businessServices.REReturnInfoT;
import com.qwest.xmlSchema.qbat.common.BulkTrackingInfoT;
import com.qwest.xmlSchema.qbat.userProfile.UserProfileInfoT;

import qbat.common.constant.QbatAppConstants;
import qbat.common.constant.QbatConfigKey;
import qbat.common.exceptions.QbatException;
import qbat.common.util.QbatThreadLocal;
import qbat.controls.services.account.QbatAccountServiceImpl;
import qbat.controls.services.appconfig.QbatAppConfigServiceHelper;
import qbat.controls.services.bulk.QbatBulkRequestServiceImpl;
import qbat.controls.services.data.QbatBillingRequestDataServiceImpl;
import qbat.controls.services.rules.bundle.QbatREBundle;
import qbat.controls.services.rules.common.constants.QbatRulesEngineConstants;
import qbat.controls.services.workflow.QbatWorkflowServiceImpl;
import qbat.gui.util.QbatGuiCacheHelper;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext; 
/**
 * Dynamic Java workflow asset.
 */
public class ConstructChild implements java.io.Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ApplicationContext context1 = new ClassPathXmlApplicationContext("Spring-AutoScan-Control.xml");
	
	QbatBillingRequestDataServiceImpl billingDataService = (QbatBillingRequestDataServiceImpl) context1.getBean(QbatBillingRequestDataServiceImpl.class); 
	
	QbatAccountServiceImpl  qbatAccountService=context1.getBean(QbatAccountServiceImpl.class);
    
	QbatWorkflowServiceImpl qbatWorkflowService=context1.getBean(QbatWorkflowServiceImpl.class);
	 
	QbatNoEbillAdjServiceRequest qbatNoEbillAdjServiceRequest=context1.getBean(QbatNoEbillAdjServiceRequest.class);
	
	QbatNoEbillAdjServiceResponse qbatNoEbillAdjServiceResponse=(QbatNoEbillAdjServiceResponse) context1.getBean(QbatNoEbillAdjServiceResponse.class);
	
//	QbatNoEbillAdjServiceRequestItems QbatNoEbillAdjServiceRequestItems=context1.getBean(QbatNoEbillAdjServiceRequestItems.class);
	private static Logger logger = LogManager.getLogger(QbatBulkRequestServiceImpl.class);

public void constructChildBR(QbatNoEbillAdjServiceRequest qbatNoEbillAdjServiceRequest, UserProfileInfoT aUserProfileInfo,long aTotalRecords, ExecutorService execSvc)  {
		
		long mTransactionCancelled = 0;
//	mTransactionCancelled = this.billingDataService.getBULK_BR_STATUS(qbatNoEbillAdjServiceRequest.getOperatorId(), QbatAppConstants.STATUS_CANCELLED);
		if(mTransactionCancelled > 0){
			 if(execSvc!=null) {
				execSvc.shutdownNow();
		
		  	 }
		 }
		
		if(qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().getStatus() != null) {
			//checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
			return;
		}
		
	/*	if(this.getMarketUnit() == null) {
				   String mDeptName = aUserProfileInfo.getDepartment();
				//use QbatGuiCacheHelper method, to determine the 2 digit MU.
				String mMarketUnit = QbatGuiCacheHelper.getMarketUnitFromDepartment(mDeptName);				
				QbatThreadLocal.setMarketUnit(mMarketUnit);
				this.setMarketUnit(mMarketUnit);
    	} else {
    		QbatThreadLocal.setMarketUnit(this.getMarketUnit());    		
    	}*/
		
		qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(QbatAppConstants.SUB_STATUS_CODE_IN_PROGRESS);
		//updateBulkTransaction(bulkTrackingInfo.getRecordNumber(),QbatAppConstants.SUB_STATUS_CODE_IN_PROGRESS, QbatAppConstants.SUB_STATUS_CODE_IN_PROGRESS, bulkTrackingInfo.getParentRefId());	        		
	
		
		String mStatusText;
		
		long mBulkRefId = 987;
		
		String mStatus = "ERROR";
		
		boolean mStatusLive = false;
		CustomerAccountInfoExtT[] custAcctList;
		
		long mRecordNumber =874;
		
		String mAcctNumber = getAccountNumber(qbatNoEbillAdjServiceRequest);
		try{
		
				custAcctList  = getAccountInformation(mAcctNumber,aUserProfileInfo);
		
				if(custAcctList == null || custAcctList.length == 0) {
					mStatusText = "The Account does not have a CRIS Master File. Invalid Account Number or account is no longer in CRIS.";
					qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
					qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);				
			updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
					//checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
		return;			
		}
		
		}catch(QbatException e1)
			{
			mStatusText = "Account currently unavailable, request timed out.  Please retry in a few minutes.(1)";
			qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
			qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);				
			updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
			//checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
			logger.error(mStatusText+e1);
		return;		
			}
			
		
		
		
		CustomerAccountInfoExtT mCustomerAccountInfoExt = null;
				
		String mDeptName = aUserProfileInfo.getDepartment();
		//use QbatGuiCacheHelper method, to determine the 2 digit MU.
		String mMarketUnit = QbatGuiCacheHelper.getMarketUnitFromDepartment(mDeptName);
		boolean mIsBMGUser = QbatAppConstants.BMG_MARKET_UNIT.equalsIgnoreCase(mMarketUnit);
		
        if(custAcctList.length > 1 && mIsBMGUser) {
        	mStatusText = "Multiple accounts found for this account";
        	qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
        	qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);				
			updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
			//checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
			return;	
        } else if(custAcctList.length > 1) {
        	for(int i =0; i<custAcctList.length;i++){
        		if(QbatAppConstants.ACCT_STATUS_LIVE.equalsIgnoreCase(custAcctList[i].getCustomerAccountInfo().getAccountStatus())){
        			mStatusLive = true;
        			mCustomerAccountInfoExt = custAcctList[i];
        		}
        	} if(!mStatusLive){
        		mStatusText = "Multiple accounts found and Adjustment is valid on LIVE account";
        		qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
        		qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);
    			updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
    		//	checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
    			return;
        	}
        } else if(custAcctList.length == 1){
        	mCustomerAccountInfoExt = custAcctList[0];
        }
        	
        if(mCustomerAccountInfoExt == null){
			mStatusText = "Account currently unavailable, request timed out.  Please retry in a few minutes.(2)";
			qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
			qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);				
			updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
		//	checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
		return;			
		}
        
        
        REReturnInfoT mCanViewAccount = (REReturnInfoT)mCustomerAccountInfoExt.getCanViewAccount();
        
        if(mCanViewAccount!=null && mCanViewAccount.getReturnCode()!=0){
        	mStatusText = "User Can not create Transaction on this account";
        	
        	qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
        	qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);
			updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);			
			//checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
			logger.error(mStatusText);
			return;
        	
        }
        
		
		CustomerAccountInfoT mCustomerAccountInfo = mCustomerAccountInfoExt.getCustomerAccountInfo();		
		try {
			mCustomerAccountInfo = qbatAccountService.getAccountData(mCustomerAccountInfoExt);
			mCustomerAccountInfo = qbatAccountService.getPaymentData(mCustomerAccountInfoExt);
			
			if(mCustomerAccountInfo == null) {
				mStatusText = "Account currently unavailable, request timed out.  Please retry in a few minutes.(3)";				
				qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
				qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);
				updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
			//	checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
				logger.error(mStatusText);
                return;
			}
        }catch (QbatException e1) {
        	
        	try {
				mCustomerAccountInfo = qbatAccountService.getAccountData(mCustomerAccountInfoExt);
				mCustomerAccountInfo = qbatAccountService.getPaymentData(mCustomerAccountInfoExt);
			} catch (QbatException e) {
				mStatusText = "Account currently unavailable, request timed out.  Please retry in a few minutes.(4)";        	
				qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
				qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);			
			updateBulkTransaction(mRecordNumber, mStatus, mStatusText, mBulkRefId);
				//checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
				logger.error(mStatusText+e1);
				e.printStackTrace();
			return;	
        	
		}
		}
		if(null != mCustomerAccountInfo){
			mCustomerAccountInfoExt.setCustomerAccountInfo(mCustomerAccountInfo);
		}

		try {
			//HeldBill and EntityBalances invocation here,
			//to make sure XCASH/ISA invocation failure doesnt affect Child BR construct
			//..ADDED BY AJAY KUMAR(AXKUM48)
			String mBulkAdjustmentFlag = QbatAppConfigServiceHelper.getStringValue(QbatConfigKey.BULK_ISA_HELD_ONOFF_FLAG); 
			if("TRUE".equalsIgnoreCase(mBulkAdjustmentFlag)) {
				if(mCustomerAccountInfo.getInvoiceCycleDate() == null) {
					mCustomerAccountInfoExt = qbatAccountService.getHeldBillStatus(mCustomerAccountInfoExt);
				}
			}			
			mCustomerAccountInfo = mCustomerAccountInfoExt.getCustomerAccountInfo();
			if(mCustomerAccountInfo.getAccountStatus().equalsIgnoreCase(QbatAppConstants.ACCT_STATUS_FINAL)) {
				
				//this.loadEntityBalances(mCustomerAccountInfoExt);
			}
		} catch (QbatException aEx) {
					mStatusText = "Failed to get held bill status.";
					qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
					qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);
			updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
				//	checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
					logger.error(mStatusText);			
			logger.error(aEx);			
				aEx.printStackTrace();
				return;
		
			
	
    		
			}

		String mRegionCode = mCustomerAccountInfo.getRegionCode();
		String mEntityCode = qbatNoEbillAdjServiceRequest.getQbatNoEbillAdjServiceRequestItems().iterator().next().getEntityCode();

		LinkedHashMap mEntityRegionCodes = QbatGuiCacheHelper.getEntityRegionCodes();
		if(mEntityRegionCodes != null && mEntityCode!= null) {
			String mCacheRegionCode = (String)mEntityRegionCodes.get(mEntityCode);
			if(!( mRegionCode!= null && mCacheRegionCode!= null && mRegionCode.equalsIgnoreCase(mCacheRegionCode))){
				//mStatusText = "Invalid Entity code for this Account";

				try
				{
				if( QbatREBundle.isInList(mEntityCode, QbatAppConstants.ENSEMBLE_ENTITY_LIST)) {
					 mStatusText = "Bulk Adjustments are not allowed on Ensemble entitites";
					 qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
					 qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);
						updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
				//		checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
						logger.error(mStatusText);
					} else {
				mStatusText = "Invalid Entity code for this Account";				
				qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
				qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);
				updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
			//	checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
				logger.error(mStatusText);
					}
				}catch(Exception aEx){}


				return;

			}
		}

        BillingRequestT mBR = null;
		
		/*try {
			mBR = ConstructShopcartDocForChildBR(qbatNoEbillAdjServiceRequest,mCustomerAccountInfoExt,aUserProfileInfo,mBulkRefId);
		} catch (QbatException e) {
			mStatusText = "System Error: Unable to Create Child (1)";			
			qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
			qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);			
			updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
			//checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
			logger.error(mStatusText);			
			return;
		}
		finally {
			if(mBR != null && mBR.getARRefId()>0) {
				try {
				this.completeChildRequest(mBR, qbatNoEbillAdjServiceRequest,aUserProfileInfo);
					
				} catch (QbatException e) {
					mStatusText = "System Error: Unable to Create Child (2)";			
					qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
					qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);			
					updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
				//	checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
					logger.error(mStatusText);			
					return;
				}
				qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
				qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(QbatAppConstants.SUCCESS);
				long mARRefId = mBR.getARRefId();
				try {
				billingDataService.updateChildRefId(mARRefId, bulkTrackingInfo.getParentRefId(),bulkTrackingInfo.getRecordNumber() );
				} catch (QbatException e) {
					mStatusText = "System Error: Unable to Create Child(3)";			
					qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatus(mStatus);
					qbatNoEbillAdjServiceResponse.getQbatNoEbillAdjServiceResponseItems().iterator().next().setStatusText(mStatusText);			
					updateBulkTransaction(mRecordNumber, mStatus, mStatusText,mBulkRefId);
					//checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
					logger.error(mStatusText);			
					return;
				}
				updateBulkTransaction(mRecordNumber, QbatAppConstants.SUCCESS, QbatAppConstants.SUCCESS,mBulkRefId);
			}
		}
		
		checkAndCompleteParentBR(bulkTrackingInfo, aUserProfileInfo);
		
		*/
		
		return;
		
	}

private void checkAndCompleteParentBR(BulkTrackingInfoT bulkTrackingInfo,UserProfileInfoT aUserProfileInfo){
	try {
		
		
		boolean mIsChildBRInProgress = false;
    	
    		long mInprogressBRs = billingDataService.getInProgressChildBRs(bulkTrackingInfo.getParentRefId());	        		            	
    			if(mInprogressBRs > 0 ) {
    				mIsChildBRInProgress = true;
    			}
    
	if( ! mIsChildBRInProgress){
		try{
			
			billingDataService.InsertBULK_BR_STATUS(bulkTrackingInfo.getParentRefId(), QbatAppConstants.BULK_STATUS_COMPLETE);
			billingDataService.deleteBULK_BR_STATUS(bulkTrackingInfo.getParentRefId(),  QbatAppConstants.SUB_STATUS_CODE_IN_PROGRESS);
			BillingRequestT mParentBR = qbatWorkflowService.getBRDetail(bulkTrackingInfo.getParentRefId());
			qbatWorkflowService.processRequest(mParentBR, mParentBR.getCreateUser(), QbatRulesEngineConstants.RET_NO,aUserProfileInfo);
			//updateBRFinalSummary((AggregateRequestT)mBR);
		//	this.sendEmailNotification(mParentBR, mParentBR.getCreateUser());
			
			if(logger.isInfoEnabled()) {
				logger.info("Sending Email to the Originator of Bulk Request: " +  aUserProfileInfo.getCuid());
			}
		}
		catch(QbatException e){
			logger.error("10 Exception while inserting completed record");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("10 Exception while inserting completed record");
		}
	}
	} catch (QbatException e1) {
		// TODO Auto-generated catch block
		logger.error("Exception in Thread Synchronization");
	}
}

public void updateBulkTransaction(long aRecordNumber,String aStatus, String aStatusText, long mBulkRefId) {
	
	
	try {
	billingDataService.updateBulkTrackingInfoForRecordNumber(aRecordNumber, aStatus, aStatusText, mBulkRefId);
	} catch (QbatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return;
}
private String getAccountNumber(QbatNoEbillAdjServiceRequest qbatNoEbillAdjServiceRequest) {
	
	String mAcctNumber = new StringBuffer().append(qbatNoEbillAdjServiceRequest.getQbatNoEbillAdjServiceRequestItems().iterator().next().getBtn()).toString();        
    String mPrefix = qbatNoEbillAdjServiceRequest.getQbatNoEbillAdjServiceRequestItems().iterator().next().getPrefix();
    if (mPrefix != null && !mPrefix.equalsIgnoreCase("null") && mPrefix.length() == 1 && Character.isLetter(mPrefix.charAt(0)))
    {
        mAcctNumber = new StringBuffer(mPrefix).append(mAcctNumber).toString();
    }
    String mCustCode = qbatNoEbillAdjServiceRequest.getQbatNoEbillAdjServiceRequestItems().iterator().next().getCustomerCode();
    if (mCustCode != null && !mCustCode.equalsIgnoreCase("null"))
    {
        mAcctNumber = new StringBuffer(mAcctNumber).append(qbatNoEbillAdjServiceRequest.getQbatNoEbillAdjServiceRequestItems().iterator().next().getCustomerCode()).toString();
    }
    String mSuffix = qbatNoEbillAdjServiceRequest.getQbatNoEbillAdjServiceRequestItems().iterator().next().getSuffix();
    if (mSuffix != null && !mSuffix.equalsIgnoreCase("null")) {
        mAcctNumber = new StringBuffer(mAcctNumber).append(qbatNoEbillAdjServiceRequest.getQbatNoEbillAdjServiceRequestItems().iterator().next().getSuffix()).toString();
    }
    return mAcctNumber;
	
}
CustomerAccountInfoExtT[] getAccountInformation(String aAcctNumber,UserProfileInfoT aUserProfileInfo) throws QbatException
{
	List mList=null;
	CustomerAccountInfoExtT[] custAcctList;
	try {
		mList = this.searchAccount(aAcctNumber,aUserProfileInfo);
	} catch (QbatException e) {		
		mList = this.searchAccount(aAcctNumber,aUserProfileInfo);
	}
	if (mList != null)
    {
        custAcctList = (CustomerAccountInfoExtT[])mList.toArray(new CustomerAccountInfoExtT[0]);
    }
    else
    {
        custAcctList = new CustomerAccountInfoExtT[0];
    }		
	custAcctList = (CustomerAccountInfoExtT[])custAcctList;
    
    return custAcctList;
    
}
private List searchAccount(String aAcctTn,UserProfileInfoT aUserProfileInfo) throws QbatException
{       	
	
    List mList = qbatAccountService.searchAccount(aAcctTn, aUserProfileInfo);
        
    return mList;
}
}
