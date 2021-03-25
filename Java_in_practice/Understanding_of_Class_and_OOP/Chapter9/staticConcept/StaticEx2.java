/*
 * System.out.println() 에서 out 과 println 의 정체
 * java.lang.System.out.println(...);
 * - System 은 java.lang 패키지에 묶여 있는 클래스의 이름이다. 하지만 컴파일러가 import java.lang.*; 을
 * 자동으로 삽입해 주기 때문에 java.lang 을 생략할 수 있다.
 * 
 * System.out.println(...);
 * - out 은 클래스 System 의 이름을 통해 접근하므로, 이는 System 클래스의 클래스 변수 이름임을 유추할 수 있다.
 * (즉, static 변수)
 * 
 * System.out.println(...);
 * - out 의 경우 dot 연산자를 통해 참조하는 멤버 변수 및 메서드에 접근이 가능하다. 즉 out 은 참조 변수이며, 
 * println 은 out 이 참조하는 인스턴스의 메소드이다.
 * 
 * main 메서드가 public 이고 static 인 이유
 * public static void main(String[] args) {...}
 * static 인 이유 : 인스턴스 생성과 관계없이 제일 먼저 호출되는 메소드이다.
 * public 인 이유 : main 메소드의 호출 명령은 JVM 에 의해 외부로부터 시작되는 명령이다.
 * 
 * java MyTest [엔터] <- cmd 에서 자바 파일을 실행시키기 위해서는 왼쪽 명령어를 사용한다.
 * 이때 MyTest 클래스 안에 main() 메서드가 있어야 한다.
 * - 클래스명.스태틱 메서드명 으로 해당 메서드에 접근할 수 있는데, JVM 이 MyTest.main() 을 호출하기 때문이다.
 * 
 * 따라서 같은 파일 안에 여러 개의 클래스를 만들 수 있지만 main 메서드가 있는 클래스명으로 위 명령을 실행해야 자바 프로그램이
 * 정상적으로 실행된다. 그렇기 때문에 처음 자바를 배울때 클래스명과 파일명이 같아야 한다고 배운다.
 */

package staticConcept;

import java.util.Random;

// 인스턴스 생성과 관계 없이 static 변수가 메모리 공간에 할당될때 실행이 된다.

public class StaticEx2 {

	static int num;
	
	// static 초기화 블록 (static 은 변수와 메서드 뿐만 아니라 블럭에도 지정할 수 있다.)
	static {
		Random rand = new Random();
		// main 실행 전에 이미 난수값이 대입이 된다.
		num = rand.nextInt(100);
	}
	
	public static void main(String[] args) {
		System.out.println(num); // 프로그램 시작 시 static 변수 및 메서드가 메모리에 로드된다.
		// 즉, main 함수보다 먼저 로드가 되므로 static 변수인 num 을 출력할 수 있다.
	}
}
