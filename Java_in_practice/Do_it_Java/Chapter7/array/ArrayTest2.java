// 배열의 길이의 속성 : length
// 자료가 있는 요소만 출력 하려면 크기에 대한 저장을 따로 해주어야 한다.

package array;

public class ArrayTest2 {
	public static void main(String[] args) {
		double[] num = new double[5];
		int size = 0;
		
		num[0] = 10.0;
		size++;
		num[1] = 20.0;
		size++;
		num[2] = 30.0;
		size++;
		
		double total = 1;
		for (int i = 0; i < size; i++) {
			total *= num[i];
		}
		
		System.out.println(total);
	}
}
