public class TennisGame3 implements TennisGame {

    private int scorePlayer2;
    private int scorePlayer1;
    private String player1Name;
    private String player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        if (scorePlayer1 < 4 && scorePlayer2 < 4 && scorePlayer1 + scorePlayer2 < 6) {
            return midGameScore();
        }
        return winnerOrLead();

    }

    private String winnerOrLead() {
        String score;
        if (scorePlayer1 == scorePlayer2)
            return "Deuce";
        score = whichIsGrater();
        return winnerOrLead(score);
    }

    private String winnerOrLead(String score) {
        return ((scorePlayer1 - scorePlayer2) * (scorePlayer1 - scorePlayer2) == 1) ? "Advantage " + score : "Win for " + score;
    }

    private String whichIsGrater(){
        String score;
        return scorePlayer1 > scorePlayer2 ? player1Name : player2Name;
    }

    private String midGameScore() {
        String score;
        String[] p = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        score = p[scorePlayer1];
        return (scorePlayer1 == scorePlayer2) ? score + "-All" : score + "-" + p[scorePlayer2];
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            this.scorePlayer1 += 1;
        else
            this.scorePlayer2 += 1;

    }

}