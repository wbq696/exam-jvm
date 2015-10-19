package com.yintai.transaction;

import java.math.BigDecimal;
import java.util.List;

import com.yintai.transaction.constant.Constant.TransactionStatus;
import com.yintai.transaction.entity.TransactionInfo;
import com.yintai.transaction.entity.UserInfo;
import com.yintai.transaction.service.TransactionService;

/**
 * ������֤��
 */
public class Test {

	public static void main(String[] args) {

		Test test = new Test();
		//test.verifyOne();
		test.verifyTwo();
		
	}
	
	/**
	 * ��֤
	 * 1��ʹ���û���������һ��86Ԫ5������ҵĽ��׼�¼����֤����״̬Ϊ�ȴ�������ҽ��׵Ľ������ȷ�ġ�
	 */
    public void verifyOne(){
    	
		//��װ�û�����
		UserInfo userInfo = new UserInfo();
		userInfo.setUserName("����");
		//��ӽ�����Ϣ��״̬Ϊ�ȴ�������׽��Ϊ 86Ԫ5��,�����ؽ�����Ϣ
		TransactionInfo addTransactionInfo = TransactionService.addTransactionInfo(TransactionStatus.WAIT_PAY.getValue(), userInfo, new BigDecimal(86.5));
		//��ѯ���еȴ�����Ľ�����Ϣ
		List<TransactionInfo> waitPayTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.WAIT_PAY.getValue());
		
		if(waitPayTransactionInfoList!=null){
			
			for(TransactionInfo transactionInfo:waitPayTransactionInfoList){
				//��֤����IDһ�£�������������� 86Ԫ5��
				if(transactionInfo.getId() == addTransactionInfo.getId() 
						&& transactionInfo.getUserInfo().getUserName().equals("����") 
						&& transactionInfo.getAmount().compareTo(new BigDecimal(86.5)) == 0){
					
				      System.out.println("�������� ���������Ϣ������״̬Ϊ��������׽��Ϊ"+transactionInfo.getAmount().doubleValue());
				
				}
				
			}
		}
		
    }
    
	/**
	 * ��֤
	 * 2��ʹ������ϰ�ߵĲ��Կ��
	 * ����ʼ��3�����׳ɹ���Ϣ��2������ʧ����Ϣ��
	 * ��֤��ѯ�ӿڰ�ȫ��״̬��ѯ��5�����ף�
	 * ֻ��ѯ�ɹ��Ľ�����3����ֻ��ѯʧ�ܵĽ�����2����
	 */
    public void verifyTwo(){
    	
    	//���3���ɹ����׼�¼
    	for(int i=1;i<=3;i++){
    		//��װ�û�����
    		UserInfo success = new UserInfo();
    		success.setUserName("�û�["+i+"]");
    		TransactionService.addTransactionInfo(TransactionStatus.BUSIN_SUCCESS.getValue(), success, new BigDecimal(100+i));
    	}
    	//���3���ɹ����׼�¼
    	for(int i=1;i<=2;i++){
    		//��װ�û�����
    		UserInfo fail = new UserInfo();
    		fail.setUserName("�û�["+i+"]");
    		TransactionService.addTransactionInfo(TransactionStatus.BUSIN_FAIL.getValue(), fail, new BigDecimal(50+i));
    	}
		
    	//ȡ��ȫ��״̬������Ϣ
		List<TransactionInfo> allTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.ALL_STATUS.getValue());
		System.out.println(">>>ȫ��״̬�ӿڹ�"+allTransactionInfoList.size()+"�����׼�¼��Ϣ.");
        for(TransactionInfo transactionInfo:allTransactionInfoList){
        	System.out.println(transactionInfo.getUserInfo().getUserName()
        			+",���׽��"+transactionInfo.getAmount().intValue()
        			+" ״̬�룺"+transactionInfo.getStatus());
        }
        System.out.println("-----------------------------");
    	//ȡ���ɹ�״̬������Ϣ
		List<TransactionInfo> successTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.BUSIN_SUCCESS.getValue());
		System.out.println(">>>�ɹ�״̬�ӿڹ�"+successTransactionInfoList.size()+"�����׼�¼��Ϣ.");
        for(TransactionInfo transactionInfo:successTransactionInfoList){
        	System.out.println(transactionInfo.getUserInfo().getUserName()
        			+",���׽��"+transactionInfo.getAmount().intValue());
        }
        
        System.out.println("-----------------------------");
    	//ȡ��ʧ��״̬������Ϣ
		List<TransactionInfo> failTransactionInfoList = TransactionService.getTransactionInfoList(TransactionStatus.BUSIN_FAIL.getValue());
		System.out.println(">>>ʧ��״̬�ӿڹ�"+failTransactionInfoList.size()+"�����׼�¼��Ϣ.");
        for(TransactionInfo transactionInfo:failTransactionInfoList){
        	System.out.println(transactionInfo.getUserInfo().getUserName()+",���׽��"+transactionInfo.getAmount().intValue());
        }
        
		
    }
}
