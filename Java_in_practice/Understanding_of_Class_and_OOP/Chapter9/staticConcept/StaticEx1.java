/*
 * static : 필드와 메서드에 붙이는 제한자이다.
 * 
 * static 을 붙인 멤버의 특징 :
 * 1. 프로그램 시작 전에 메모리에 로딩된다.
 * 2. 오브젝트를 생성하지 않고도 필드, 메서드 사용이 가능하다.
 * 3. 이때, 다른 오브젝트에서 참조하기 위해서는 오브젝트 이름이 아닌 클래스명을 지정한다.
 * 
 * 필드의 static :
 * 같은 클래스에서 생성된 오브젝트들은 static 을 붙인 필드의 값을 공유한다.
 * 
 * 메서드의 static :
 * 어떤 오브젝트에서도 같은 동작을 하는 메서드는 static 키워드를 붙여주는 것이 좋다.
 * - 한 번만 생성이 된다.
 * 
 * static 을 붙인 메서드는 다음과 같은 성질을 가진다.
 * - static 메서드는 오버라이딩 할 수 없다.
 * - static 메서드에서 동일한 오브젝트 내의 멤버를 이용하기 위해서는 멤버 (필드, 메서드) 에게 static 을 붙여야만 한다.
 */

package staticConcept;

class Cat {
	static int a = 5;
	int num = 3;
	
	void print(int num3) {
		System.out.println("a:"+a);
		num = num3;
		System.out.println("num:"+num);
	}
}

public class StaticEx1 {

	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 2;
		System.out.println(num1 + ", " + num2);
		
		Cat cat1 = new Cat();
		cat1.num = 1;
		cat1.a = 10;
		cat1.print(20);
		System.out.println(cat1.num);
		System.out.println(cat1.a);
		
		Cat cat2 = new Cat();
		cat2.num = 2;
		cat2.a = 11;
		cat2.print(20);
		System.out.println(cat2.num);
		System.out.println(cat2.a); // a 는 static 변수이므로 클래스에서 해당 변수를 공유한다.
		System.out.println(cat1.a);
	}

}
