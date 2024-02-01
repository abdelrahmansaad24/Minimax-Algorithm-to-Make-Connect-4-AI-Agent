package com.example.demo1;

public class Heuristic {
    public static int eval(State st) {
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

        int value = 0;
        for (int i = 0; i < str.length(); i++) {
            //if(str.charAt(i) == '0') continue;
            int j = 0, count = 0;
            //calHorizontal
            if (i % 7 != 4 && i % 7 != 5 && i % 7 != 6) {
                count = 1;
                j = i;
                while (count < 4 && str.charAt(j) == str.charAt(j + 1)) {
                    count++;
                    j++;
                }
                value = calc(count, str, i, j, value, 1);
            }

            //calcVertical
            if (i <= 20) {

                count = 1;
                j = i;
                while (count < 4 && str.charAt(j) == str.charAt(j + 7)) {
                    count++;
                    j += 7;
                }
                value = calc(count, str, i, j, value, 7);
            }
            //calcDiagonalRight
            if (i % 7 < 4 && i < 18) {

                count = 1;
                j = i;
                while (count < 4 && str.charAt(j) == str.charAt(j + 8)) {
                    count++;
                    j += 8;
                }
                value = calc(count, str, i, j, value, 8);
            }
            //calcDiagonalLeft
            if (i % 7 >= 3 && i <= 20) {

                count = 1;
                j = i;
                while (count < 4 && str.charAt(j) == str.charAt(j + 6)) {
                    count++;
                    j += 6;
                }
                value = calc(count, str, i, j, value, 6);
            }
        }
        return value;

    }

    public static int calc(int count, String str, int i, int j, int value, int counter) {

        if (count == 4){
            if (str.charAt(i) == '0')
                return value;
            else if (str.charAt(i) == '1')
                value -= 250;
            else
                value += 250;
        } else if (count == 3) {
            if (str.charAt(i) == '0'){
                if (str.charAt(j + counter) == '1'){
                    value -= 10;
                }else {
                    value += 10;
                }
                return value;
            }
            if (str.charAt(j + counter) == '0'){
                if (str.charAt(i) == '1')
                    value -= 100;
                else
                    value += 100;
            }
        } else if (count == 2) {

            if (str.charAt(j + counter) == '0' && str.charAt(j + counter * 2) == '0'){
                if (str.charAt(i) == '1')
                    value -= 50;
                else
                    value += 50;
            }

        } else if (count == 1) {
            if (str.charAt(j + counter) == '0' && str.charAt(j + counter * 2) == '0' && str.charAt(j + counter * 3) == '0'){
                if (str.charAt(i) == '1')
                    value -= 10;
                else
                    value += 10;
            }
        }

        return value;
    }
}

