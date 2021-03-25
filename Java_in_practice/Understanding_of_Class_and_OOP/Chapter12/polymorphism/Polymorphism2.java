/*
 * 마이크로소프트사 : 윈도우 10에서 사용될 프린터는 다음의 규격을 준수해야 한다. Printable 을 구현해야 한다.
 * 아래아한글, MS Word : 인쇄는 Printable 의 print 만 호출하면 된다.
 * 삼성, 엡손 : 프린터는 Printable 인터페이스 규격에 맞춰 만들면 된다.
 * 
 * 앞서 예제 1 은 추상 클래스를 사용, 아래 예제 2 는 인터페이스를 사용.
 * 
 * 이때, 추상 클래스는 상속 관계에서 계층 구조 표현이 필요할 경우 사용하며, 인터페이스는 계층 구조는 중요하지 않고 기능 구현을 해줄 경우 사용한다.
 * 일일이 각각의 하위 클래스를 사용하는 것이 아니라, 상위 클래스 타입으로 간편하게 호출할 수 있으므로 디자인 패턴에서 많이 사용된다.
 */

package polymorphism;

interface Printable {
	void print(String doc);
}

class PrnDrvSamsung implements Printable {
	public void print(String doc) {
		System.out.println(doc + "\nFrom Samsung : Black-White Ver");
	}
}

class PrnDrvEpson implements Printable {
	public void print(String doc) {
		System.out.println(doc + "\nFrom Epson : Black-White Ver");
	}
}

public class Polymorphism2 {

	public static void main(String[] args) {
		String doc = "프린터로 출력을 합니다.";
		
		Printable prn1 = new PrnDrvSamsung();
		prn1.print(doc);
		
		Printable prn2 = new PrnDrvEpson();
		prn2.print(doc);
	}
}
