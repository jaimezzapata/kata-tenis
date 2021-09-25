public class TennisGame2 implements TennisGame
{
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        score = equalPoints();
        score = advantagePlayer1(score);
        score = advantagePlayer2(score);
        score = midGamePlayer1(score);
        score = midGamePlayer2(score);
        score = p1Lead(score);
        score = p2Lead(score);
        score = p1Winning(score);
        score = p2Winning(score);
        return score;
    }
}