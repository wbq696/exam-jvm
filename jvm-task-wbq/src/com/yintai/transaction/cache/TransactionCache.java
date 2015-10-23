package com.yintai.transaction.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yintai.transaction.constant.Constant.TransactionStatus;
import com.yintai.transaction.entity.TransactionInfo;

/**
 * 交易记录缓存
 */
public class TransactionCache {

	//交易记录缓存
	private static Map<Integer,List<TransactionInfo>>  transactionMap = new HashMap<Integer,List<TransactionInfo>>();
	
	/**
	 * 根据交易类型获取交易列表
	 * @param status
	 * @return
	 */
	public static List<TransactionInfo> getTransactionInfoList(Integer status){
		return transactionMap.get(status);
	}
	
	/**
	 * 根据交易状态，初始化交易记录缓存
	 * @param status
	 */
	private static List<TransactionInfo> initTransactionInfoList(Integer status){
		 synchronized (status){
			 List<TransactionInfo> transactionInfoList = transactionMap.get(status);
		      if(transactionInfoList == null){
		    	  transactionInfoList = new ArrayList<TransactionInfo>();
		    	  transactionMap.put(status, transactionInfoList);
		      }	
		      return transactionInfoList;
		 }
	}
	
	/**
	 * 根据交易状态添加交易记录缓存 ,与总的状态缓存
	 * @param status
	 */
	public static void addTransactionInfo(Integer status,TransactionInfo transactionInfo){
		 
		List<TransactionInfo> transactionInfoList = transactionMap.get(status);
		 if(transactionInfoList == null){
			 transactionInfoList = initTransactionInfoList(status);
		 }
		 
		 //根据状态添加缓存列表
		 transactionInfoList.add(transactionInfo);
		
		 //添加总的状态缓存列表
		 addAllStatusTransactionInfo(transactionInfo.clone());
	}
	
	/**
	 * 添加总的状态缓存列表
	 * @param transactionInfo
	 */
	private static void addAllStatusTransactionInfo(TransactionInfo transactionInfo){
		List<TransactionInfo> transactionInfoList = transactionMap.get(TransactionStatus.ALL_STATUS.getValue());
		 if(transactionInfoList == null){
			 transactionInfoList = initTransactionInfoList(TransactionStatus.ALL_STATUS.getValue());
		 }
		 transactionInfoList.add(transactionInfo);
	}
}
