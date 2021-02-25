// 조건 연산자와 switch case문의 경우 C와 동일.

package chapter4;

public class IfExample {
	public static void main(String[] args) {
		int rank = 1;
		char medalColor;
		
		// 자바 7부터 case 값에 문자열을 사용할 수 있다.
		switch (rank) {
			case 1 : medalColor = 'G';
				break;
			case 2 : medalColor = 'S';
				break;
			case 3 : medalColor = 'B';
				break;
			default : medalColor = 'A';
		}
		System.out.println(rank + "등 메달의 색깔은 " + medalColor);
	}

}
