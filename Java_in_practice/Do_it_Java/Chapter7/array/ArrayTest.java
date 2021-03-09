// 배열 동일한 자료형의 변수를 한꺼번에 순차적으로 관리할 때 사용.
// 이때 배열의 데이터들은 물리적으로 연속적이며, 논리적으로도 연속적이다.

package array;

public class ArrayTest {
	public static void main(String[] args) {
		// int[] numbers = new int[3];
		int[] numbers;
		numbers = new int[3]; // 배열 선언을 할때에는 new 키워드와 함께 대괄호 안에 배열의 길이를 명시해주어야 한다.
		
		// int[] numbers = {0, 1, 2}; // 배열 선언과 동시에 초기화할때에는 new 키워드와 자료형 없이 중괄호 만으로도 초기화 가능.
		// numbers = new int[] {1, 2, 3}; // 배열 선언과 초기화를 따로 할때에는 중괄호 뿐만 아니라 앞에 new 키워드와
		// 배열 자료형 및 배열 기호를 붙여줘야한다.
		// int[] numbers = new int[] {0, 1, 2}; // 배열 초기화를 할때에는 대괄호 안에 배열의 길이를 생략해주어야 한다.
		
		numbers[0] = 1;
		numbers[1] = 2;
		numbers[2] = 3;
		
		for(int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
		
		double[] studentIDs = new double[5]; // 초기화 없이 선언만 한 경우, 정수는 0, 실수는 0.0,
		// 객체 배열은 null로 초기화 된다.
		for (int i = 0; i < studentIDs.length; i++) {
			System.out.println(studentIDs[i]);
		}
	}
}
