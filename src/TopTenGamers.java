import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.LinkedList;

public class TopTenGamers extends JFrame {
    private LinkedList<Player> players;
    private JButton printButton; // Button for printing the list
    private JTextArea consoleTextArea; // JTextArea to display the print statements

    public TopTenGamers() {
        super("Top Ten Gamers");

        // Initialize an empty list of players.
        players = new LinkedList<>();

        // Create GUI components
        JPanel panel = new JPanel();
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(10);
        JLabel scoreLabel = new JLabel("Score:");
        JTextField scoreField = new JTextField(5);
        JButton insertButton = new JButton("Insert");
        consoleTextArea = new JTextArea(10, 10);
        consoleTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(consoleTextArea);
        printButton = new JButton("Print"); // Initialize the print button

        // Set layout and add components to the panel
        panel.setLayout(new FlowLayout());
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(scoreLabel);
        panel.add(scoreField);
        panel.add(insertButton);
        panel.add(scrollPane); // Add the JTextArea within a JScrollPane
        panel.add(printButton); // Add the print button to the panel

        // Add action listeners to the buttons
        insertButton.addActionListener(e -> {
            // Get the name and score from the text fields
            String name = nameField.getText();
            int score = Integer.parseInt(scoreField.getText());

            // Call the insert method with the provided name and score
            insert(name, score);

            // Clear the text fields after inserting a player
            nameField.setText("");
            scoreField.setText("");
        });

        printButton.addActionListener(e -> {
            // Call the printTopTen method to print the list of players
            printTopTen();
        });
        // Add the panel to the frame
        add(panel);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setVisible(true);
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
        if (players.isEmpty()) {
            consoleTextArea.append("No players found.\n");
            System.out.println("No players found");
        } else {
            consoleTextArea.append("Top Ten Gamers:\n");
            System.out.print("Top Ten Gamers:\n");
            int position = 1;
            for (Player player : players) {
                consoleTextArea.append(position + ". " + player.getName() + " " + player.getScore() + "\n");
                System.out.println(position + ". " + player.getName() + " " + player.getScore() + "\n");

                position++;
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of the TopTenGamersGUI class
        javax.swing.SwingUtilities.invokeLater(() -> new TopTenGamers());
    }
}
