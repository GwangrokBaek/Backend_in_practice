package innerclass;

class Outer {
	
	int outNum = 100;
	static int sNum = 200;
	
	public Runnable getRunnable(int i) { // 지역 내부 클래스. Runnable 타입을 반환하는 메서드를 정의한다.
		
		int localNum = 100;
		class MyRunnable implements Runnable { // 메서드 안에서 Runnable 인터페이스를 구현한 지역 내부 클래스인 MyRunnable 클래스 정의.

			@Override // Runnable 인터페이스를 구현할 때에 run() 메서드를 재정의해주어야 한다.
			public void run() {
				// localNum += 100; // 메서드의 지역 변수를 출력하는 것은 가능하지만, 그 값을 변경시키는 것은 에러가 발생한다.
				// i += 200; // 인자도 마찬가지이다.
				// 왜냐하면 메서드의 지역 변수나 인자는 스택 영역에 자리 잡게 되는데, 메서드가 종료되면 메모리가 사라지기 때문이다. 아래 LocalInnerTest 클래스에서처럼
				// getRunnable() 메서드를 사용해 반환된 인스턴스를 변수에 할당하고, 그 변수를 통해 run 메서드를 호출하면 getRunnable() 메서드에 선언되어 있는
				// 지역변수 및 파라미터는 사용할 수 없다. 따라서 에러 발생.
				// 이때 외부 클래스에 선언되어 있는 지역변수 및 파라미터를 변경하지 못하므로 이들은 final 로 선언된다.
				
				outNum += 10; // outNum 은 지역 변수가 아니라 인스턴스 변수이므로 변경 가능.
				
				System.out.println(outNum);
				System.out.println(sNum);
				System.out.println(localNum);
				System.out.println(i);
			}
		}
		
		return new MyRunnable(); // 외부 클래스의 메서드를 호출할 때 Runnable 인터페이스를 구현한 지역 내부 클래스를 구현한 다음 이에 대한 인스턴스를 반환한다.
	}
	
	public Runnable getRunnable2(int i) {
		int localNum = 100;
		
		return new Runnable() { // 익명 내부 클래스 (메서드 내부 구현 방법). 위의 지역 내부 클래스의 경우, 클래스 명이 메서드 안의 지역 내부 클래스 정의에서만 사용된다.
			// 따라서 클래스의 이름이 필요 없으므로 이를 생략하는 방법이 바로 익명 내부 클래스이다.
			// 이때 바로 외부 클래스 메서드의 return 문에다 new 키워드를 통해 생성자를 구현함으로써 생성 가능하다.
			
			@Override
			public void run() {
				outNum += 10;
				
				System.out.println(outNum);
				System.out.println(sNum);
				System.out.println(localNum);
				System.out.println(i);
			}
		}; // return 문에 세미콜론 붙여줘야 한다.
	}
	
	Runnable runnable = new Runnable() { // 익명 내부 클래스 (변수에 대입하여 직접 구현 방법).
		// 외부 클래스의 변수에 바로 생성자를 할당함으로써 익명 내부 클래스 생성이 가능하다.
		// 보통 안드로이드에서 클래스 내부에서 스레드를 만들어 돌릴 때 사용되곤 한다. 익명 내부 클래스는 실무에서 많이 사용된다.
		
		// 익명 내부 클래스의 경우, 하나의 추상 클래스나 하나의 인터페이스만 구현할 수 있다. 왜냐하면 일반적인 클래스 정의에서 extends 및 implements 를 통해 클래스나 인터페이스를
		// 구현할 수 있는 것과 달리, 익명 내부 클래스의 경우에는 클래스 또는 인터페이스의 타입을 명시한 다음, 해당 타입의 객체에 생성자를 할당하는 방식이라서 명시된 클래스 또는
		// 인터페이스만 구현이 가능하다. 이때 명시되는 타입의 개수는 1개만 가능하므로 하나만 구현 가능.

		@Override
		public void run() {
			System.out.println("runnable");
			
		}
		
	};
	
}

public class LocalInnerTest {

	public static void main(String[] args) {
		Outer outer = new Outer();
		// outer.getRunnable(20).run(); // getRunnable() 메서드 호출 시, MyRunnable 클래스의 인스턴스가 생성되고, 해당 인스턴스의 run() 메서드를 호출할 수 있다.
		Runnable runnable = outer.getRunnable(20); // getRunnable() 메서드 호출이 종료되면서 getRunnable() 메서드의 지역변수 및 파라미터는 스택 영역에서 사라진다.
		runnable.run();
		
		outer.runnable.run(); // 익명 내부 클래스 생성 두 번째 방법에 의해 외부 클래스의 runnable 변수에 익명 내부 클래스의 인스턴스가 생성 및 할당 되었으므로 runnable
		// 객체를 통해 run() 메서드 호출 가능.
	}
}
