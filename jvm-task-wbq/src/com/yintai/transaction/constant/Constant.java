package com.yintai.transaction.constant;

/**
 * 常量类
 */
public class Constant {
	
	/**
	 * 交易状态( 0 订单提交等待付款, 1付款成功 ,2 商品发货 ,3 待收货 ,4 交易成功,5交易失败)
	 */
	public enum TransactionStatus {
		
		WAIT_PAY(0), PAY_SUCCESS(1),GDDOS_SEND_OUT(2),WAIT_TAKE_DELIVERY(3),BUSIN_SUCCESS(4),BUSIN_FAIL(5),ALL_STATUS(6);
		
		private int value = 0;

		private TransactionStatus(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	
	
	
	/**
	 * 交易类型(0 支付, 1退款)
	 */
	public enum TransactionType{
		
		PAY(0),REFUNDMENT(1);
		
		private int value;
		
		private TransactionType(int value){
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	
	/**
	 * 货币类型 (0 人们币, 1 美元)
	 */
	public enum CurrencyType{
		RMB(0),DOLLARS(1);
		
		private int value;
		
		private CurrencyType(int value){
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
	
}
