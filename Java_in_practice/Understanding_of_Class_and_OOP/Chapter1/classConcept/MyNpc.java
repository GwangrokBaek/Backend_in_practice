/*
 * 실세계의 객체 : 우리가 표현할 수 있는 실제 세계의 모든 사물들
 * 이러한 객체는 눈에 보이고 만져지는 물리적인 객체 (개, 고양이, 소나타, K5 등) 와
 * 보이지 않고 만져지지 않는 개념적인 객체 (동물, 자동차 등) 로 나눌 수 있다.
 * 
 * 클래스 : 객체와 관련된 데이터와 처리동작을 한데 모은 설계도라 보면 된다.
 * 클래스를 기술하는 것을 '클래스를 정의한다' 라고 한다.
 * 
 * 클래스가 실체화된 것을 오브젝트 (객체) 라고 하며, 실체화하는 작업을 '오브젝트를 생성한다' 또는 '인스턴스화 한다' 등으로 말한다.
 */

package classConcept;

// 클래스 정의
class Npc {
	// 필드 (멤버 변수) - 데이터
	String name;
	int hp;
	
	// 메서드 - 동작
	void say() {
		System.out.println("안녕하세요.");
	}
}

public class MyNpc {
	public static void main(String[] args) {
		Npc saram1 = new Npc();
		
		saram1.name = "경비"; // dot 을 이용해 인스턴스의 멤버 변수 및 메서드에 접근이 가능하다.
		saram1.hp = 100;
		System.out.println(saram1.name + ":" + saram1.hp);
		
		saram1.say();
	}
}
