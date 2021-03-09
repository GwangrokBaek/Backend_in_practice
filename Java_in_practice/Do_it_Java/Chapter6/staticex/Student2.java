// static 변수 : 여러 개의 인스턴스가 같은 메모리의 값을 공유하기 위해 사용한다.
// static 메서드 : 클래스 메서드라고도 한다. 메서드에 static 키워드를 사용하여 구현할 수 있다.

package staticex;

public class Student2 {
	private static int serialNum = 10000; // serialNum은 studentID의 기준이 되는 값이므로 중요한 값으로서 private으로
	// 보호할 수가 있다.
	
	int studentID;
	String studentName;
	
	public Student2(){
		serialNum++;
		studentID = serialNum;
	}

	public static int getSerialNum() { // static 메서드에서 인스턴스 변수는 사용할 수 없다.
		int i = 10; // 지역변수는 메서드가 호출되고 사라지므로 static 메서드에서 사용 가능.
		
		i++;
		System.out.println(i);
		
		// studentName = "홍길동"; // studentName은 인스턴스 변수 (멤버 변수) 이므로 static 메서드에서 사용 불가능.
		// 왜냐하면 변수들의 생성 시점이 다르기 때문.
		// 지역변수는 static 메서드가 호출될 때 생성되므로 static 메서드에서 사용 가능하지만, 인스턴스 변수의 경우 인스턴스가
		// new 키워드로 생성될 때 인스턴스 변수가 생성된다. 하지만 static 메서드의 경우, 인스턴스를 생성하지 않아도 
		// 클래스를 직접적으로 참조하여 사용이 가능하므로 생성이 불확실한 인스턴스 변수를 사용할 수 없어 에러를 발생시키게 된다.
		
		return serialNum; // static 변수 (클래스 변수)
	}
}
