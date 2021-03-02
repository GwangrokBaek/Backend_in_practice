// 객체 지향 프로그래밍에서 메서드는 행위, 속성은 상태를 의미한다. 이때 버스, 지하철, 학생이라는 클래스가 있다면
// 학생의 경우 이름, 학년, 돈 이라는 상태가 있을 것이고, 학생과 버스 간의 상호작용 즉, 클래스 간의 협력을 표현하고 싶을때
// '타다' 라는 행위 즉, 메서드로 이를 구현할 수가 있다.

package cooperation;

public class Student {
	String studentName;
	int grade;
	int money;
	
	public Student(String studentName, int money) {
		this.studentName = studentName;
		this.money = money;
	}
	
	public void takeBus(Bus bus) {
		bus.take(1000); // bus 객체를 전달 받아서 해당 객체의 메서드를 호출하여 상호작용을 할 수 있다.
		money -= 1000;
	}
	
	public void takeSubway(Subway subway) { // 이때 파라미터로 받는 객체는 생성된 인스턴스여야 한다.
		subway.take(1000);
		money -= 1500;
	}
	
	
	/*
	public void takeTrans(Trans trans) { // 버스와 지하철의 경우 탈것이라는 공통된 개념을 가지기 때문에 이를
		// Trans 라는 추상 클래스를 선언하여 해당 클래스를 상속받게끔 할 수 있으며, 또한 Student의 경우
		// Bus 클래스와 Subway 클래스에 대한 take 메서드를 일일이 구현하는 것이 아니라 추상 클래스인 Trans의
		// 추상 메서드를 호출하는 것으로 각각의 상황에 대한 메서드를 호출할 수가 있다. 이때 Trans를 상속 받은 Bus와 Subway는
		// 추상 메서드인 take를 오버라이딩 해주어야 한다.	
	}
	*/
	
	public void showInfo() {
		System.out.println(studentName + "님의 남은 돈은" + money + "입니다.");
	}
}
