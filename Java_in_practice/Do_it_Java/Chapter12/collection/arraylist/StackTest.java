// Stack 과 Queue
// Stack 과 Queue 의 기능이 구현된 클래스가 있지만 ArrayList나 LinkedList를 활용하여서 사용할 수도 있다.
// Stack : Last In First Out (LIFO)
// 맨 마지막에 추가된 요소가 먼저 꺼내지는 자료구조이다.
// 게임의 무르기 기능, 최근 자료 추출 등에서 사용할 수 있다.

package collection.arraylist;

import java.util.ArrayList;

class MyStack {
	private ArrayList<String> arrayStack = new ArrayList<String>();
	
	public void push(String data) {
		arrayStack.add(data);
	}
	
	public String pop() {
		
		int len = arrayStack.size();
		if (len == 0) { // 언더플로우 예방.
			System.out.println("스택이 비었습니다.");
			return null;
		}
		
		return arrayStack.remove(len - 1);
	}
	
	public String peek() { // peek 은 pop 과는 달리 값을 꺼내지 않고 값을 출력만 한다.

		int len = arrayStack.size();
		if (len == 0) { // 언더플로우 예방.
			System.out.println("스택이 비었습니다.");
			return null;
		}
		
		return arrayStack.get(len - 1); // pop이 아닌 peek이기 때문에 remove가 아닌 get을 사용. get은 remove와 달리 값을 삭제하지 않는다.
	}
}

public class StackTest {

	public static void main(String[] args) {
		MyStack stack = new MyStack();
		
		stack.push("a");
		stack.push("b");
		stack.push("c");

		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		System.out.println(stack.pop());
	}

}
