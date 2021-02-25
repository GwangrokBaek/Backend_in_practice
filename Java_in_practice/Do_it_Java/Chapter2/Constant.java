// 리터럴은 프로그램에서 사용하는 모든 숫자, 값, 논리 값이다.
// 이때 리터럴에 해당되는 값은 특정 메모리 공간 상수 풀(constant pool)에 저장되어 있다.
// 필요한 경우, 즉 사용하는 경우 상수 풀에서 해당 값을 가져와서 사용한다.

package binary;

public class Constant {

	public static void main(String[] args) {
		// 자바에서는 상수를 final 키워드를 사용해서 선언.
		
		final int MAX_NUM = 100;
		final double PI = 3.14;
		
		System.out.println(PI);

	}

}
