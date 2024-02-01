package com.example.demo1;

public class Out {
    static int count = 0;
    public static void printState(State st, boolean inTree){
        if (inTree){
            count++;
            System.out.println("State Num: " + count);
        }
        //red => 1
        //yellow => 2
        //empty => 0
        long boardState = st.getBoardState();
        int remainBoard = st.getRemainBoardState();
        System.out.println();
        for (int i = 4; i < 11; i++){
            System.out.print(((remainBoard & (3 << (i * 2))) >> (i * 2)) + " ");
        }
        System.out.println();

        for (int i = 28; i < 31; i++){
            System.out.print(((boardState & (3L << (i * 2))) >> (i * 2)) + " ");
        }
        for (int i = 0; i < 4; i++){
            System.out.print(((remainBoard & (3 << (i * 2))) >> (i * 2)) + " ");
        }
        System.out.println();

        for (int i = 21; i < 28; i++){
            System.out.print(((boardState & (3L << (i * 2))) >> (i * 2)) + " ");
        }
        System.out.println();
        for (int i = 14; i < 21; i++){
            System.out.print(((boardState & (3L << (i * 2))) >> (i * 2)) + " ");
        }
        System.out.println();
        for (int i = 7; i < 14; i++){
            System.out.print(((boardState & (3L << (i * 2))) >> (i * 2)) + " ");
        }
        System.out.println();
        for (int i = 0; i < 7; i++){
            System.out.print(((boardState & (3L << (i * 2))) >> (i * 2))+ " ");
        }
        System.out.println();

        System.out.println();

    }
    static void printLevelOrder(State root , int h)
    {
        count = 0;
        System.out.println("\t\t\tTree");
        for (int i = 1; i <= h; i++) {
            System.out.println("\tLevel:" + i + "\n");
            printGivenLevel(root, i);
            System.out.print(System.lineSeparator());
        }
    }
    static void printGivenLevel(State root, int level)
    {
        if (root == null)
            return;
        if (level == 1) {
            System.out.print(root.getUtility());
        }
        else if (level > 1) {
            for (State state: root.getChildren()) {
                printGivenLevel(state, level - 1);

            }

        }
        System.out.print("\t");
    }
}

