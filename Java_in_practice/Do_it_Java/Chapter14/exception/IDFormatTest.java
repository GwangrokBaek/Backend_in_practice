// 사용자 정의 예외
// JDK 에서 제공되는 예외 클래스 외에 사용자가 필요에 의해 예외 클래스를 정의하여 사용할 수 있다.
// 기존 JDK 예외 클래스 중 가장 유사한 클래스에서 상속한다.
// 기본적으로 Exception 에서 상속해도 된다.

package exception;

public class IDFormatTest {

	private String userID;
	
	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) throws IDFormatException { // 직접 만든 예외 클래스를 예외 처리에 사용.
		
		if(userID == null) {
			throw new IDFormatException("아이디는 null 일 수 없습니다.");
		}
		else if(userID.length() < 8 || userID.length() > 20) {
			throw new IDFormatException("아이디는 8자 이상, 20자 이하로 쓰세요.");
		}
		
		this.userID = userID;
	}



	public static void main(String[] args) {
		IDFormatTest idTest = new IDFormatTest();
		String userID = null;
		
		try { // 클래스 구현 단계에서 throws 를 사용해 예외 처리를 미루었으므로 사용 단계에서 try - catch 문을 통해 예외 처리를 해준다.
			idTest.setUserID(userID);
		} catch (IDFormatException e) { // 직접 만든 예외인 IDFormatException 이 발생한다.
			System.out.println(e);
		}
		
		userID = "1234567";
		
		try {
			idTest.setUserID(userID);
		} catch (IDFormatException e) {
			System.out.println(e); // 이때 직접 만든 예외 클래스에서 예외 메시지를 String 으로 받으므로 e.getMessage() 가 호출된다.
			// 여기서 getMessage() 메서드는 상위 클래스인 Exception 클래스의 메서드이다.
		}
	}

}
