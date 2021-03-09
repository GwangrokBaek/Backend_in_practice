package singleton;

import java.util.Calendar;

public class CompanyTest {

	public static void main(String[] args) {
		Company c1 = Company.getInstance();
		Company c2 = Company.getInstance();
		
		System.out.println(c1);
		System.out.println(c2);
	}
	
	Calendar cal = Calendar.getInstance(); // 시간 데이터를 관리하는 캘린더의 경우, 어떤 위치에서도
	// 동일한 하나의 값을 가져야하므로 싱글턴 패턴을 통해 클래스를 관리한다.
}
