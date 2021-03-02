package hiding;

class BirthDay {
	// int day; 자료형 앞에 private 및 public 등 접근 제어자를 쓰지 않는 경우에는 동일한 패키지 내에서는 참조가 가능하다.
	// 이를 default 접근 제어자라고 부른다.
	private int day; // private의 경우, 동일한 클래스 내에서만 사용 가능하다. 따라서 같은 파일이여도 다른 클래스에서는 사용 불가능.
	// 이때 private 변수의 값을 수정하고 싶은 경우 public get, set 메서드를 사용해서 수정해줘야 한다.
	private int month;
	private int year;
	
	public int getDay() {
		return day;
	}
	public void setDay(int day) { // 이런식으로 public 메서드를 활용해 잘못된 값이 입력되는 것을 방지할 수 있다.
		if(month == 2) {
			if(day < 1 || day > 28) {
				System.out.println("날짜 오류입니다.");
			}
		}
		else {
			this.day = day;
		}
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	/* 만약에 private으로 선언한 year 변수에 대한 set 메서드를 작성해주지 않으면, year 변수는 readonly가 된다.
	public void setYear(int year) {
		this.year = year;
	}
	*/
	
	
}

public class BirthDayTest { // 자바 파일 하나에 여러 개의 클래스를 생성할 수 있는데 이때 public 클래스는 단 하나여야 한다.
	// 그리고 public 클래스의 이름은 자바 파일의 이름과 동일해야 한다.
	// 하지만 보통 자바 파일 하나당 하나의 클래스를 선언한다.
	
	public static void main(String[] args) {
		BirthDay day = new BirthDay();
		
		day.setMonth(2);
		day.setDay(30);
		// day.setYear(2018);
	}
}

/*
 * 접근 제어자의 종류
 * public : 외부 클래스 어디에서나 접근할 수 있다.
 * protected : 같은 패키지 내부와 상속 관계의 클래스에서만 접근할 수 있고 그 외 클래스에서는 접근할 수 없다.
 * 아무것도 없는 경우 : default 이며 같은 패키지 내부에서만 접근할 수 있다.
 * private : 같은 클래스 내부에서만 접근할 수 있다.
 * 
 * private으로 선언하여 외부에서 접근하지 못하도록 하는 것을 정보 은닉이라고 한다.
 */