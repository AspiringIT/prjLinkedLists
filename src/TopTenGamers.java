import java.util.LinkedList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TopTenGamers {
    private LinkedList<Player> players;

    public TopTenGamers() {
        // Constructor initializes an empty list of players.
        players = new LinkedList<>();
    }

    public void insert(String name, int score) {
        // Create a new player with the provided name and score.
        Player newPlayer = new Player(name, score);

        if (players.isEmpty()) {
            // If the list is empty, add the new player.
            players.add(newPlayer);
        } else {
            int i = 0;
            // Find the correct position to insert the new player to maintain descending order.
            while (i < players.size() && score <= players.get(i).getScore()) {
                i++;
            }
            if (i < 10) {
                // Add the new player to the list and ensure the list size remains at most 10.
                players.add(i, newPlayer);
                if (players.size() > 10) {
                    players.removeLast(); // Remove the lowest-scoring player if the list size exceeds 10.
                }
            }
        }
    }

    public void printTopTen() {
        int position = 1;
        for (Player player : players) {
            // Print the top 10 players with their positions, names, and scores.
            System.out.println(position + ". " + player.getName() + " " + player.getScore());
            position++;
        }
    }

    public static void main(String[] args) {
        TopTenGamers topTenGamers = new TopTenGamers();
        topTenGamers.insert("Spike", 120);
        topTenGamers.insert("Whiz", 105);
        topTenGamers.insert("G-Man", 99);
        topTenGamers.insert("JediMaster", 95);
        topTenGamers.printTopTen();
    }
}

