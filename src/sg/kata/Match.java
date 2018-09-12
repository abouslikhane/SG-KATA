package sg.kata;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Match {

	List<String> scoresGames = Arrays.asList("0", "15", "30", "40");

	Player player1;
	Player player2;

	public Match(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public void startMatch() {

		System.out.println("Start game :" + player1.getName() + " VS " + player2.getName());

		printScore();
		while (player1.getCurrentGameScore() != "WIN" && player2.getCurrentGameScore() != "WIN") {
			while (Integer.valueOf(player1.getCurrentGameScore()) < 40
					&& Integer.valueOf(player2.getCurrentGameScore()) < 40) {
				Player playerScoring = randomScorer();
				scorePlayer(playerScoring);
			}

			// DEUCE
			if (player1.getCurrentGameScore() == player2.getCurrentGameScore()) {
				manageDEUCE();
			} else {
				Player playerScoring = randomScorer();
				if (Integer.valueOf(playerScoring.getCurrentGameScore()) == 40) {
					playerWinGame(playerScoring);
				} else {
					scorePlayer(playerScoring);
				}
			}
		}

	}

	private void playerWinGame(Player player) {
		player.setCurrentGameScore("WIN");
		System.out.println(player.getName() + " win the game");
	}

	private void manageDEUCE() {
		player1.setCurrentGameScore("DEUCE");
		player2.setCurrentGameScore("DEUCE");
		while (player1.getCurrentGameScore() != "WIN" && player2.getCurrentGameScore() != "WIN") {
			Player playerScoring = randomScorer();
			playerScoring.setCurrentGameScore("ADVANTAGE");
			Player playerScoring2 = randomScorer();
			if (playerScoring2.getCurrentGameScore().equals("ADVANTAGE")) {
				playerWinGame(playerScoring);
			} else {
				manageDEUCE();
			}

		}
	}

	private void scorePlayer(Player player) {
		player.setIndexGameScore(player.getIndexGameScore() + 1);
		player.setCurrentGameScore(this.scoresGames.get(player.getIndexGameScore()));
		printScore();
	}

	private Player randomScorer() {
		Random random = new Random();
		boolean randomBoolean = random.nextBoolean();

		if (randomBoolean) {
			return player1;
		} else {
			return player2;
		}
	}

	private void printScore() {
		while (Integer.valueOf(player1.getCurrentGameScore()) == 40
				&& Integer.valueOf(player2.getCurrentGameScore()) == 40) {
			player1.setCurrentGameScore("DEUCE");
			player2.setCurrentGameScore("DEUCE");
		}
		System.out.println(player1.getName() + "  : " + player1.getCurrentGameScore() + " -- " + player2.getName()
				+ "  : " + player2.getCurrentGameScore());
	}

}
