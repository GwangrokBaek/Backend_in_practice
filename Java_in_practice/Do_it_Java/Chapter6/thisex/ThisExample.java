// this 키워드는 다음 세 가지 역할을 수행한다.
// 1. 자신의 메모리를 가리킨다.
// 2. 생성자에서 다른 생성자를 호출한다.
// 3. 자신의 주소를 반환한다.

package thisex;

class Birthday {
	int day;
	int month;
	int year;
	
	public void setYear(int year) {
		year = year; // this를 명시해주지 않을 경우, 인자로 넘어온 지역변수 year에다 인자 year의 값을 넣게되는 의미 없는 코드가 된다.
		// java에서는 가장 가까운 변수를 사용한다.
		// 만약 파라미터가 year가 아니라 y라면 이때 year는 클래스 Birthday의 멤버변수 year를 사용한다.
		
		this.year = year;
	}
	
	public void printThis() {
		System.out.println(this); // 클래스의 여러 인스턴스는 각자 다른 메모리에 위치하게 되므로 this가 가리키는 값은
		// 인스턴스마다 다르다. this 키워드의 첫 번째 역할.
	}
}

public class ThisExample {
	public static void main(String args[]) {
		Birthday b1 = new Birthday();
		Birthday b2 = new Birthday();
		
		System.out.println(b1);
		b1.printThis();
		System.out.println(b2);
		b2.printThis();
	}
}
