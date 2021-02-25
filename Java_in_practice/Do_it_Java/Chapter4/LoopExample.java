// loop 문도 C와 동일.

package chapter4;

public class LoopExample {
	public static void main(String[] args) {
		int sum = 0;
		int num = 1;
		
		while (true) {
			sum += num;
			if (sum > 100) break;
			num++;
		}
		
		System.out.println(sum);
		System.out.println(num);
	}
}