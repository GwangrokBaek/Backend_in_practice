package witharraylist;

public class VIPCustomer extends Customer{
	// 상속을 통해 코드를 재사용해서 매우 간결하게 코드를 작성할 수 있다.
	private int agentID;
	private double saleRatio;
	
	public VIPCustomer(int customerID, String customerName, int agentID) {
		// super(); 컴파일러가 하위 클래스를 생성할 때 상위 클래스를 생성하기 위해 super()를 호출한다.
		// 이때 super()는 매개변수가 하나도 없으므로 상위 클래스의 default 생성자를 호출한다.
		// 만약 상위 클래스인 Customer 클래스에서 default 생성자를 사용하지 않는 경우에는 상위 클래스의 매개변수에 알맞게
		// 값을 명시해서 호출해주어야 한다.
		// super(0, null);
		// 하지만 보통 상위 클래스의 생성자가 받는 매개변수와 동일하게 하위 클래스의 생성자에 매개변수를 입력해주는 경우가 많다.
		// 위에서 하위 클래스인 VIPCustomer의 생성자가 상위 클래스인 Customer의 생성자와 동일한 매개변수를 입력받으므로
		// 이를 상위 클래스의 생성자에게 매개변수를 다음과 같이 전달해준다.
		
		super(customerID, customerName);
		
		// super 예약어
		// this가 자기 자신의 인스턴스의 주소를 가지는 것처럼
		// super는 하위 클래스가 상위 클래스에 대한 주소를 가지게 된다.
		// 하위 클래스가 상위 클래스에 접근할 때 사용할 수 있다.
		
		customerGrade = "VIP";
		bonusRatio = 0.05;
		saleRatio = 0.1;
		this.agentID = agentID;
		
		System.out.println("VIPCustomer(int, String) 호출");
	}
	
	public int calcPrice(int price) {
		// 메서드 오버라이딩
		// 상위 클래스에 정의 된 메서드 중 하위 클래스와 기능이 맞지 않거나 추가 기능이 필요한 경우 같은 이름과 매개변수로
		// 하위 클래스에서 재정의 하는 것을 의미한다.
		
		bonusPoint += price * bonusRatio;
		return price - (int)(price * saleRatio);
	}
	
	public int getAgentID() {
		return agentID;
	}

	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo() + "담당 상담원 아이디는 " + agentID + "입니다."; // super를 빼면 자기 자신을 계속 호출하므로 무한루프가 발생한다.
	}
}
