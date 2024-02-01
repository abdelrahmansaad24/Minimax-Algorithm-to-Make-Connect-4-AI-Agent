package com.example.demo1;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Iterator;

public class MinMax {

    public static Pair<State, Integer> maximize(State state, int depth){

        if (depth == 0 || isTerminal(state)){
            int eval = Heuristic.eval(state);
            return new Pair<>(null, eval);
        }

        Pair<State, Integer> pair = new Pair<>(null,-500000000);

        Actions.setChildren(state, true);

        ArrayList<State> children = state.getChildren();
        for (State child: children){
            Pair<State, Integer> min = minimize(child, depth - 1);
            if (min.getValue() > pair.getValue()){
                pair = new Pair<>(child, min.getValue());
            }
            child.setUtility(min.getValue());
            child.setExplored(true);
        }

        return pair;

    }

    public static Pair<State, Integer> minimize(State state, int depth){

        if (depth == 0 || isTerminal(state)){
            int eval = Heuristic.eval(state);
            return new Pair<>(null, eval);
        }

        //<minChild, minUtility>
        Pair<State, Integer> pair = new Pair<>(null, 500000000);

        Actions.setChildren(state, false);
        ArrayList<State> children = state.getChildren();
        for (State child: children){

            //< _ , utility>
            Pair<State, Integer> max =  maximize(child, depth - 1);

            if (max.getValue() < pair.getValue()){
                pair = new Pair<>(child, max.getValue());
            }
            child.setUtility(max.getValue());
            child.setExplored(true);
        }

        return pair;
    }
    public static State decision(State state, int depth){

        Pair<State, Integer> max = maximize(state, depth);
        state.setUtility(max.getValue());
        Out.printLevelOrder(state, depth + 1);
        return max.getKey();
    }

    public static boolean isTerminal(State state){
        return state.getLimit().equals("6666666");
    }


}
