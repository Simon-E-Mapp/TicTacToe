public class Main {

    public static void main(String[] args) {
        Player[] players = Player.createPlayers();
        Player p1 = players[0];
        Player p2 = players[1];

        Game game = new Game(p1, p2);
        game.playGame();
    }
}
