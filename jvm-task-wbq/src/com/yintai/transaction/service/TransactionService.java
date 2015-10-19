package com.yintai.transaction.service;

import java.math.BigDecimal;
import java.util.List;
import com.yintai.transaction.cache.TransactionCache;
import com.yintai.transaction.entity.TransactionInfo;
import com.yintai.transaction.entity.UserInfo;
import com.yintai.transaction.utils.DateUtil;

/**
 * 交易业务类
 */
public class TransactionService {
	
	/**
	 * 根据交易状态、用户信息、交易金额 创建交易记录并添加
	 * @param status
	 * @param userInfo
	 * @param amount
	 * @return
	 */
	public static TransactionInfo addTransactionInfo(Integer status,UserInfo userInfo,BigDecimal amount){
		
		//封装交易实体类
		TransactionInfo transactionInfo = new TransactionInfo();
		transactionInfo.setId(System.currentTimeMillis());
		transactionInfo.setAmount(amount);
		transactionInfo.setCreateTime(DateUtil.getStringDate());
		transactionInfo.setStatus(status);
		transactionInfo.setUserInfo(userInfo);
		//添加缓存
		TransactionCache.addTransactionInfo(status, transactionInfo);
		
		return transactionInfo;
	}
	
	/**
	 * 根据交易类型查询，交易信息列表
	 * @param status
	 * @return
	 */
	public static List<TransactionInfo> getTransactionInfoList(Integer status){
		return TransactionCache.getTransactionInfoList(status);
	}

}
