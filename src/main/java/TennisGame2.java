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

    private String p2Winning(String score) {
        if (P2point >= 4 && P1point >= 0 && (P2point - P1point) >= 2) {
            score = "Win for player2";
        }
        return score;
    }

    private String p1Winning(String score) {
        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for player1";
        }
        return score;
    }

    private String p2Lead(String score) {
        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage player2";
        }
        return score;
    }

    private String p1Lead(String score) {
        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage player1";
        }
        return score;
    }

    private String midGamePlayer2(String score) {
        if (P2point>P1point && P2point < 4)
        {
            switch (P2point){
                case 2:
                    P2res="Thirty";
                    break;
                case 3:
                    P2res="Forty";
                    break;
            }
            switch (P1point)
            {
                case 1:
                    P1res="Fifteen";
                    break;
                case 2:
                    P1res="Thirty";
                    break;
            }
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String midGamePlayer1(String score) {
        if (P1point>P2point && P1point < 4)
        {
            switch (P1point){
                case 2:
                    P1res="Thirty";
                    break;
                case 3:
                    P1res="Forty";
                    break;
            }
            switch (P2point)
            {
                case 1:
                    P2res="Fifteen";
                    break;
                case 2:
                    P2res="Thirty";
                    break;
            }

            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String advantagePlayer2(String score) {
        if (P2point > 0 && P1point==0)
        {
            switch (P2point){
                case 1:
                    P2res = "Fifteen";
                    break;
                case 2:
                    P2res = "Thirty";
                    break;
                case 3:
                    P2res = "Forty";
                    break;
            }

            P1res = "Love";
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String advantagePlayer1(String score) {
        if (P1point > 0 && P2point==0)
        {

            switch (P1point){
                case 1:
                    P1res = "Fifteen";
                    break;
                case 2:
                    P1res = "Thirty";
                    break;
                case 3:
                    P1res = "Forty";
                    break;
            }

            P2res = "Love";
            score = P1res + "-" + P2res;
        }
        return score;
    }

    private String equalPoints() {
        if (P1point == P2point)
        {
            switch (P1point){
                case 0:
                    return  "Love-All";
                case 1:
                    return "Fifteen-All";
                case 2:
                    return "Thirty-All";
                default:
                    return  "Deuce";
            }
        }
        return "";
    }

    public void SetP1Score(int number){

        for (int i = 0; i < number; i++)
        {
            P1Score();
        }

    }

    public void SetP2Score(int number){

        for (int i = 0; i < number; i++)
        {
            P2Score();
        }

    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == "player1")
            P1Score();
        else
            P2Score();
    }
}