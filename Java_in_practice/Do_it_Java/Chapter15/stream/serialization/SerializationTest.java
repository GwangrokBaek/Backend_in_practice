// 직렬화 (serialization)
// 인스턴스의 상태를 그대로 저장하거나 (serialization) 다시 복원하는 (deserialization) 방식이 있다.
// 즉, DataInputStream 이나 DataOutputStream 의 경우, 데이터를 그대로 저장하는 것이지만, 직렬화는 객체 즉, 인스턴스를
// 그대로 저장할때 사용하는 기법이다.
// 파일에 쓰거나 네트워크로 전송할때 주로 사용된다.
// ObjectInputStream 과 ObjectOutputStream 을 사용한다.
// 생성자									설명
// ObjectInputStream(inputStream in)	InputStream 을 생성자의 매개변수로 받아 ObjectInputStream 을 생성한다.
// ObjectOutputStream(OutputStream out) OutputStream 을 생성자의 매개변수로 받아 ObjectOutputStream 을 생성한다.

// 안드로이드에서 내부적으로 객체의 정보를 주고받거나, 네트워크에서 정보를 주고받을때 종종 사용된다.

package stream.serialization;

import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//Externalizable 인터페이스
//Serializable 과는 달리, 프로그래머가 자료를 읽고 쓰는 방식을 직접 구현한다.

class Person2 implements Externalizable {
	
	String name;
	String title;
	
	public Person2() {}
	public Person2(String name, String title) {
		this.name = name;
		this.title = title;
	}
	
	@Override // 이때 Externalizable 인터페이스는 아래 두 가지 메서드를 직접 구현해줘야 하는데, 이때 매개변수를 통해서 어떻게 동작시킬 것인지를
	// 구현할 수 있다. 이때 writeExternal() 메서드와 readExternal() 메서드 서로 자료를 읽고 쓰는 방식이 동일해야 한다.
	// (DataInputStream 과 DataOutputStream 에서 자료를 읽고 쓰는 방식이 동일해야하는 것과 같다.)
	public void writeExternal(ObjectOutput out) throws IOException { // writeObject 시 불리는 메서드
		out.write(null);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException { // readObject 시 불리는 메서드
		// TODO Auto-generated method stub
	}
}

// Serializable 인터페이스
// 직렬화는 인스턴스 내용이 외부로 유출되는 것이므로 프로그래머가 직렬화 의도를 표시해야한다.
// 구현코드가 없는 maker interface 이다.

class Person implements Serializable { // 직렬화를 하기 위해서는 Serializable 인터페이스를 구현해줘야 한다. 이때 Serializable 인터페이스는
	// 표시 인터페이스라고도 불린다. 이는 직렬화를 수행하겠다는 의도를 표시한다.
	// 이때 Serialization 은 객체의 정보를 저장하는 것인데, 객체의 정보가 많이 수정되는 경우에는 객체 버전 정보가 필요할 수도 있다.
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8979042624550852984L; // automatic 하게 버전 정보를 생성할 수도 있으며,
	// 추후에 필요시 버전 정보를 수정할 수도 있다.
	
	String name;
	transient String title; // transient 키워드는 직렬화를 수행할 때 해당 정보가 저장되지 않게끔 한다.
	// 이때 해당 정보를 복원 (deserialization) 할 경우에는 null 로 출력된다.
	// 또한 Socket 처럼 직렬화가 되지 않는 클래스가 있는데, 이러한 클래스들 앞에 transient 키워드를 붙여주면 된다.
	
	public Person() {}
	public Person(String name, String title) {
		this.name = name;
		this.title = title;
	}
	
	public String toString() {
		return name + "," + title;
	}
}

public class SerializationTest {

	public static void main(String[] args) throws ClassNotFoundException {
		
		Person personLee = new Person("Lee", "Manager");
		try(FileOutputStream fos = new FileOutputStream("serial.dat");
			ObjectOutputStream oos = new ObjectOutputStream(fos)) { 
			oos.writeObject(personLee); // personLee 객체에 대한 정보를 serial.dat 파일에 작성한다.
		} catch(IOException e) {
			System.out.println(e);
		}
		
		try(FileInputStream fis = new FileInputStream("serial.dat");
				ObjectInputStream ois = new ObjectInputStream(fis)) { 
				Object obj = ois.readObject(); // 이때 readObject() 메서드는 객체의 정보를 파일에서 가져올 수 있는데
			// Object 타입으로 반환한다. 따라서 이를 다운캐스팅하여 사용할 수 있다.
				
			if(obj instanceof Person) {
				Person p = (Person)obj;
				System.out.println(p); // 객체의 정보인 Lee, Manager 가 출력된다.
			}
		} catch(IOException e) {
				System.out.println(e);
		}
	}
}
