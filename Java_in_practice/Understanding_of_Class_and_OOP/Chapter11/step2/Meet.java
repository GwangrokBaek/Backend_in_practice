package step2;

interface Greet {
	void greet();
}

interface Bye extends Greet { // Greet 인터페이스를 상속.
	void bye();
}

class Morning implements Bye {

	@Override
	public void bye() {
		System.out.println("안녕히 계세요.");
	}

	@Override
	public void greet() {
		System.out.println("안녕하세요.");		
	}
	
}

public class Meet {

	public static void main(String[] args) {
		Morning morning = new Morning();
		morning.greet();
		morning.bye();
	}
}
