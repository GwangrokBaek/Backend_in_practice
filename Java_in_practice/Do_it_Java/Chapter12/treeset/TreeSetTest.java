package treeset;

import java.util.TreeSet;

public class TreeSetTest {

	public static void main(String[] args) {
		TreeSet<String> tree = new TreeSet();
		
		tree.add("aaa");
		tree.add("ccc");
		tree.add("bbb");
		
		System.out.println(tree); // 문자열을 추가한 뒤, tree를 출력해보면 aaa - bbb - ccc 순으로 정렬되어서 출력되는 것을 확인할 수 있다.
		// 이는 String 클래스에서 Comparable에 대해 정의가 되어 있기 때문에 개체를 추가할때 정의한 조건에 따라 정렬이 수행되기 때문이다.
	}

}
