package com.self.dsa.dp;

/*

Whis and Beerus are playing a new game today. They form a tower of N coins and make a move in alternate turns. Beerus plays first. In one step, the player can remove either 1, X, or Y coins from the tower.
The person to make the last move wins the game. Can you find out who wins the game?
 */
public class CoinTower {

    public static String findWinner(int n, int x, int y) {

        int len = n + 1;
        String[] moves = new String[len];
        moves[0] = "Whis";
        moves[1] = "Beerus";

        moves[x] = "Beerus";
        moves[y] = "Beerus";

        for(int i = 2; i < len; i++) {

            String winnerN_1 = moves[i - 1];
            String winnerN_X = i > x ? moves[i - x] : "";
            String winnerN_Y = i > y ? moves[i - y] : "";

            boolean hasBeerusWon = winnerN_1.equals("Beerus") && winnerN_X.equals("Beerus") && winnerN_Y.equals("Beerus");
            if(hasBeerusWon)
                moves[i] = "Whis";
            else
                moves[i] = "Beerus";
        }
        return moves[n];
    }

}
