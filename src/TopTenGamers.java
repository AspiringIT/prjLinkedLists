import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.LinkedList;

public class TopTenGamers extends JFrame {
    private LinkedList<Player> players;
    private JButton printButton; // Button for printing the list

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
        JLabel PrintedList = new JLabel("Print button will display in console");
        JTextArea JT = new JTextArea(10, 10);
        JT.append("This is a test");
        printButton = new JButton("Print"); // Initialize the print button

        // Set layout and add components to the panel
        panel.setLayout(new FlowLayout());
        panel.add(nameLabel);
        panel.add(nameField);
        panel.add(scoreLabel);
        panel.add(scoreField);
        panel.add(insertButton);
        panel.add(PrintedList);
        panel.add(JT);
        panel.add(printButton); // Add the print button to the panel

        // Add action listeners to the buttons
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the name and score from the text fields
                String name = nameField.getText();
                int score = Integer.parseInt(scoreField.getText());

                // Call the insert method with the provided name and score
                insert(name, score);

                // Clear the text fields after inserting a player
                nameField.setText("");
                scoreField.setText("");
            }
        });

        printButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the printTopTen method to print the list of players
                printTopTen();
            }
        });
        // Add the panel to the frame
        add(panel);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
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
            System.out.println("No players found.");
        } else {
            System.out.println("Top Ten Gamers:");
            int position = 1;
            for (Player player : players) {
                // Print the top 10 players with their positions, names, and scores.
                System.out.println(position + ". " + player.getName() + " " + player.getScore());
                position++;
            }
        }
    }

    public static void main(String[] args) {
        // Create an instance of the TopTenGamersGUI class
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new TopTenGamers();
            }
        });
    }
}
