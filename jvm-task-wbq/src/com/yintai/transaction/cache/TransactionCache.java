package com.yintai.transaction.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yintai.transaction.constant.Constant.TransactionStatus;
import com.yintai.transaction.entity.TransactionInfo;

/**
 * ���׼�¼����
 */
public class TransactionCache {

	//���׼�¼����
	private static Map<Integer,List<TransactionInfo>>  transactionMap = new HashMap<Integer,List<TransactionInfo>>();
	
	/**
	 * ���ݽ������ͻ�ȡ�����б�
	 * @param status
	 * @return
	 */
	public static List<TransactionInfo> getTransactionInfoList(Integer status){
		return transactionMap.get(status);
	}
	
	/**
	 * ���ݽ���״̬����ʼ�����׼�¼����
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
	 * ���ݽ���״̬��ӽ��׼�¼���� ,���ܵ�״̬����
	 * @param status
	 */
	public static void addTransactionInfo(Integer status,TransactionInfo transactionInfo){
		 
		List<TransactionInfo> transactionInfoList = transactionMap.get(status);
		 if(transactionInfoList == null){
			 transactionInfoList = initTransactionInfoList(status);
		 }
		 
		 //����״̬��ӻ����б�
		 transactionInfoList.add(transactionInfo);
		
		 //����ܵ�״̬�����б�
		 addAllStatusTransactionInfo(transactionInfo.clone());
	}
	
	/**
	 * ����ܵ�״̬�����б�
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
