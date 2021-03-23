package gamelevel;

public class Player {
	private PlayerLevel level; // 템플릿 메서드를 사용하지 않으면, BeginnerLevel, AdvancedLevel, SuperLevel 각각에
	// 대해서 모두 따로 level_1, level_2, level_3 이런 식으로 정의해주고, 메서드도 if 문을 통해 조건 검사를 해주어야 하는데,
	// 추상 클래스인 상위 클래스에 대한 변수를 선언하여 템플릿 메서드를 활용함으로써 훨씬 코드를 간단하게 작성할 수 있다.
	
	public Player() {
		level = new BeginnerLevel();
		level.showLevelMessage();
	}

	public PlayerLevel getLevel() {
		return level;
	}

	public void upgradeLevel(PlayerLevel level) {
		this.level = level;
		level.showLevelMessage();
	}
	
	public void play(int count) {
		level.go(count);
	}
}
