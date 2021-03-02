// new 키워드를 사용하지 않으면 생성자를 호출할 수 없는데, 생성자에서 다른 생성자를 호출할 때 this를 사용할 수 있다.
// !!단 생성자 내에서만!! this를 사용하여 다른 생성자를 호출하는 것이 가능하다. this의 두 번째 역할.

package thisex;

class Person {
	String name;
	int age;
	
	public Person() {
		//name = "이름없음"; 
		//age = 1;
		// name과 age의 default 값을 설정하고 싶은 경우, 아래 생성자 오버로딩에서 name과 age 멤버변수에 값을
		// 넣는 생성자가 있기 때문에 해당 생성자를 재사용할 수 있다. 따라서 해당 생성자를 사용하기 위해 this를 사용해 다른 생성자를 호출한다.
		// 특히 안드로이드에서 다른 생성자를 호출하고 싶은 경우 this를 많이 사용한다.
		
		// 이때 생성자 안에서 다른 생성자를 호출하는 경우에는 그 위에 어떠한 statement도 올 수 없다.
		// 왜냐하면 아직 생성자가 호출되지 않아서 인스턴스가 생성되지 않았기 때문에 생성되지 않은 메모리에 값을
		// 할당하는 오류가 발생할 수 있으므로 힙 메모리와는 상관없는 지역변수를 사용하더라도 혹시 모를 오류를 막기 위해 오류를 발생시킨다.
		
		this("이름없음", 1);
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person returnSelf() {
		return this; // this를 통해 자신의 주소를 반환 한다. this의 세 번째 역할.
	}
}

public class CallAnotherConstructor {
	public static void main(String args[]) {
		Person p1 = new Person();
		System.out.println(p1.name);
		
		System.out.println(p1.returnSelf());
	}

}
