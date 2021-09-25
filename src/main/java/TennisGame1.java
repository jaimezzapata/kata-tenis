public class TennisGame1 implements TennisGame {

    private int player1_Score = 0;
    private int player2_Score = 0;
    private String player1Name;
    private String player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            player1_Score += 1;
        else
            player2_Score += 1;
    }

    public String getScore() {
        String result="";
        if (player1_Score == player2_Score)
        {
            result= tieScore();
        }
        else if (player1_Score >=4 || player2_Score >=4)
        {
            result= closeVictoryOrWining();
        }else{
            result= sideAdvantage();

        }
        return result;

    }

    private String sideAdvantage() {
        String score= "";
        for (int i = 1; i<3; i++)
        {
            score = comparateAdbantage(score, i);
        }
        return score;
    }

    private String comparateAdbantage(String score, int i) {
        int tempScore;
        if (i ==1) {
            tempScore = player1_Score;
        }
        else {
            score +="-"; tempScore = player2_Score;
        }
        score = sideAdvantageCases(tempScore, score);
        return score;
    }

    private String sideAdvantageCases(int tempScore, String score) {
        switch(tempScore)
        {
            case 0:
                score +="Love";
                break;
            case 1:
                score +="Fifteen";
                break;
            case 2:
                score +="Thirty";
                break;
            case 3:
                score +="Forty";
                break;
        }
        return score;
    }

    private String closeVictoryOrWining() {
        String score;
        int minusResult = player1_Score - player2_Score;


        if (minusResult==1) {
            score = "Advantage player1";
        }
        else if (minusResult ==-1) {
            score = "Advantage player2";
        }
        else if (minusResult>=2) {
            score = "Win for player1";
        }
        else {
            score = "Win for player2";
        }
        return score;
    }

    private String tieScore() {
        switch (player1_Score)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            default:
                return "Deuce";
        }
    }
}