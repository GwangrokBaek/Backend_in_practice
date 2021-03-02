package reference;

public class Subject {
	String subjectName;
	int score;
	
	public Subject(String name) {
		subjectName = name;
	}
	
	public void setSubjectName(String name) {
		subjectName = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) { // 이클립스에서는 get, set 메소드를 자동으로 만들어주는 기능이 있다.
		// 오른쪽 클릭 후 Source 에서 generate getters and setters 를 클릭해주면 된다.
		this.score = score;
	}

	public String getSubjectName() {
		return subjectName;
	}
}
