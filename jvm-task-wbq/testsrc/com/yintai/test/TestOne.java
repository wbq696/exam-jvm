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

public class TestOne extends TestCase  {

	private TransactionInfo addTransactionInfo = null;
			
	@Before
	public void setUp() throws Exception {
		//封装用户对象
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("张三");
		//添加交易信息，状态为等待付款，交易金额为 86元5角,并返回交易信息
		addTransactionInfo = TransactionService.addTransactionInfo(String.valueOf(System.currentTimeMillis()),TransactionStatus.WAIT_PAY.getValue(), userInfo, new BigDecimal(86.5));
	}

	@After
	public void tearDown() throws Exception {}

	@Test
	public void testOne() {
		//查询所有等待付款的交易信息
		List<TransactionInfo> waitPayTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.WAIT_PAY.getValue());
		assertNotNull("waitPayTransactionInfoList is null",waitPayTransactionInfoList);
		for(TransactionInfo transactionInfo:waitPayTransactionInfoList){
			//验证交易ID一致，是张三，金额是 86元5角
			assertEquals("交易主键Id不一致", addTransactionInfo.getId(), transactionInfo.getId());
			assertEquals("存在张三用户","张三", transactionInfo.getUserInfo().getUserName());
			assertEquals("交易金额不正确",86.5d,transactionInfo.getAmount().doubleValue());
//			System.out.println("存在张三 待付款交易信息，交易状态为待付款，交易金额为"+transactionInfo.getAmount().doubleValue());
		}
	}

}
