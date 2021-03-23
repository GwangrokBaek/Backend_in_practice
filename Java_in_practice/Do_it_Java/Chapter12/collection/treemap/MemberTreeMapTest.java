package collection.treemap;

import collection.Member;

public class MemberTreeMapTest {

	public static void main(String[] args) {
		MemberTreeMap memberTreeMap = new MemberTreeMap();
		
		Member memberLee = new Member(102, "이순신");
		Member memberKim = new Member(101, "김유신");
		Member memberShin = new Member(103, "신사임당");
		
		memberTreeMap.addMember(memberLee);
		memberTreeMap.addMember(memberKim);
		memberTreeMap.addMember(memberShin);
		
		memberTreeMap.showAllMember(); // 요소들이 memberId에 따라 정렬되어 출력된다. 이는 Integer 클래스에서 비교 메서드가 이미 정의되어 있기 때문.
		// 기본적으로 오름차순으로 정의되어 있는데, 다른 비교 방법을 사용하고 싶다면 Comparator 인터페이스를 구현하여 Member의 디폴트 생성자를 TreeMap() 생성자에
		// 인자로 넣어주면 된다.
	}

}
