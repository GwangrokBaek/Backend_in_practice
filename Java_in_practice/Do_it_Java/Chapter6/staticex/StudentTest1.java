package staticex;

public class StudentTest1 {

	public static void main(String[] args) {
		// System.out.println(Student2.serialNum); // 클래스의 static 변수는 인스턴스 생성과 상관없이 프로그램이 메모리에
		// 로드될 때 데이터 영역에 저장되므로 인스턴스를 생성하기 전에 static 변수를 사용할 수 있다.
		
		Student2 studentJ = new Student2();
		System.out.println(studentJ.studentID);
		
		Student2 studentT = new Student2();
		System.out.println(studentT.studentID);
		
		// System.out.println(studentJ.serialNum); // 클래스의 static 변수 클래스 변수라고도 불리는데 인스턴스에 상관없이
		// 데이터 영역에서 관리되는 클래스 자체의 변수이므로 참조 변수로서 호출하지 않아도 클래스를 사용해서 호출할 수 있다.
		// System.out.println(studentT.serialNum);
		
		// System.out.println(Student2.serialNum); // 클래스의 static 변수는 클래스에서 바로 참조하여 사용 가능.
		
		System.out.println(Student2.getSerialNum());
	}

}
