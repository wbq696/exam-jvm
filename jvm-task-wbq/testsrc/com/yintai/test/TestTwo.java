package com.yintai.test;

import java.math.BigDecimal;
import java.util.List;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.yintai.transaction.constant.Constant.TransactionStatus;
import com.yintai.transaction.entity.TransactionInfo;
import com.yintai.transaction.entity.UserInfo;
import com.yintai.transaction.service.TransactionService;

public class TestTwo extends TestCase  {

			
	@Before
	public void setUp() throws Exception {
    	//添加3条成功交易记录
    	for(int i=1;i<=3;i++){
    		//封装用户对象
    		UserInfo success = new UserInfo();
    		success.setUserName("用户["+i+"]");
    		TransactionService.addTransactionInfo(String.valueOf(System.currentTimeMillis()),TransactionStatus.BUSIN_SUCCESS.getValue(), success, new BigDecimal(100+i));
    	}
    	//添加2条失败交易记录
    	for(int i=1;i<=2;i++){
    		//封装用户对象
    		UserInfo fail = new UserInfo();
    		fail.setUserName("用户["+i+"]");
    		TransactionService.addTransactionInfo(String.valueOf(System.currentTimeMillis()),TransactionStatus.BUSIN_FAIL.getValue(), fail, new BigDecimal(50+i));
    	}
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testTwo() {
		
    	//取出全部状态交易信息
		List<TransactionInfo> allTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.ALL_STATUS.getValue());
		
		assertNotNull("全部状态交易信息列表为空!",allTransactionInfoList);
		assertEquals("全部状态接口共"+allTransactionInfoList.size()+"条交易记录信息，不等于5条记录。",5,allTransactionInfoList.size());
		
//		System.out.println(">>>全部状态接口共"+allTransactionInfoList.size()+"条交易记录信息.");
//        for(TransactionInfo transactionInfo:allTransactionInfoList){
//        	System.out.println(transactionInfo.getUserInfo().getUserName()
//        			+",交易金额"+transactionInfo.getAmount().intValue()
//        			+" 状态码："+transactionInfo.getStatus());
//        }
//        System.out.println("-----------------------------");
        
    	//取出成功状态交易信息
		List<TransactionInfo> successTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.BUSIN_SUCCESS.getValue());
        
		assertNotNull("成功状态交易信息列表为空!",successTransactionInfoList);
		assertEquals("成功状态接口共"+successTransactionInfoList.size()+"条交易记录信息，不等于3条记录。",3,successTransactionInfoList.size());
        
//		System.out.println(">>>成功状态接口共"+successTransactionInfoList.size()+"条交易记录信息.");
//        for(TransactionInfo transactionInfo:successTransactionInfoList){
//        	System.out.println(transactionInfo.getUserInfo().getUserName()
//        			+",交易金额"+transactionInfo.getAmount().intValue());
//        }
//        System.out.println("-----------------------------");
        
		
    	//取出失败状态交易信息
		List<TransactionInfo> failTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.BUSIN_FAIL.getValue());
		
		assertNotNull("失败状态交易信息列表为空!",failTransactionInfoList);
		assertEquals("失败状态接口共"+failTransactionInfoList.size()+"条交易记录信息，不等于2条记录。",2,failTransactionInfoList.size());
		
//		System.out.println(">>>失败状态接口共"+failTransactionInfoList.size()+"条交易记录信息.");
//        for(TransactionInfo transactionInfo:failTransactionInfoList){
//        	System.out.println(transactionInfo.getUserInfo().getUserName()+",交易金额"+transactionInfo.getAmount().intValue());
//        }
	}

}
