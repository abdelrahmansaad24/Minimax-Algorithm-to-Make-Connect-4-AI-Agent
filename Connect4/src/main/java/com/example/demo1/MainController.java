package com.example.demo1;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

public class MainController {
    private final int[][] board = new int[6][7];
    private final int[][] drawn = new int[6][7];
    @FXML
    public int depth = 5;
    public Engine engine = new Engine();
    @FXML
    public boolean alphaBeta = false;
    @FXML
    public GridPane grid;

    public MainController(int depth, MainApplication.Method method) {
        if(method.equals(MainApplication.Method.AlphaBeta)){
            alphaBeta = true;
        }
        else if(method.equals(MainApplication.Method.Normal)) {
            alphaBeta = false;
        }
        this.depth = depth;
    }

    @FXML
    public void onClick(MouseEvent event) {
        double x = event.getX();
        int column = (int) x / 100;
        if (alphaBeta) {
            engine.playerTurnAlphaBeta(depth, column);
        } else {
            engine.playerTurn(depth, column);
        }
        updateBoard(engine.currentState, board);
        drawBoard(board);
        if(engine.isTerminal(engine.currentState)){
            Alert score = new Alert(Alert.AlertType.INFORMATION);
            score.setTitle("Score");
            score.setHeaderText("Game Over!");
            Score.calcScore(engine.currentState);
            score.setContentText("Computer: " + Score.scoreComp + "\n" + "Human: " + Score.scoreHum);
            score.show();
        }
    }

    private void drawBoard(int[][] board) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j]!=0){
                    if(drawn[i][j] != -1){
                        if(board[i][j]==1){
                            ImageView red = new ImageView(getClass().getResource("redCircle.png").toExternalForm());
                            red.setFitHeight(90);
                            red.setFitWidth(90);
                            red.setX(5.0);
                            red.setY(5.0);
                            grid.add(red, j, i);
                        }
                        else{
                            ImageView yellow = new ImageView(getClass().getResource("yellowCircle.png").toExternalForm());
                            yellow.setFitHeight(90);
                            yellow.setFitWidth(90);
                            yellow.setX(100.0);
                            yellow.setY(100.0);
                            grid.add(yellow, j, i);
                        }
                        drawn[i][j] = -1;
                    }
                }
            }
        }
    }

    private void updateBoard(State currentState, int[][] board) {
        long boardState = currentState.getBoardState();
        int remainBoard = currentState.getRemainBoardState();

        for (int i = 4; i < 11; i++) {
            board[0][i - 4] = ((remainBoard & (3 << (i * 2))) >> (i * 2));
        }
        for (int i = 28; i < 31; i++) {
            board[1][i - 28] = (int) ((boardState & (3L << (i * 2))) >> (i * 2));
        }
        for (int i = 0; i < 4; i++) {
            board[1][i+3] = ((remainBoard & (3 << (i * 2))) >> (i * 2));
        }

        for (int i = 21; i < 28; i++) {
            board[2][i - 21] = (int) ((boardState & (3L << (i * 2))) >> (i * 2));
        }
        for (int i = 14; i < 21; i++) {
            board[3][i - 14] = (int) ((boardState & (3L << (i * 2))) >> (i * 2));
        }
        for (int i = 7; i < 14; i++) {
            board[4][i - 7] = (int) ((boardState & (3L << (i * 2))) >> (i * 2));
        }
        for (int i = 0; i < 7; i++) {
            board[5][i] = (int) ((boardState & (3L << (i * 2))) >> (i * 2));
        }
    }
}