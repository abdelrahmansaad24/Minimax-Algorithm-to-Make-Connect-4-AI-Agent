package com.example.demo1;

import javafx.util.Pair;

import java.util.ArrayList;


import javafx.util.Pair;

import java.util.ArrayList;

public class AlphaBeta {
    public static State decision(State state, int depth) {
        Pair<State, Integer> max = maximize(state, -500000000, 500000000, depth);
        state.setUtility(max.getValue());
        Out.printLevelOrder(state, depth + 1);
        return max.getKey();
    }

    public static Pair<State, Integer> maximize(State state, int alpha, int beta, int depth) {

        if (depth == 0 || isTerminal(state)) {
            int eval = Heuristic.eval(state);
            return new Pair<>(null, eval);
        }

        Pair<State, Integer> pair = new Pair<>(null, -500000000);

        Actions.setChildren(state, true);

        ArrayList<State> children = state.getChildren();
        for (State child : children) {
            Pair<State, Integer> min = minimize(child, alpha, beta, depth - 1);
            if (pair.getValue() >= beta) {
                break;
            }
            if (min.getValue() > pair.getValue()) {
                pair = new Pair<>(child, min.getValue());
                child.setUtility(min.getValue());
            }
            alpha = Math.max(alpha, pair.getValue());
            child.setUtility(min.getValue());
            child.setExplored(true);
        }
        return pair;

    }

    public static Pair<State, Integer> minimize(State state, int alpha, int beta, int depth) {

        if (depth == 0 || isTerminal(state)) {
            int eval = Heuristic.eval(state);
            return new Pair<>(null, eval);
        }

        //<minChild, minUtility>
        Pair<State, Integer> pair = new Pair<>(null, 500000000);

        Actions.setChildren(state, false);
        ArrayList<State> children = state.getChildren();
        for (State child : children) {

            //< _ , utility>
            Pair<State, Integer> max = maximize(child, alpha, beta, depth - 1);
            if (pair.getValue() <= alpha) {
                break;
            }
            if (max.getValue() < pair.getValue()) {
                pair = new Pair<>(child, max.getValue());
            }
            beta = Math.max(beta, pair.getValue());
            child.setUtility(max.getValue());
            child.setExplored(true);
        }
        return pair;
    }

    public static boolean isTerminal(State state) {
        return state.getLimit().equals("6666666");
    }
}
