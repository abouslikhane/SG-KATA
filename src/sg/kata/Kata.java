package sg.kata;

public class Kata {

	public static void main(String[] args) {
		Player nadal = new Player("Nadal");
		Player Djoko = new Player("Djokovic");
		Match finale = new Match(nadal, Djoko);
		finale.startMatch();

	}

}
