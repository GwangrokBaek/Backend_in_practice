// 본래 문자열은 char[]이지만, JDK에서 이를 String 클래스로 제공해준다.
// Ctrl 누른채로 클래스 이름을 클릭하면 해당 클래스의 소스코드로 이동 가능.
// 하나의 java 파일에 하나의 클래스를 두는 것이 원칙이다.
// 하지만, 여러 개의 클래스가 있는 경우 public 클래스는 단 하나이고, public 클래스와
// 자바 파일의 이름은 동일해야 한다.
// 이때 자바의 모든 코드는 class 내부에 위치한다.
// 클래스 외부에는 패키지 정의나 다른 패키지를 가져오는 import 등만을 적는다.
// 클래스의 속성은 클래스의 특징을 나타내며, 이를 property, attribute라고도 한다. 자료형을 이용해 멤버 변수로 선언하면 된다.
// 클래스의 기능은 메소드로 구현하며, 이를 멤버 함수라고도 한다. 객체가 수행하는 기능을 구현한다.

package classpart;

public class Student {
	int studentID; // 속성
	String studentName;
	int grade;
	String address;
	
	public Student() {}
	// 생성자를 따로 선언하지 않더라도 자바 컴파일러가 알아서 default 생성자를 만들어주므로
	// new 키워드를 통해 default 생성자를 사용할 수 있다.
	// 이때 default 생성자는 클래스의 이름과 동일하고, 파라미터가 없는 생성자이다.
	// 만약 하나라도 생성자를 선언해준다면, default 생성자는 생성되지 않는다.
	
	// 생성자는 이 객체를 생성하면서 함께 수행하고싶은 기능을 추가하고 싶을때 생성자를 사용한다.
	// 따라서 블록안에 객체가 생성되면서 수행해야 할 코드를 작성해준다.
	public Student(int id, String name) { // 이 생성자를 호출하기 위해서는 객체를 생성할때 id와 name을 무조건 받아야 한다.
		studentID = id;
		studentName = name;
	}
	
	// 생성자 오버로딩을 통해 다양한 생성자를 생성할 수 있다.
	
	public void showStudentInfo() {
		System.out.println(studentName + "," + address); // 메소드
	}
	
	public String getStudentName() { // 클래스의 메소드는 멤버 변수를 사용하여 클래스의 기능을 구현한다.
		return studentName;
	}
	
	public void setStudentName(String name) {
		studentName = name;
	}
}

/*
 * 생성자
 * 생성자는 인스턴스를 초기화 할때의 명령어 집합
 * 생성자의 이름은 그 클래스의 이름과 같다.
 * 생성자는 메소드가 아니다. 상속되지 않으며, 리턴 값은 없다.
 * 
 * 디폴트 생성자
 * 하나의 클래스에는 반드시 적어도 하나 이상의 생성자가 존재한다.
 * 이때 프로그래머가 생성자를 작성하지 않으면 컴파일러가 Default 생성자를 자동으로 만들어준다.
 * Default 생성자는 매개 변수가 없으며, 구현부가 없다.
 * 만약 클래스에 매개변수가 있는 생성자를 추가하면, 디폴트 생성자는 제공되지 않는다.
 */