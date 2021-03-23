// Queue : First In First Out (FIFO)
// 먼저 저장된 자료가 먼저 꺼내지는 선착순, 대기열 구조

package collection.arraylist;

import java.util.ArrayList;

class MyQueue {
	private ArrayList<String> arrayQueue = new ArrayList<String>();
	
	public void enQueue(String data) {
		arrayQueue.add(data);
	}
	
	public String deQueue() {
		int len = arrayQueue.size();
		
		if(len == 0) {
			System.out.println("큐가 비었습니다.");
			return null;
		}
		
		return arrayQueue.remove(0);
	}
}

public class QueueTest {

	public static void main(String[] args) {
		MyQueue queue = new MyQueue();
		
		queue.enQueue("a");
		queue.enQueue("b");
		queue.enQueue("c");
		
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		System.out.println(queue.deQueue());
		
		System.out.println(queue.deQueue());
	}

}
