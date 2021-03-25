/*
 * 프로그래밍 방식
 * - 절차지향 프로그래밍 : C
 * - 객체지향 프로그래밍 : Java, C++, C#, Python
 * 
 * 프로그래밍 방식 비교
 * 절차지향과 객체지향은 서로 반대되는 개념이 아니다.
 * 
 * 절차지향 프로그래밍 : 절차지향 프로그래밍은 순차적인 처리가 중요시 되며 프로그램 전체가 유기적으로 연결되도록 만드는 프로그래밍 기법이다.
 * 이들은 서로 분리되면 안되고 함수 호출 순서가 틀려서도 안되며 하나가 고장나면 전체기능이 마비된다.
 * 절차지향은 데이터를 중심으로 함수를 구성한다. 함수의 호출 순서가 바뀌면 데이터의 전달과 값이 변할 수 있다.
 * 
 * int makeEngine(int n) { return 1; }
 * int makeBody(int n) { return 1; }
 * int makeWheel(int n) { return 1; }
 * 
 * int main(void) {
 *     int n0 = 1;
 *     
 *     int n1 = makeEngine(n0);
 *     if (n1 == 0) return;
 *     
 *     int n2 = makeBody(n1);
 *     if (n2 == 0) return;
 *     
 *     int n3 = makeWheel(n2);
 *     if (n3 == 0) return;
 * }
 * 
 * 객체지향 프로그래밍 : 객체지향 프로그래밍은 개발하려는 것을 기능별로 묶어 모듈화를 하고, 모듈을 재활용하는 프로그래밍 방식이다.
 * 제작에 있어서 순서적이지 않아도 되며, 이들은 각각 따로 독립적으로 개발되어 나중에 한곳에 모여 자신의 기능만 제대로 발휘하면 된다.
 * 부품들이 결합되어 움직이다 어느 하나가 고장이 나면 고장난 부품만 고쳐주면 되고, 다른 부품들은 영향을 받지 않는다.
 * 필요하면 부품을 다른 것으로 교체할 수 있다.
 */

package programming;

class Engine {
	void makeEngine() {}
}

class Body {
	void makeBody() {}
}

class Wheel {
	void makeWheel() {}
}

class Car {
	Car(Engine a, Body b, Wheel c) {}
}

public class Oop {

	public static void main(String[] args) {
		Engine module1 = new Engine();
		Body module2 = new Body();
		Wheel module3 = new Wheel();
		
		Car myCar = new Car(module1, module2, module3);
	}

}
