// 클라이언트 코드

package scheduler;

import java.io.IOException;
import java.sql.Connection;

public class SchedulerTest {
	public static void main(String[] args) throws IOException {
		
		// Connection
		// java에서 DB와 연결을 할때 Connection 인터페이스를 사용한다.
		// JDBC 는 java를 DB와 연결하기 위해 사용되는 명세 (스펙) 로서 여기에는 Connection이나 Statement와 같은 인터페이스에 대한
		// 내용이 기재된다.
		// 이때 이러한 인터페이스는 구현 코드가 없으므로 이를 구현해서 사용해주어야 하는데, 이에 대한 구현은 Oracle이나 MS SQL과 같은 곳에서
		// 명세로서 존재하는 인터페이스들인 Connection이나 Statement를 구현하여 이를 사용자에게 .jar 파일로 제공한다.
		// 사용자는 이러한 jar 파일을 이용해서 코딩을 하는데, 이때 jar 파일을 직접 열어서 분석하는 것이 아니라 명세로서 존재하는
		// 인터페이스의 역할 및 사용 방법 (스펙) 을 기반으로 업체에서 제공하는 jar 파일을 사용하여 코드를 작성한다.
		
		// 왜 인터페이스를 사용하는가?
		// UserInfoWeb (클라이언트 코드) 은 IUserInfoDao (인터페이스) 에 정의된 메소드 명세만 보고 Dao를 사용할 수 있고,
		// Dao 클래스들 (oracleDao, mysqlDao, mssqlDao 등) 은 IUserInfoDao에 정의된 메소드를 구현할 책임이 있다.
		
		System.out.println("전화 상담 배분방식을 선택하세요. R, L, P");
		
		int ch = System.in.read(); // 출력과 달리 입력의 경우 예외처리를 해줘야한다. 이때 예외처리 말고 오류 발생시
		// IOException을 throw 하는 것으로 대체할 수도 있다.
		Scheduler scheduler = null;
		
		if (ch == 'R' || ch == 'r') {
			scheduler = new RoundRobin();
		}
		else if (ch == 'L' || ch == 'l') {
			scheduler = new LeastJob();
		}
		else if (ch == 'P' || ch == 'p') {
			scheduler = new PriorityAllocation();
		}
		else {
			System.out.println("지원하지 않는 기능입니다.");
			return;
		}
		
		scheduler.getNextCall(); // 각 구현된 인터페이스의 구현 방식을 모르더라도 각 인터페이스들이 어떤 역할을 하는지는 알고 있으므로
		// 해당 구현된 인터페이스를 할당해주고 이들의 메서드를 호출해주는 것으로 클라이언트 코드를 작성하는 것으로 인터페이스의 다형성을
		// 구현할 수 있다.
		scheduler.sendCallToAgent();
	}
}
