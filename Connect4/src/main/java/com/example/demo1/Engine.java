package com.example.demo1;

public class Engine {
    protected State currentState;
    public Engine(){
        this.currentState = new State();
    }
    public void compTurn(int depth) {
        Actions.setLimit(currentState);
        if (MinMax.isTerminal(currentState)) {
            Score.calcScore(currentState);
            return;
        }
        State oldState = currentState;
        currentState = MinMax.decision(currentState, depth);
        System.out.println("Computer Turn");
        System.out.println("Utility: " + currentState.getUtility());
        Out.printState(currentState, false);
    }
    public void playerTurn(int depth, int column) {
        Actions.setLimit(currentState);
        if (MinMax.isTerminal(currentState)) {
            Score.calcScore(currentState);
            return;
        }
        System.out.println("Human Turn");
        int col = column;
        if (col >= 0 && col < 7 && currentState.getLimit().charAt(col) != '6') {
            switch (col) {
                case 0:
                    currentState = Actions.setFirstCol(currentState, false, false);
                    break;
                case 1:
                    currentState = Actions.setSecondCol(currentState, false, false);
                    break;
                case 2:
                    currentState = Actions.setThirdCol(currentState, false, false);
                    break;
                case 3:
                    currentState = Actions.setForthCol(currentState, false, false);
                    break;
                case 4:
                    currentState = Actions.setFifthCol(currentState, false, false);
                    break;
                case 5:
                    currentState = Actions.setSexCol(currentState, false, false);
                    break;
                case 6:
                    currentState = Actions.setSevenCol(currentState, false, false);
            }
            assert currentState != null;
            Out.printState(currentState, false);
            compTurn(depth);
        } else {
            System.out.println("Invalid play");
        }


    }
    public void compTurnAlphaBeta( int depth) {
        Actions.setLimit(currentState);
        if (AlphaBeta.isTerminal(currentState)) {
            Score.calcScore(currentState);
            return;
        }
        State oldState = currentState;
        currentState = AlphaBeta.decision(currentState, depth);
        System.out.println("Computer turn");
        System.out.println("Utility: " + currentState.getUtility());
        Out.printState(currentState, false);
    }
    public void playerTurnAlphaBeta( int depth, int column) {
        Actions.setLimit(currentState);
        if (AlphaBeta.isTerminal(currentState)) {
            Score.calcScore(currentState);
            return;
        }
        System.out.println("Human Turn");
        int col = column;
        if (col >= 0 && col < 7 && currentState.getLimit().charAt(col) != '6') {
            switch (col) {
                case 0:
                    currentState = Actions.setFirstCol(currentState, false, false);
                    break;
                case 1:
                    currentState = Actions.setSecondCol(currentState, false, false);
                    break;
                case 2:
                    currentState = Actions.setThirdCol(currentState, false, false);
                    break;
                case 3:
                    currentState = Actions.setForthCol(currentState, false, false);
                    break;
                case 4:
                    currentState = Actions.setFifthCol(currentState, false, false);
                    break;
                case 5:
                    currentState = Actions.setSexCol(currentState, false, false);
                    break;
                case 6:
                    currentState = Actions.setSevenCol(currentState, false, false);
            }
            assert currentState != null;
            Out.printState(currentState, false);
            compTurnAlphaBeta(depth);
        } else {
            System.out.println("Invalid play");
        }
    }
    public boolean isTerminal(State state) {
        return state.getLimit().equals("6666666");
    }
}
