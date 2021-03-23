// 보통 인터페이스 설계는 시니어 엔지니어가 하고, 인터페이스 구현은 주니어 엔지니어가 한다.

package interfaceex;

public abstract class Calculator implements Calc {
	// 인터페이스를 구현할때에는 extends가 아닌, implements 키워드를 사용한다. 이때 일부만 구현할때에는 abstract 클래스를 사용.

	@Override
	public int add(int num1, int num2) {
		return num1 + num2;
	}

	@Override
	public int subtract(int num1, int num2) {
		return num1 - num2;
	}
}
