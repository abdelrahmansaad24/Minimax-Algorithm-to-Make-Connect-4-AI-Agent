package com.example.demo1;

import java.util.ArrayList;

public class State {

    private long boardState;
    private int remainBoardState;

    private int utility;
    private String limit;
    private int depth;
    private boolean explored = false;

    ArrayList<State> children = new ArrayList<>();

    public long getBoardState() {
        return boardState;
    }

    public int getRemainBoardState() {
        return remainBoardState;
    }

    public ArrayList<State> getChildren() {
        return children;
    }

    public void setBoardState(long boardState, int remainBoardState) {
        this.boardState = boardState;
        this.remainBoardState = remainBoardState;

    }


    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public int getUtility() {
        return utility;
    }

    public void setUtility(int utility) {
        this.utility = utility;
    }

    public boolean isExplored() {
        return explored;
    }

    public void setExplored(boolean explored) {
        this.explored = explored;
    }
}
