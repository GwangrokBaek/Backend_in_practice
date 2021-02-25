// JRE는 런타임 환경으로 라이브러리 파일 및 기타 파일들과 함께 JVM을 포함한다.
// JDK는 자바 개발도구로 개발을 위해 필요한 도구 (javac, java 등)을 포함한다.
// package는 소문자로, class는 대문자로 시작.
// package는 파이썬의 package와 동일하다고 생각. 파일들을 모아 관리하는 디렉토리 즉, 소스의 묶음이라고 생각.
// Java는 class 파일을 실행시키는 방식. 이때 JVM이 class 파일을 실행시킨다. 따라서 플랫폼에 종속적이지 않다.
// Java 컴파일러를 통해 소스 파일을 class 파일로 변환시키고 이것을 JVM이 실행시키는 방식.
// Java의 장점
// 1. 객체 지향 언어이기 때문에 유지보수가 쉽고 확장성이 좋다.
// 2. 프로그램이 안정적. (메모리 제어 불가능, GC가 대신 동적 메모리 수거)
// 3. 풍부한 기능을 제공하는 오픈소스.

package first;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello, World");
	}
}