package reference;

public class StudentTest2 {

	public static void main(String[] args) {
		Student2 studentJames = new Student2(100, "James");
		studentJames.setKorea(100);
		studentJames.setMath(100);
		
		Student2 studentTomas = new Student2(100, "James");
		studentTomas.setKorea(80);
		studentTomas.setMath(60);
		
		studentJames.showStudentInfo();
		studentTomas.showStudentInfo();
	}

}
