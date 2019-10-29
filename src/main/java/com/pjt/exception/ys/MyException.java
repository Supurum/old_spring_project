package com.pjt.exception.ys;

public class MyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final int ERR_CODE;
	public MyException(String msg){
		super(msg);
		ERR_CODE=0;
	}
	public MyException(String msg,int errCode){
		super(msg);
		ERR_CODE=errCode;
	}
	public int getErrCode(){// 에러 코드를 얻을 수 있는 메서드도 추가한다.

		return ERR_CODE;// 이 메서드는 주로 getMessage()와 함께 사용될 것이다.

	}

}
