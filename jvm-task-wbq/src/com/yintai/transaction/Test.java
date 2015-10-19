package com.yintai.transaction;

import java.math.BigDecimal;
import java.util.List;

import com.yintai.transaction.constant.Constant.TransactionStatus;
import com.yintai.transaction.entity.TransactionInfo;
import com.yintai.transaction.entity.UserInfo;
import com.yintai.transaction.service.TransactionService;

/**
 * 测试验证类
 */
public class Test {

	public static void main(String[] args) {

		Test test = new Test();
		//test.verifyOne();
		test.verifyTwo();
		
	}
	
	/**
	 * 验证
	 * 1、使用用户张三创建一条86元5角人民币的交易记录，验证交易状态为等待付款，并且交易的金额是正确的。
	 */
    public void verifyOne(){
    	
		//封装用户对象
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("张三");
		//添加交易信息，状态为等待付款，交易金额为 86元5角,并返回交易信息
		TransactionInfo addTransactionInfo = TransactionService.addTransactionInfo(TransactionStatus.WAIT_PAY.getValue(), userInfo, new BigDecimal(86.5));
		//查询所有等待付款的交易信息
		List<TransactionInfo> waitPayTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.WAIT_PAY.getValue());
		
		if(waitPayTransactionInfoList!=null){
			
			for(TransactionInfo transactionInfo:waitPayTransactionInfoList){
				//验证交易ID一致，是张三，金额是 86元5角
				if(transactionInfo.getId() == addTransactionInfo.getId() 
						&& transactionInfo.getUserInfo().getUserName().equals("张三") 
						&& transactionInfo.getAmount().compareTo(new BigDecimal(86.5)) == 0){
					
				      System.out.println("存在张三 待付款交易信息，交易状态为待付款，交易金额为"+transactionInfo.getAmount().doubleValue());
				
				}
				
			}
		}
		
    }
    
	/**
	 * 验证
	 * 2、使用你所习惯的测试框架
	 * ，初始化3条交易成功信息，2条交易失败信息。
	 * 验证查询接口按全部状态查询共5条交易，
	 * 只查询成功的交易是3条，只查询失败的交易是2条。
	 */
    public void verifyTwo(){
    	
    	//添加3条成功交易记录
    	for(int i=1;i<=3;i++){
    		//封装用户对象
    		UserInfo success = new UserInfo();
    		success.setUserName("用户["+i+"]");
    		TransactionService.addTransactionInfo(TransactionStatus.BUSIN_SUCCESS.getValue(), success, new BigDecimal(100+i));
    	}
    	//添加3条成功交易记录
    	for(int i=1;i<=2;i++){
    		//封装用户对象
    		UserInfo fail = new UserInfo();
    		fail.setUserName("用户["+i+"]");
    		TransactionService.addTransactionInfo(TransactionStatus.BUSIN_FAIL.getValue(), fail, new BigDecimal(50+i));
    	}
		
    	//取出全部状态交易信息
		List<TransactionInfo> allTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.ALL_STATUS.getValue());
		System.out.println(">>>全部状态接口共"+allTransactionInfoList.size()+"条交易记录信息.");
        for(TransactionInfo transactionInfo:allTransactionInfoList){
        	System.out.println(transactionInfo.getUserInfo().getUserName()
        			+",交易金额"+transactionInfo.getAmount().intValue()
        			+" 状态码："+transactionInfo.getStatus());
        }
        System.out.println("-----------------------------");
    	//取出成功状态交易信息
		List<TransactionInfo> successTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.BUSIN_SUCCESS.getValue());
		System.out.println(">>>成功状态接口共"+successTransactionInfoList.size()+"条交易记录信息.");
        for(TransactionInfo transactionInfo:successTransactionInfoList){
        	System.out.println(transactionInfo.getUserInfo().getUserName()
        			+",交易金额"+transactionInfo.getAmount().intValue());
        }
        
        System.out.println("-----------------------------");
    	//取出失败状态交易信息
		List<TransactionInfo> failTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.BUSIN_FAIL.getValue());
		System.out.println(">>>失败状态接口共"+failTransactionInfoList.size()+"条交易记录信息.");
        for(TransactionInfo transactionInfo:failTransactionInfoList){
        	System.out.println(transactionInfo.getUserInfo().getUserName()+",交易金额"+transactionInfo.getAmount().intValue());
        }
        
		
    }
}
