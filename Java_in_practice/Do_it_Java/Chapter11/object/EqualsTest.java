// equals() 메서드
// 두 인스턴스의 주소 값을 비교하여 true/false를 반환한다.
// 재정의하여 두 인스턴스가 논리적으로 동일한지 여부를 반환할 수 있다.
// 같은 학번의 학생인 경우 여러 인스턴스의 주소 값은 다르지만, 같은 학생으로 처리해야 학점이나 정보 산출에 문제가 생기지 않으므로
// 이런 경우 equals() 메서드를 재정의한다.

// String과 Integer의 equals() 메서드
// String은 같은 문자열의 경우 true를 반환하도록 재정의되어 있다.
// Integer는 정수 값이 같은 경우 true를 반환하도록 재정의되어 있다.
// 이외에도 여러 클래스에서 메서드가 재정의되어 있는 경우가 있다.

// hashCode() 메서드
// hash : 정보를 저장, 검색하기 위해 사용하는 자료구조이다.
// 자료의 특정 값 (키 값) 에 대해 저장 위치를 반환해주는 해시 함수를 사용한다.
// 해시 함수는 어떤 정보인가에 따라 다르게 구현된다.
// hashCode() 메서드는 인스턴스의 저장 주소를 반환한다.
// 힙 메모리에 인스턴스가 저장되는 방식이 hash이다.

package object;

class Student {
	int studentID;
	String studentName;
	
	Student(int studentID, String studentName) {
		this.studentID = studentID;
		this.studentName = studentName;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) { // 기존 Object 클래스의 equals 메서드는 들어오는 인자값이
			// object로 업캐스팅되어 들어오기 때문에 이를 다시 다운캐스팅해준다.
			
			Student std = (Student)obj;
			if(studentID == std.studentID) return true;
			else return false;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return studentID;
	}
}

public class EqualsTest {
	public static void main(String[] args) {
		String str1 = new String("test");
		String str2 = new String("test");
		
		System.out.println(str1 == str2); // 두 객체의 힙 메모리 어드레스가 다르기 때문에 false를 반환.
		System.out.println(str1.equals(str2)); // 원래 equals() 메서드는 == 연산자와 동일한 역할을 한다. 즉, 두 객체의
		// 힙 메모리 어드레스가 동일한지를 체크한다. 하지만 String 클래스에서는 equals() 메서드가 두 문자열이 동일한지를 체크하는 것으로
		// 재정의되어 있기 때문에 true를 반환한다. (두 객체의 물리적 동일성이 아닌, 논리적 동일성을 체크)
		
		Student std1 = new Student(10001, "Tomas");
		Student std2 = new Student(10001, "Tomas");
		
		System.out.println(std1 == std2);
		System.out.println(std1.equals(std2)); // 일반 객체에서는 equals() 메서드가 재정의되어 있지 않으므로 == 연산자와
		// 동일한 역할을 수행하기에 false를 출력. 이때 논리적 동일성을 체크해주기 위해 equals() 메서드를 재정의해주면 된다.
		
		System.out.println(std1.hashCode()); // std1과 std2는 서로 다른 메모리 위치에 저장되므로 서로 다른 해시코드를 출력.
		System.out.println(std2.hashCode());
		System.out.println(System.identityHashCode(std2));
		
		System.out.println(str1.hashCode()); // str1과 str2도 서로 다른 메모리 위치에 저장되므로 서로 다른 해시코드를
		System.out.println(str2.hashCode()); // 출력해야하지만, 동일한 값을 출력한다. 왜냐하면 hashCode() 메서드가
		// String 클래스에서 재정의되어 있기 때문이다.
		
		System.out.println(System.identityHashCode(str1)); // 실제 해시코드 값을 출력하기 위해서는
		// System.identityHashCode() 메서드를 사용해야 한다.
		System.out.println(System.identityHashCode(str2));
		
		// hashCode()의 반환 값 : 자바 가상 머신이 저장한 인스턴스의 주소값을 10진수 정수로 나타낸다.
		// 위에서 String 클래스의 경우 문자열의 값이 같은 경우, 즉 논리적으로 동일한 경우 해시코드의 값이 동일하다.
		// 이는 논리적 동일함을 보이기 위해 equals() 메서드를 재정의 하였다면, hashCode() 메서드도 재정의하여 동일한 값이
		// 반환되어야 하기 때문이다.
		// 즉, 객체지향 프로그래밍에서는 재정의된 equals() 메서드의 값과 동일한 hashCode() 반환 값을 가지도록 약속을 해두었다.
		// 따라서 String 클래스에서는 hashCode() 메서드도 재정의되어 있다.
		// 만약 다른 클래스에서 equals() 메서드와 hashCode() 가 동일하게 재정의되지 않아서 다른 값을 출력하는 경우에는
		// 컬렉션 프레임워크가 제대로 동작하지 않는 문제가 발생할 수 있다.
		
		// String 클래스 : 동일한 문자열 인스턴스에 대해 동일한 정수값이 반환된다.
		// Integer 클래스 : 동일한 정수값의 인스턴스에 대해 동일한 정수값이 반환된다.
		
	}
}
