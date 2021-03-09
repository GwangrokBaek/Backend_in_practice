// static 응용 : singleton 패턴
// 전 시스템에 단 하나의 인스턴스만이 존재하도록 구현하는 방식이다.
// C에서는 global 변수로 싱글턴 패턴을 사용할 수 있지만, 자바에는 global 변수가 없다. 따라서 static 변수를 사용.
// 다음으로 생성자가 없으면 public default 생성자가 자동으로 생성되어 외부에서 마음대로 생성할 수 있기에 생성자를 private으로
// 만들어준다.
// 외부에서 static으로 생성된 객체를 사용할 수 있도록 public으로 선언된 static 메서드를 제공해준다.

package singleton;

public class Company {
	
	private static Company instance = new Company(); // 전체 프로그램에서 유일하게 사용될 인스턴스. 아래에서 생성자를
	// private으로 정의하였기 때문에 외부에서 Company 클래스에 대한 인스턴스를 생성하지 못한다. 따라서 클래스 내부에서
	// Company 클래스에 대한 인스턴스를 생성해주고, 이때 외부에서 변경이 불가능하며 단 하나만 유지시킬 것이므로 private과 static을
	// 붙여준다.
	
	private Company() {} // 외부에서 Constructor를 호출하지 못하도록 생성자에 private을 붙여준다.
	
	public static Company getInstance() { // 클래스 내부에서 생성한 인스턴스가 private으로 정의되어 있으므로 
		// 이를 외부에서 사용하려면 인스턴스를 리턴하는 public 메서드를 정의해주어야 한다. 이때 메서드를 사용하려면 생성자를 통해
		// 인스턴스를 생성해줘야 하므로 외부에서 생성자 없이 사용할 수 있게 하기 위해 static을 붙여 static 메서드로 만들어준다.
		
		if (instance == null) { // 그럴 일은 없겠지만, 혹시나 인스턴스가 없는 경우에, 생성자를 통해 인스턴스 할당.
			instance = new Company();
		}
		
		return instance;
	}
}
