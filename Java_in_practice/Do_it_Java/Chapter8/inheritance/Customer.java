// 상속 : 클래스를 정의할 때 이미 구현된 클래스를 상속받아서 속성이나 기능이 확장되는 클래스를 구현하는 것
// 상속하는 클래스 : 상위 클래스, parent class, base class, super class
// 상속받는 클래스 : 하위 클래스, child class, derived class, subclass
// 클래스 상속 문법
// class B extends A {
//
// }
// 이때 상위 클래스는 하위 클래스 보다 일반적인 의미를 가진다.
// 하위 클래스는 상위 클래스 보다 구체적인 의미를 가진다.
// extends 뒤에는 단 하나의 class만 사용할 수 있다. 자바는 single inheritance만을 지원한다.

// 상속을 활용한 고객관리 프로그램
// 고객의 정보를 활용하여 고객 맞춤 서비스를 구현할 수 있다. 이때 고객의 등급에 따라 차별화된 할인율과 포인트를 지급한다.
// 등급에 따른 클래스를 따로 구현하는 것이 아닌 일반적인 클래스를 먼저 구현하고 그보다 기능이 많은 클래스를 상속을 활용하여 구현한다.

package inheritance;

public class Customer {
	protected int customerID; // 외부 클래스에서는 해당 변수에 접근하지 못하고, 상속 받은 클래스에서는 접근할 수 있도록 하기 위해
	// protected로 변수 정의. protected로 정의한 변수는 패키지가 다르더라도 상속 받은 클래스에서 사용 가능.
	protected String customerName;
	protected String customerGrade;
	int bonusPoint;
	double bonusRatio;
	
	// 접근 제한자 가시성
	// public : 외부 클래스, 하위 클래스, 동일 패키지, 내부 클래스
	// protected : 하위 클래스, 동일 패키지, 내부 클래스
	// 선언되지 않음 (default) : 동일 패키지, 내부 클래스
	// private : 내부 클래스
	
	// 새로운 고객 등급이 필요한 경우
	// 단골고객에 대한 혜택이 필요한 겨우에 우수 고객을 관리하기 위해 다음과 같이 혜택을 줄 수 있다.
	// 고객 등급 : VIP
	// 제품 구매 할인율 : 10%
	// 보너스 포인트 : 5%
	// 담당 전문 상담원 배정
	
	// private int saleRatio; 새로운 고객 등급이 추가되었기에 고객 등급에 따라 다른 혜택을 주기 위해 정보 추가.
	// private int agentID; 하지만 일반 고객에는 필요 없는 정보이다. 따라서 코드가 점점 헤비해지면서 유지보수가 힘들어질 것이므로
	// 상속을 사용해주는 것이 바람직하다.
	
	/*
	public Customer() {
		// super(); 상위 클래스인 Customer 클래스에서도 super()를 호출하는데 이때에는 최상위 클래스인 object 클래스를 호출한다.
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		
		System.out.println("Customer() 호출");
	}
	*/
	
	public Customer(int customerID, String customerName) {
		this.customerID = customerID;
		this.customerName = customerName;
		customerGrade = "SILVER";
		bonusRatio = 0.01;
		
		System.out.println("Customer(int, String) 호출");
	}
	
	public int calcPrice(int price) {
		/* 고객 등급에 따라 if else 문을 통해서 차별화된 혜택 부여가 가능하다. 하지만 이후에 또 다른 등급을 추가하는 경우가
		 * 발생할 수도 있으며, 그 경우 if else 문이 계속 증가하게 되는데, 하나의 메서드에 너무 많은 if else 문이 작성되는 경우
		 * 상속을 쓰는 것이 바람직하다.
		
		if (customerGrade == "SILVER") {
			bonusPoint += price * bonusRatio;
		}
		else if (customerGrade == "VIP") {
			bonusPoint += ...
		}
		else if (customerGrade == "GOLD") {
		}
		*/
		
		bonusPoint += price * bonusRatio;
		return price;
	}
	
	public String showCustomerInfo() {
		return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "입니다.";
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerGrade() {
		return customerGrade;
	}

	public void setCustomerGrade(String customerGrade) {
		this.customerGrade = customerGrade;
	}
}
