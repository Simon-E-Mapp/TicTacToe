import java.util.Scanner;

public class Player {
    String name;
    char marker;

    public Player(String name, char marker) {
        this.name = name;
        this.marker = marker;
    }

    public static Player[] createPlayers() {
        Scanner scanner = new Scanner(System.in);

        // Player 1
        System.out.println("Player 1! Name please! ");
        String name1 = scanner.nextLine();
        char marker1 = ' ';
        while (marker1 != 'X' && marker1 != 'O') {
            System.out.println("Player 1! Choose your marker! ( X / O )");
            marker1 = scanner.next().toUpperCase().charAt(0);
        }

        Player p1 = new Player(name1, marker1);

        // Player 2
        System.out.println("Player 2! Name please! ");
        scanner.nextLine();
        String name2 = scanner.nextLine();
        char marker2 = (marker1 == 'X') ? 'O' : 'X';

        Player p2 = new Player(name2, marker2);

        System.out.println(p1.name + ": " + p1.marker);
        System.out.println(p2.name + ": " + p2.marker);

        return new Player[]{p1, p2};
    }

    public String getName() {
        return this.name;
    }

    public char getMarker() {
        return this.marker;
    }

}
