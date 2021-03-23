// 인터페이스 (interface) : 모든 메서드가 추상 메서드로 이루어진 클래스
// 형식적인 선언만 있고 구현은 없다.
/*
 * interface 인터페이스 이름 {
 *     public static final float pi = 3.14f;
 *     public void add();
 * }
 */
// 인터페이스에 선언된 모든 메서드는 public abstract로 추상 메서드이다.
// 인터페이스에 선언된 모든 변수는 public static final로 상수이다.

// 클래스에서 인터페이스 구현하기
// Calc <... Calculator <--- CompleteCalc
// Calc 인터페이스를 Calculator 클래스에서 구현한다. 이를 타입 상속이라고도 부른다. (interface의 implements)
// Calc의 모든 추상 메서드를 구현하지 않으면 Calculator는 추상 클래스가 된다.
// CompleteCalc 클래스가 Calculator를 상속받은 후 모든 메서드를 구현한다. 이를 구현 상속이라고도 부른다. (class의 extends)
// CompleteCalc는 생성가능한 클래스이다.
// 이때 implements와 extends를 동시에 사용할 수도 있다.

package interfaceex;

public interface Calc {
	
	double PI = 3.14; // interface의 멤버 변수는 컴파일 과정에서 default로 public static final이 된다.
	int ERROR = -99999999;
	
	// interface에서 모든 메서드는 컴파일 과정에서 default로 public abstract가 된다.
	int add(int num1, int num2);
	int subtract(int num1, int num2);
	int times(int num1, int num2);
	int divide(int num1, int num2);
	
	default void description() { // 인터페이스는 구현 코드를 가질 수 없으므로 default 키워드가 없으면 오류가 발생한다.
		System.out.println("정수 계산기를 구현합니다.");
		myMethod(); // 디폴트 메서드에서 private 메서드 호출.
	}
	
	static int total(int[] arr) { // static은 인스턴스 생성과는 상관없이 사용 가능.
		int total = 0;
		
		for (int i: arr) {
			total += i;
		}
		myStaticMethod(); // 정적 메서드에서 private static 메서드 호출 가능.
		return total;
	}
	
	// private 메서드는 오버라이딩이 불가능하고 동일 클래스 내부에서만 사용 가능하다.
	private void myMethod() {
		System.out.println("private 메서드 입니다.");
	}
	
	private static void myStaticMethod() { // private static은 정적 메서드에서 사용이 가능하다.
		System.out.println("private static 메서드입니다.");
	}
}

// 인터페이스를 제공하는 쪽을 서버라고 할 수 있으며, 인터페이스를 가져다 쓰는 쪽을 클라이언트라고 할 수 있다.

/*
* 인터페이스의 요소
* 상수 : 모든 변수는 상수로 변환된다.
* 추상 메서드 : 모든 메서드는 추상 메서드로 구현된다.
* 디폴트 메서드 : 기본 구현을 가지는 메서드, 구현 클래스에서 재정의할 수 있다. (인터페이스에서 선언뿐만 아니라 구현을 해주어
* 인터페이스를 구현한 클래스에서 해당 메서드를 재정의하지 않은 경우 default로 기능을 제공하도록 하는 메서드이다. 이때 default 메서드를
* 통해 인터페이스 내에 코드가 구현되어 있더라도 인터페이스의 new는 불가능하다.)
* 정적 메서드 : 인스턴스 생성과 상관 없이 인터페이스 타입으로 사용할 수 있는 메서드이다.
* private 메서드 : 인터페이스를 구현한 클래스에서 사용하거나 재정의할 수 없다. 인터페이스 내부에서만 기능을 제공하기 위해
* 구현하는 메서드이다.
*/
