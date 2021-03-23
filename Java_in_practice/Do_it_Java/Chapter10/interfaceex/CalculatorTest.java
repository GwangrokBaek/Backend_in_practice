// 인터페이스 구현과 형 변환
// 인터페이스를 구현한 클래스는 인터페이스 형으로 선언한 변수로 형 변환할 수 있다.
// 상속에서의 형 변환과 동일한 의미이다.
// 단 클래스 상속과 달리 구현코드가 없기 때문에 여러 인터페이스를 구현할 수 있다. (클래스의 경우, 구현코드를 가지기 때문에 여러 개를
// 상속 받으면 diamond problem이 발생하여 모호해질 수 있다. 따라서 상속을 하나만 받을 수 있는 single inheritance 개념을
// 사용하는데, 인터페이스의 경우에는 구현코드가 없으므로 implements 뒤에 여러 개의 인터페이스가 올 수 있다.)
// 형 변환시 사용할 수 있는 메서드는 인터페이스에 선언된 메서드만 사용할 수 있다.

package interfaceex;

public class CalculatorTest {

	public static void main(String[] args) {
		
		int num1 = 10;
		int num2 = 2;
		
		Calc calc = new CompleteCalc(); // interface의 implements 는 타입 상속이므로 업캐스팅이 가능하다.
		System.out.println(calc.add(num1, num2)); // 타입 상속을 통해 인터페이스의 정보를 내포하고 있으므로
		// calc의 위치에서 볼 수 있는 메서드와 변수를 호출할 수 있으며, 이때 호출되는 메서드는 실제 인스턴스가 구현된
		// CompleteCalc의 메서드이다. (가상 메서드 개념)
		// 여기서 CompleteCalc의 showInfo() 는 CompleteCalc에서 정의된 메서드이므로 Calc 타입인 calc 에서는 호출이 불가능하다.
		// 즉 CompleteCalc가 가질 수 있는 타입은 Calc 및 Calculator 등 여러개이며, 이들로 업캐스팅이 가능하다.
		// 여기서 인터페이스인 Calc에 대해 여러개의 구현체를 가질 수 있으며, 이를 통해 다형성을 구현할 수 있다.
		
		// Calc calc1 = new Calc(); Calc는 interface이므로 new가 불가능하다.
		// Calc calc2 = new Calculator(); Calculator는 추상 클래스이므로 new가 불가능하다.
		
		calc.description();
		
		int[] arr = {1, 2, 3, 4, 5};
		int sum = Calc.total(arr); // total 메서드가 정적 메서드이기 때문에 위의 인스턴스 호출 구문이 없어도 사용 가능.
		System.out.println(sum);
	}
}
