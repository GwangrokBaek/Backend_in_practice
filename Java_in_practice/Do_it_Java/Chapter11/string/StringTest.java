// String 클래스
// String을 선언하는 두 가지 방법
// String str1 = new String("abc"); 생성자의 매개변수로 문자열을 생성.
// String str2 = "test"; 문자열 상수를 가리키는 방식.
// 이렇게 힙 메모리에 인스턴스로 생성되는 경우와 상수 풀 (constant pool) 에 있는 주소를 참조하는 방법 두 가지가 있다.

// String 클래스로 문자열 연결
// 한번 생성된 String 값 (문자열) 은 불변 (immutable) 이다. (String 클래스에서 문자열의 값을 나타내는 value 가 final로
// 정의되어 있기 때문)
// 따라서 두 개의 문자열을 연결하면 새로운 인스턴스가 생성된다.
// 문자열 연결을 계속하면 메모리 garbage가 많이 생길 수 있다. 따라서 문자열 연결이 많이 수행되는 프로그램이라면 String 클래스가 아닌,
// StringBuilder나 StringBuffer 클래스를 사용하는 것이 효율적이다.

package string;

public class StringTest {

	public static void main(String[] args) {
		String str1 = new String("abc");
		String str2 = new String("abc");
		System.out.println(str1 == str2);
		
		String str3 = "abc"; // 상수 풀의 문자열을 참조하면 모든 문자열이 같은 주소를 가리킨다.
		String str4 = "abc";
		System.out.println(str3 == str4);
		
		String java = new String("java");
		String android = new String("android");
		
		System.out.println(System.identityHashCode(java));
		java = java.concat(android); // java와 android가 연결된 새로운 메모리를 생성하고 이 메모리의 위치를 반환하게 된다.
		System.out.println(java);
		System.out.println(System.identityHashCode(java));
	}
}
