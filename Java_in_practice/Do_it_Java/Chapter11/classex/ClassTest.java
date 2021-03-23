// Class 클래스
// 자바의 모든 클래스와 인터페이스는 컴파일 후에 class 파일로 생성된다.
// class 파일에는 객체의 정보 (멤버변수, 메서드, 생성자 등) 가 포함되어 있다.
// Class 클래스는 컴파일된 class 파일에서 객체의 정보를 가져올때 사용할 수 있다.

// Class 클래스 가져오기
// 1. Object 클래스의 getClass() 메서드 사용하기
// String s = new String();
// Class c = s.getClass(); // getClass() 메서드의 반환형은 Class 이다.
// 2. 클래스 파일 이름을 Class 변수에 직접 대입하기
// Class c = String.Class;
// 3. Class.forName("클래스 이름") 메서드 사용하기
// Class c = Class.forName("java.lang.String");

package classex;

public class ClassTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// Class 클래스의 forName 메서드에서 해당 클래스가 존재하지 않을 수도 있으므로 이 에러에 대해서 throw 처리.
		// + newInstance() 와 관련된 에러 throw 처리.
		
		// Class c
		
		String str = new String("abc");
		// str. String 클래스의 경우, String 클래스 파일에 대한 정보를 로컬에서 가지고 있으므로 str. 을 통해 사용 가능한
		// 메서드나 멤버 변수를 확인하고 가져올 수 있다.
		// 하지만 원격에 존재하는 클래스를 로딩하는 등 코드 상에서 데이터 타입으로 선언되지 않은 클래스를 사용하는 경우가 있을 수 있다.
		// 이렇게 클래스의 정보를 가져와서 프로그래밍해야하는 프로그래밍 방식을 reflection 프로그래밍이라고 하는데,
		// 이런 경우에는 로컬에서 해당 클래스의 정보를 확인할 수가 없다.
	
		Person person = new Person();
	
		Class pClass1 = person.getClass(); // getClass() 메서드는 Object의 메서드이다.
		// 이때 인스턴스의 Class 클래스를 반환해준다.
		System.out.println(pClass1.getName());
	
	
		Class pClass2 = Person.class;
		System.out.println(pClass2.getName());
		
		// Class pClass3 = Class.forName("classex1.Person"); // classex1.Person 이라는 클래스는 없으므로
		// 런타임 에러 발생. 동적 로딩이기 때문에 컴파일 타임에는 에러가 발생하지 않는다.
		Class pClass4 = Class.forName("classex.Person");
		System.out.println(pClass4.getName());
		
		Person p = (Person)pClass4.newInstance(); // Person 타입으로 다운 캐스팅. newInstance() 메서드는 곧 사라질 메서드이다.
		System.out.println(p); // newInstance()를 사용하면 가져온 클래스에 대해서 인스턴스를 생성할 수 있는데
		// 이때 default 생성자를 사용한다. 만약 다른 생성자를 사용하고 싶다면, getConstructors() 메서드를 통해 해당 클래스에 대한
		// 모든 생성자를 가져온 다음에 그 중에 선택해서 인스턴스를 생성해주어야 한다.
		
		// 이때 Class 클래스를 가져오는 세 가지 방법 중 위 2 가지 방법은 Person 클래스가 코드 상에서 선언되어야 사용할 수 있는
		// 정적 로딩 방법이지만, 마지막 방법인 forName() 메서드를 사용하는 방법은 해당 클래스가 로컬에 없더라도 사용할 수 있는
		// 동적 로딩 방법이다.
		
		Class pClass5 = Class.forName("java.lang.String"); // forName 메서드는 인자로 받은 문자열과 일치하는 클래스의
		// 이름이 있는 경우 해당 클래스를 메모리에 로드해준다.
		System.out.println(pClass5.getName());
	}
}

/*
* Class 클래스로 정보 가져오기
* reflection 프로그래밍 : Class 클래스를 이용하여 클래스의 정보 (생성자, 멤버변수, 메서드) 를 가져오고, 이를 활용하여 인스턴스를
* 생성하고, 메서드를 호출하는 등의 프로그래밍 방식이다.
* 로컬 메모리에 객체가 없어서 객체의 데이터 타입을 직접 알 수 없는 경우 (원격에 객체가 있는 경우 등) 객체 정보만을 이용하여
* 프로그래밍할 수 있다.
* Constructor, Method, Filed 등 java.lang.reflect 패키지에 있는 클래스들을 활용하여 프로그래밍한다.
* 일반적으로 자료형을 알 수 있는 경우에는 사용하지 않는다.
*/

/*
* Class.forName() 메서드로 동적 로딩하기
* 동적 로딩이란 : 컴파일시에 데이터 타입이 모두 binding 되어 자료형이 로딩되는 것 (static loading) 이 아니라, 실행 중에 데이터
* 타입을 알고 binding 되는 방식.
* 프로그래밍 할때에는 어떤 클래스를 사용하지 모를때 이를 변수로 처리하고, 실행될때 해당 변수에 대입된 값의 클래스가 실행될 수 있도록
* Class 클래스에서 제공하는 static 메서드이다. (예를 들어, DB 등을 사용할때 여러 종류의 DB를 라이브러리로 binding해서 컴파일해주면
* 오버헤드가 발생할 수 있으므로 실제로 프로그램이 동작할때 사용하는 DB를 연결시켜 오버헤드를 줄일때 사용할 수 있다.)
* 실행시에 로딩되므로 경우에따라 다른 클래스가 사용될 수 있어 유용하다.
* 컴파일 타임에 체크할 수 없으므로 해당 문자열에 대한 클래스가 없는 경우 예외 (ClassNotFoundException) 가 발생할 수 있다.
*/