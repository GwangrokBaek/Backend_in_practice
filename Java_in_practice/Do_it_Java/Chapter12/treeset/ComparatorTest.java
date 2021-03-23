package treeset;

import java.util.Comparator;
import java.util.TreeSet;

class MyCompare implements Comparator<String> {

	@Override
	public int compare(String str1, String str2) {
		return str1.compareTo(str2) * (-1);
	}
	
}

public class ComparatorTest {

	public static void main(String[] args) {
		TreeSet<String> tree = new TreeSet<String>(new MyCompare());
		
		tree.add("aaa");
		tree.add("ccc");
		tree.add("bbb");
		
		System.out.println(tree); // MyCompare 클래스의 디폴트 생성자를 TreeSet 클래스의 생성자에 인자로 넣기 전에는
		// 기존에 정의된 비교 방법을 (String에서 정의된 메서드의 오름차순 정렬 방법) 사용하지만, Compare 클래스의 디폴트 생성자를 넣은 후에는
		// MyCompare에서 새로 정의한 비교 방법을 (compare() 메서드의 내림차순 정렬 방법) 사용한다.
	}

}
