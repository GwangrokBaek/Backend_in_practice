// Set 인터페이스
// Collection 하위의 인터페이스
// 중복을 허용하지 않는다.
// 아이디, 주민번호, 사번 등 유일한 값이나 객체를 관리할 때 사용한다.
// List는 순서기반의 인터페이스이지만, Set은 순서가 없다.
// 저장된 순서와 출력순서는 다를 수 있다.
// get(i) 메서드가 제공되지 않는다.

package hashSetTest;

import java.util.HashSet;

public class HashSetTest {
	public static void main(String[] args) {
		HashSet<String> set = new HashSet<String>();
		
		boolean b1 = set.add("aaa");
		System.out.println(b1);
		set.add("bbb");
		set.add("ccc");
		
		System.out.println(set);
		
		boolean b2 = set.add("aaa"); // 이때 Set 인터페이스의 add() 메서드는 boolean 타입을 리턴하는데
		// 이미 "aaa" 라는 데이터는 HashSet 안에 있기에 false를 반환한다. 즉, 데이터가 들어가지 않는다. 왜냐하면 Set 인터페이스는 중복을 허용하지 않기 때문에.
		System.out.println(b2);
		System.out.println(set);
	}
}
