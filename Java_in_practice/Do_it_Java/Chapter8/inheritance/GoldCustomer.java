package inheritance;

public class GoldCustomer extends Customer { // source -> Override / Implement methods 를 클릭하면 재정의할 메서드에 대한
	// 기본 재정의 코드를 작성해준다.
	
	public GoldCustomer(int customerID, String customerName) {
		super(customerID, customerName);
		bonusRatio = 0.05;
	}

	@Override // @Override 는 annotation의 일종으로 컴파일러에게 이 코드는 재정의된 코드임을 알려줌으로써 파라미터 체크 등 재정의에 대한
	// 에러를 체크하게끔 한다.
	public int calcPrice(int price) {
		return super.calcPrice(price);
	}

	@Override
	public String showCustomerInfo() {
		return super.showCustomerInfo();
	}
}
