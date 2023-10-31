class Player {
    private String name;
    private int score;

    public Player(String name, int score) {
        // Player constructor to set the name and score for a player.
        this.name = name;
        this.score = score;
    }

    public String getName() {
        // Getter method for retrieving the player's name.
        return name;
    }

    public int getScore() {
        // Getter method for retrieving the player's score.
        return score;
    }
}
