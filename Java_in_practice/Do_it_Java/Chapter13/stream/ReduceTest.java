// reduce() 연산
// 정의된 연산이 아닌 프로그래머가 직접 지정하는 연산을 적용한다.
// 최종 연산으로서 스트림의 요소를 소모하며 연산을 수행한다.
// 배열의 모든 요소의 합을 구하는 reduce() 연산
// Arrays.stream(arr).reduce(0, (a, b) -> a + b); // 여기서 0 는 초깃값이고, (a, b) 는 전달되는 요소, 람다식은 각 요소가 수행해야 할 기능이다.
// 여기서 reduce() 메서드의 첫 번째 파라미터는 초깃값 (기본값) 이고, 두 번째 파라미터는 BinaryOperator 이다.
// 두 번째 요소로 전달되는 람다식에 따라 다양한 기능을 수행한다.
// 이때 두 번째 요소는 BinaryOperator인데 이를 람다식으로 직접 구현할 수도 있고, BinaryOperator 인터페이스를 구현하는 클래스를 생성해서
// 해당 클래스의 메서드로 구현할 수도 있다.

package stream;

import java.util.Arrays;
import java.util.function.BinaryOperator;

class CompareString implements BinaryOperator<String> { //BinaryOperator 는 Functional Interface 이다.
	// 이때 BinaryOperator 는 두 개의 매개변수를 받고, 그 두 개의 매개변수에 대한 연산을 수행하는 틀을 제공한다.

	@Override
	public String apply(String s1, String s2) { // 아래에서 reduce 메서드가 호출될 때 불리는 메서드이다.
		if(s1.getBytes().length >= s2.getBytes().length) return s1;
		else return s2;
	}
	
}

public class ReduceTest {

	public static void main(String[] args) {
		String[] greetings = {"안녕하세요~~", "hello", "Good morning", "반갑습니다"};
		
		System.out.println(Arrays.stream(greetings).reduce("", (s1, s2) -> { // BinaryOperator 에 대해 람다식을 직접
			// 구현하여 비교 메서드를 구현해줄 수 있다.
			if(s1.getBytes().length >= s2.getBytes().length) return s1;
			else return s2; }
		));
		
		String str = Arrays.stream(greetings).reduce(new CompareString()).get();
		// 람다식이 복잡한 경우에 이를 직접 구현하지 않고, BinaryOperator 인터페이스를 구현하는 클래스를 생성하여
		// 이를 통해 비교 메서드를 구현해줄 수도 있다. 이때 이미 구현된 BinaryOperator를 대입하는 경우에는
		// reduce() 메서드에서 초기값을 생략해야 한다.
		System.out.println(str);
	}
}
