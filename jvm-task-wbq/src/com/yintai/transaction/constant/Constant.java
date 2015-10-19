package com.yintai.transaction.constant;

/**
 * ������
 */
public class Constant {
	
	/**
	 * ����״̬( 0 �����ύ�ȴ�����, 1����ɹ� ,2 ��Ʒ���� ,3 ���ջ� ,4 ���׳ɹ�,5����ʧ��)
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
	 * ��������(0 ֧��, 1�˿�)
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
	 * �������� (0 ���Ǳ�, 1 ��Ԫ)
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
