package com.yintai.transaction.service;

import java.math.BigDecimal;
import java.util.List;
import com.yintai.transaction.cache.TransactionCache;
import com.yintai.transaction.entity.TransactionInfo;
import com.yintai.transaction.entity.UserInfo;
import com.yintai.transaction.utils.DateUtil;

/**
 * ����ҵ����
 */
public class TransactionService {
	
	/**
	 * ���ݽ���״̬���û���Ϣ�����׽�� �������׼�¼�����
	 * @param status
	 * @param userInfo
	 * @param amount
	 * @return
	 */
	public static TransactionInfo addTransactionInfo(Integer status,UserInfo userInfo,BigDecimal amount){
		
		//��װ����ʵ����
		TransactionInfo transactionInfo = new TransactionInfo();
		transactionInfo.setId(System.currentTimeMillis());
		transactionInfo.setAmount(amount);
		transactionInfo.setCreateTime(DateUtil.getStringDate());
		transactionInfo.setStatus(status);
		transactionInfo.setUserInfo(userInfo);
		//��ӻ���
		TransactionCache.addTransactionInfo(status, transactionInfo);
		
		return transactionInfo;
	}
	
	/**
	 * ���ݽ������Ͳ�ѯ��������Ϣ�б�
	 * @param status
	 * @return
	 */
	public static List<TransactionInfo> getTransactionInfoList(Integer status){
		return TransactionCache.getTransactionInfoList(status);
	}

}
