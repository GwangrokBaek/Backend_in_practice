package exception;

public class IDFormatException extends Exception {
	
	public IDFormatException(String message) { // 생성자의 매개변수로 예외 상황 메시지를 받는다.
		super(message); // 상위 클래스인 Exception 클래스에는 String 을 받는 메서드가 있기에 이를 사용.
	}

}
