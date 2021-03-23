// 스트림 (stream)
// 자료의 대상과 관계 없이 동일한 연산을 수행한다.
// -> 배열, 컬렉션을 대상으로 동일한 연산을 수행한다.
// -> 일관성 있는 연산으로 자료의 처리를 쉽고 간단하게 한다.

// 한번 생성하고 사용한 스트림은 재사용할 수 없다.
// -> 자료에 대한 스트림을 생성하여 연산을 수행하면 스트림은 소모된다.
// -> 다른 연산을 위해서는 새로운 스트림을 생성해야 한다.

// 스트림 연산은 기존 자료를 변경하지 않는다.
// -> 자료에 대한 스트림을 생성하면 별도의 메모리 공간을 사용하므로 기존 자료를 변경하지 않는다.

// 스트림 연산은 중간 연산과 최종 연산으로 구분된다.
// -> 스트림에 대해 중간 연산은 여러 개 적용될 수 있지만, 최종 연산은 마지막에 한번만 적용된다.
// -> 최종 연산이 호출되어야 중간 연산의 결과가 모두 적용된다. 이를 '지연 연산' 이라고 한다.

package stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class IntArrayTest {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4, 5};
		
		IntStream stream = Arrays.stream(arr);
		
		// int sum = Arrays.stream(arr).sum(); // Arrays의 stream 메서드를 통해 스트림 생성이 가능하다.
		
		int sum = stream.sum(); // 변수에 할당하여 사용할 수도 있지만, 재사용은 불가능하다.
		System.out.println(sum);
		
		// int count = (int)stream.count(); // 위에서 sum() 메서드를 통해 최종연산이 수행되고 소모가 되었으니 재사용이 불가능하다.
		int count = (int)Arrays.stream(arr).count(); // 스트림을 또 사용하기 위해서는 스트림을 다시 생성해주어야 한다.
		System.out.println(count);
	}
}
