package com.example.demo1;


public class Score {
    public static int scoreComp = 0;
    public static int scoreHum = 0;
    public static void calcScore(State st) {
        long boardState = st.getBoardState();
        int remainBoard = st.getRemainBoardState();


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 31; i++) {
            sb.append((boardState & (3L << (i * 2))) >> (i * 2));
        }
        for (int i = 0; i < 11; i++) {
            sb.append((remainBoard & (3 << (i * 2))) >> (i * 2));
        }

        String str = sb.toString();
        for (int i = 0; i < str.length(); i++) {
            int j = 0, count = 0;
            //calHorizontal
            if (str.charAt(j) != '0' && i % 7 != 4 && i % 7 != 5 && i % 7 != 6) {
                count = 1;
                j = i;
                while (count < 4 && str.charAt(j) == str.charAt(j + 1)) {
                    count++;
                    j++;
                }
                if (count == 4) {
                    if (str.charAt(i) == '1')
                        scoreHum++;
                    else
                        scoreComp++;
                }
            }
            //calcVertical
            if (str.charAt(j) != '0' && i <= 20) {
                count = 1;
                j = i;
                while (count < 4 && str.charAt(j) == str.charAt(j + 7)) {
                    count++;
                    j += 7;
                }
                if (count == 4) {
                    if (str.charAt(i) == '1')
                        scoreHum++;
                    else
                        scoreComp++;
                }

            }
            //calcDiagonalRight
            if (str.charAt(j) != '0' && i % 7 < 4 && i < 18) {
                count = 1;
                j = i;
                while (count < 4 && str.charAt(j) == str.charAt(j + 8)) {
                    count++;
                    j += 8;
                }
                if (count == 4) {
                    if (str.charAt(i) == '1')
                        scoreHum++;
                    else
                        scoreComp++;
                }
            }
            //calcDiagonalLeft
            if (str.charAt(j) != '0' && i % 7 >= 3 && i <= 20) {
                count = 1;
                j = i;
                while (count < 4 && str.charAt(j) == str.charAt(j + 6)) {
                    count++;
                    j += 6;
                }
                if (count == 4) {
                    if (str.charAt(i) == '1')
                        scoreHum++;
                    else
                        scoreComp++;
                }
            }
        }
        System.out.println("Score Computer: " + scoreComp);
        System.out.println("Score Human: " + scoreHum);
    }
}

