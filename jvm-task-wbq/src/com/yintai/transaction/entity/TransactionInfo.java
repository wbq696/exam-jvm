package com.yintai.transaction.entity;

import java.math.BigDecimal;

/**
 * ����ʵ����
 */
public class TransactionInfo implements Cloneable{
  
	/**
	 * ����ID
	 */
	private long id;
	
	/**
	 * ����ʱ��
	 */
	private String createTime;
	
	/**
	 * ����״̬( 0 �����ύ�ȴ����� ,1����ɹ� ,2 ��Ʒ���� ,3 ���ջ�, 4 ���׳ɹ�,5����ʧ��)
	 */
	private int status;
	
	/**
	 * ��������(0 ֧�� 1�˿�)
	 */
	private int type;
	
	/**
	 * ���׽��
	 */
	private BigDecimal amount;
	
	/**
	 * �������� (0 ���Ǳ�, 1 ��Ԫ)
	 */
	private int currencyType;
	
	/**
	 * �ͻ���Ϣ(Ϊ�洢���㣬δʹ�ö�Ӧ��ϵ)
	 */
	private UserInfo userInfo;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public int getCurrencyType() {
		return currencyType;
	}

	public void setCurrencyType(int currencyType) {
		this.currencyType = currencyType;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	@Override  
    public TransactionInfo clone() {  
	  TransactionInfo transactionInfo = null;  
        try{  
        	transactionInfo = (TransactionInfo)super.clone();  
        }catch(CloneNotSupportedException e) {  
            e.printStackTrace();  
        }  
        return transactionInfo;  
    }  
}
