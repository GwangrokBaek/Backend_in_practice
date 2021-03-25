/*
 * Class 클래스
 * 자바의 모든 클래스와 인터페이스는 컴파일 후 class 파일로 생성된다.
 * class 파일에는 객체의 정보 (멤버변수, 메서드, 생성자 등) 가 포함되어 있다.
 * Class 클래스는 컴파일된 class 파일에서 객체의 정보를 가져올 수 있다.
 * 
 * reflection 프로그래밍 : Class 클래스를 이용하여 클래스의 정보를 가져오고 이를 활용하여 인스턴스를 생성하고, 메서드를 호출하는 등의
 * 프로그래밍 방식이다.
 * 
 * Class.forName() 메서드로 동적 로딩 하기
 * 프로그래밍 할때는 어떤 클래스를 사용할지 모를때 변수로 처리하고, 실행될때 해당 변수에 대입된 값의 클래스가 실행될 수 있도록
 * Class 클래스에서 제공하는 static 메서드이다.
 * - 실행 시에 로딩 (동적 로딩) 되므로 경우에 따라 다른 클래스가 사용될 수 있어 유용하다.
 * - 동적 로딩이란 컴파일 시에 데이터 타입이 모두 binding 되어 자료형이 로딩되는 것 (static loading) 이 아니라, 실행 중에
 * 데이터 타입을 알고 binding 되는 방식이다.
 * - 컴파일 타임에 체크할 수 없으므로 해당 문자열에 대한 클래스가 없는 경우 예외 (ClassNotFoundException) 가 발생할 수 있다.
 * 
 * 외부에서 소스 코드 없이 클래스만 제공받아 사용할 경우에도 많이 사용된다. (오라클의 JDBC 드라이버 사용 등)
 */

package classPackage;

public class MyBook {
	private String title;
	public String author;
	
	public MyBook(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
