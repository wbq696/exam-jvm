package com.yintai.transaction.entity;

import java.math.BigDecimal;

/**
 * 交易实体类
 */
public class TransactionInfo implements Cloneable{
  
	/**
	 * 交易ID
	 */
	private long id;
	
	/**
	 * 创建时间
	 */
	private String createTime;
	
	/**
	 * 交易状态( 0 订单提交等待付款 ,1付款成功 ,2 商品发货 ,3 待收货, 4 交易成功,5交易失败)
	 */
	private int status;
	
	/**
	 * 交易类型(0 支付 1退款)
	 */
	private int type;
	
	/**
	 * 交易金额
	 */
	private BigDecimal amount;
	
	/**
	 * 货币类型 (0 人们币, 1 美元)
	 */
	private int currencyType;
	
	/**
	 * 客户信息(为存储方便，未使用对应关系)
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
