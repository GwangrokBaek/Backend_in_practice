/*
 * 인터페이스 : 상속 관계가 아닌 클래스에 (추상 클래스처럼) 기능을 제공하는 구조. 클래스와 비슷한 구조이지만,
 * 정의상 추상 메서드만이 멤버가 될 수 있다는 점이 다르다.
 * 클래스에서 인터페이스를 이용하도록 하게 하는 것을 '인터페이스의 구현' 이라고 한다.
 * 인터페이스를 구현하기 위해서는 implements 를 사용한다.
 * 
 * 인터페이스 정의에서는 수식자를 생략할 수 있다. 이때 변수는 public static final 로, 메서드는 public abstract 로
 * 자동으로 작성된다.
 * 또한 인터페이스는 단일 상속만 가능한 상속과는 달리, 여러개를 구현할 수 있다.
 * 
 * extends 와 implements
 * 다른 클래스를 상속하고, 덧붙여 인터페이스도 같이 구현할 수 있다. 이때 extends 를 먼저 기술한다.
 */

package step1;

interface Greet {
	void greet();
}

interface Bye {
	void bye();
}

class Morning implements Greet, Bye {

	@Override
	public void bye() {
		System.out.println("안녕히 계세요.");
	}

	@Override
	public void greet() {
		System.out.println("안녕하세요.");		
	}
	
}

public class Meet {

	public static void main(String[] args) {
		Morning morning = new Morning();
		morning.greet();
		morning.bye();
	}

}
