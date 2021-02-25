// 서로 다른 자료형의 값이 대입되는 경우에는 형 변환이 일어나는데, 형 변환에는 2가지 종류가 있다.
// 묵시적 형변환 : 작은 수에서 큰 수로 즉, 덜 정밀한 수에서 더 정밀한 수로 대입되는 경우.
// 명시적 형변환 : 묵시적 형 변환의 반대 경우. 이때 변환되는 자료형을 명시해야 한다.
// 명시적 형변환의 경우 자료의 손실이 발생할 수 있다.

package binary;

public class ImplicitConversion {
	public static void main(String[] args) {
		byte bNum = 10;
		int num = bNum;
		
		System.out.println(num);
		
		long lNum = 10;
		float fNum = lNum;
		
		System.out.println(fNum);
		
		double dNum = fNum + num;
		
		System.out.println(dNum);
		
		double dNum2 = 3.14;
		int num2 = (int)dNum2;
		
		System.out.println(num2);
	}
}
