// 다형성 구현하기
// 하나의 클래스를 상속 받은 여러 클래스가 있는 경우, 각 클래스마다 같은 이름의 서로 다른 메서드를 재정의 한다.
// 상위 클래스 타입으로 선언된 하나의 변수가 여러 인스턴스에 대입되어 다양한 구현이 실행될 수 있다.

// 다운 캐스팅 - instanceof
// 하위 클래스가 상위 클래스로 형 변환 되는 것은 묵시적으로 이루어진다.
// 다시 원래 자료형인 하위 클래스로 형 변환 하려면 명시적으로 다운 캐스팅을 해주어야 한다.
// 이때 원래 인스턴스의 타입을 체크하는 예약어가 instanceof 이다.
/*
 * Animal hAnimal = new Human();
 * if (hAnimal instanceof Human) { // hAnimal 인스턴스 자료형이 Human 형이라면 (hAnimal의 인스턴스 타입을 체크)
 *     Human human = (Human)hAnimal; // 인스턴스 hAnimal을 Human 형으로 다운 캐스팅을 해준다.
 * }
 */
// 이때 상속 및 오버라이딩으로 해결이 가능하다면 다운 캐스팅을 지양하 오버라이딩을 통해 해결하는 것이 좋다.
// 특정 함수 같은 경우에는 최상위 클래스인 Object 타입으로 값을 반환하는 경우가 있는데, 이러한 경우에 다운 캐스팅을 사용할 수 있다.

package inheritance;

class Animal {
	public void move() {
		System.out.println("동물이 움직입니다.");
	}
}

class Human extends Animal {
	public void move() {
		System.out.println("사람이 두발로 걷습니다.");
	}
	
	public void readBook() {
		System.out.println("사람이 책을 읽습니다.");
	}
}

class Tiger extends Animal {
	public void move() {
		System.out.println("호랑이가 네발로 뜁니다.");
	}
	
	public void hunting() {
		System.out.println("호랑이가 사냥을 합니다.");
	}
}

class Eagle extends Animal {
	public void move() {
		System.out.println("독수리가 하늘을 납니다.");
	}
	
	public void flying() {
		System.out.println("독수리가 하늘을 날아갑니다.");
	}
}

public class AnimalTest {

	public static void main(String[] args) {
		AnimalTest test = new AnimalTest();
		test.moveAnimal(new Human());
		test.moveAnimal(new Tiger());
		test.moveAnimal(new Eagle());
		
		// Animal animal = new Human(); 다형성을 이용해서 이 코드를 아래 메서드 하나로 세 가지 종에 대한 moveAnimal 메서드를 출력할 수 있다.
		// 본래라면 세 가지 종에 대한 세 가지 클래스의 인스턴스를 따로 생성해주고 각 인스턴스에서 마다 별도의 메서드를 호출해줘야 하는데,
		// 다형성을 이용해서 하나의 메서드로 각각의 메서드 실행이 가능해진다.
	}

	public void moveAnimal(Animal animal) { // 매개변수의 자료형이 상위 클래스이다.
		animal.move(); // 재정의된 메서드가 호출된다. (가상 메서드의 원리에 따라 위에서 하위 클래스의 생성자가 상위 클래스인 Animal 타입에
		// 할당 되더라도 인스턴스의 메서드를 호출하게 된다.)
		
		// 다형성 활용하기
		// 일반 고객과 VIP 고객의 중간 등급의 고객을 생성.
		// 5명의 고객을 ArrayList에 생성하여 저장한 다음, 각 고객이 물건을 샀을 때의 가격과 보너스 포인트를 계산한다.
		
		// Animal 클래스로 업캐스팅 되었기 때문에 Human 클래스 만의 메서드인 readBook() 을 사용하지 못한다.
		// 따라서 이를 해결해주기 위해 아래와 같이 Human 타입의 변수에다 다운캐스팅을 해주어 readBook() 메서드를 사용할 수 있지만,
		// Tiger 클래스가 들어올 경우, 에러가 발생하게 된다. 따라서 인스턴스 타입을 체크해 줄 필요가 있다.
		// Human human = (Human)animal;
		// human.readBook();
		
		if (animal instanceof Human) { // animal이 Human 타입의 인스턴스인지를 체
			Human human = (Human)animal; // 만약 인스턴스 타입이 Human이라면 Human으로 다운 캐스팅 해준 다음, readBook() 메서드 호출.
			human.readBook();
		}
		else if (animal instanceof Tiger) {
			Tiger tiger = (Tiger)animal;
			tiger.hunting();
		}
		else if (animal instanceof Eagle) {
			Eagle eagle = (Eagle)animal;
			eagle.flying();
		}
		else {
			System.out.println("지원되지 않는 기능입니다.");
		}
	}
}
