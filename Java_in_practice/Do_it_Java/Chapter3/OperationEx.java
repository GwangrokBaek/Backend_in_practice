// 연산자의 경우 C와 모두 동일. 이때 >>>와 <<<는 shift 연산자와 동일하지만 남는 공간을 부호비트가 아닌 무조건 0으로 채워준다.
// 비트 연산자는 정수에만 사용 가능.

package chapter3;

public class OperationEx {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 10;
		
		int result = num1 & num2;
		System.out.println(result);
		
		num2 <<= 3;
		System.out.println(num2);
		
		num1 >>>= 3;
		System.out.println(num1);

	}

}
