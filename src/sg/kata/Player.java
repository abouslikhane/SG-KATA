package sg.kata;

public class Player {

	private String name;
	private String currentGameScore;
	private Integer indexGameScore;

	public Player(String name) {
		this.name = name;
		currentGameScore = "0";
		indexGameScore = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCurrentGameScore() {
		return currentGameScore;
	}

	public void setCurrentGameScore(String currentGameScore) {
		this.currentGameScore = currentGameScore;
	}

	public Integer getIndexGameScore() {
		return indexGameScore;
	}

	public void setIndexGameScore(Integer indexGameScore) {
		this.indexGameScore = indexGameScore;
	}

}
