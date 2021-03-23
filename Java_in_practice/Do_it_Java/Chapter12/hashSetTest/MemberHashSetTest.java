package hashSetTest;

import collection.Member;

public class MemberHashSetTest {

	public static void main(String[] args) {
		MemberHashSet memberHashSet = new MemberHashSet();
		
		Member memberLee = new Member(101, "이순신");
		Member memberKim = new Member(102, "김유신");
		Member memberShin = new Member(103, "신사임당");
		
		memberHashSet.addMember(memberLee);
		memberHashSet.addMember(memberKim);
		memberHashSet.addMember(memberShin);
		
		memberHashSet.showAll();
		
		Member memberLee2 = new Member(101, "이몽룡"); // 현재는 객체 정보 + 주소를 기반으로 equals를 체크하므로 Id가 같더라도 Set 구조에 추가된다.
		// 따라서 논리적 동등성을 체크할 수 있도록 Member 클래스에서 equals() 와 hashCode() 메서드를 재정의해주어야 한다.
		// String 클래스에서는 논리적 동등성을 체크하도록 equals() 와 hashCode() 메서드가 재정의되어 있으므로 HashSetTest 클래스에서 같은 문자열을 가진 멤버가
		// Set 인터페이스에 추가되지 않는다.
		
		memberHashSet.addMember(memberLee2);
		memberHashSet.showAll();
	}

}
