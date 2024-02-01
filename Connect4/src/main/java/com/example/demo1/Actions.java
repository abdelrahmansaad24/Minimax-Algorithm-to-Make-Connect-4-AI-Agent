package com.example.demo1;


public class Actions {

    //red for max(computer) => 01
    //yellow for min(human) => 10
    //empty => 00
    public static void setChildren(State state, boolean isMax) {
        setFirstCol(state, isMax, true);
        setSecondCol(state, isMax, true);
        setThirdCol(state, isMax, true);
        setForthCol(state, isMax, true);
        setFifthCol(state, isMax, true);
        setSexCol(state, isMax, true);
        setSevenCol(state, isMax, true);
    }

    public static State setFirstCol(State state, boolean isMax, boolean fromSetChildren) {
        //first row0..000000000000000000000000000000000..
        int row = Integer.parseInt(String.valueOf(state.getLimit().charAt(0)));
        int x, y, f;
        if (row < 6) {
            State st = new State();
            if (isMax) {
                x = row * 14 + 1;
                y = 9;
            } else {
                x = row * 14;
                y = 8;
            }
            if (row != 5) {
                long z = state.getBoardState() | (long) (Math.pow(2, x));
                st.setBoardState(z, state.getRemainBoardState());
            } else {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, y));
                st.setBoardState(state.getBoardState(), m);
            }
            row++;
            StringBuilder sb = new StringBuilder(state.getLimit());
            sb.setCharAt(0, (char) (row + '0'));
            st.setLimit(sb.toString());
            st.setDepth(state.getDepth() + 1);
            if (fromSetChildren)
                state.children.add(st);
            else
                return st;
        }
        return null;
    }

    public static State setSecondCol(State state, boolean isMax, boolean fromSetChildren) {
        //second row

        int row = Integer.parseInt(String.valueOf(state.getLimit().charAt(1)));
        int x, y;
        if (row < 6) {
            State st = new State();
            st.setBoardState(state.getBoardState(), state.getRemainBoardState());
            if (isMax) {
                x = row * 14 + 3;
                y = 11;
            } else {
                x = row * 14 + 2;
                y = 10;
            }
            if (row != 5) {
                long z = state.getBoardState() | (long) (Math.pow(2, x));
                st.setBoardState(z, state.getRemainBoardState());
            } else {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, y));
                st.setBoardState(state.getBoardState(), m);

            }
            row++;
            StringBuilder sb = new StringBuilder(state.getLimit());
            sb.setCharAt(1, (char) (row + '0'));
            st.setLimit(sb.toString());
            if (fromSetChildren)
                state.children.add(st);
            else
                return st;
        }

        return null;
    }

    public static State setThirdCol(State state, boolean isMax, boolean fromSetChildren) {
        //third row
        int row = Integer.parseInt(String.valueOf(state.getLimit().charAt(2)));
        int x, y;
        if (row < 6) {
            State st = new State();
            st.setBoardState(state.getBoardState(), state.getRemainBoardState());

            if (isMax) {
                x = row * 14 + 5;
                y = 13;
            } else {
                x = row * 14 + 4;
                y = 12;
            }
            if (row != 5) {
                long z = state.getBoardState() | (long) (Math.pow(2, x));
                st.setBoardState(z, state.getRemainBoardState());
            } else {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, y));
                st.setBoardState(state.getBoardState(), m);

            }
            row++;
            StringBuilder sb = new StringBuilder(state.getLimit());
            sb.setCharAt(2, (char) (row + '0'));
            st.setLimit(sb.toString());
            if (fromSetChildren)
                state.children.add(st);
            else
                return st;
        }
        return null;
    }

    public static State setForthCol(State state, boolean isMax, boolean fromSetChildren) {
        //forth row
        int row = Integer.parseInt(String.valueOf(state.getLimit().charAt(3)));
        int x, y, f;
        if (row < 6) {
            State st = new State();
            st.setBoardState(state.getBoardState(), state.getRemainBoardState());

            if (isMax) {
                x = row * 14 + 7;
                y = 15;
                f = 1;
            } else {
                x = row * 14 + 6;
                y = 14;
                f = 0;
            }
            if (row < 4) {
                long z = state.getBoardState() | (long) (Math.pow(2, x));
                st.setBoardState(z, state.getRemainBoardState());
            } else if (row == 4) {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, f));
                st.setBoardState(state.getBoardState(), m);

            } else {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, y));
                st.setBoardState(state.getBoardState(), m);
            }
            row++;
            StringBuilder sb = new StringBuilder(state.getLimit());
            sb.setCharAt(3, (char) (row + '0'));
            st.setLimit(sb.toString());
            if (fromSetChildren)
                state.children.add(st);
            else
                return st;
        }
        return null;
    }

    public static State setFifthCol(State state, boolean isMax, boolean fromSetChildren) {

        //fifth row
        int row = Integer.parseInt(String.valueOf(state.getLimit().charAt(4)));
        int x, y, f;
        if (row < 6) {
            State st = new State();
            st.setBoardState(state.getBoardState(), state.getRemainBoardState());

            if (isMax) {
                x = row * 14 + 9;
                y = 17;
                f = 3;
            } else {
                x = row * 14 + 8;
                y = 16;
                f = 2;
            }
            if (row < 4) {
                long z = state.getBoardState() | (long) (Math.pow(2, x));
                st.setBoardState(z, state.getRemainBoardState());
            } else if (row == 4) {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, f));
                st.setBoardState(state.getBoardState(), m);

            } else {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, y));
                st.setBoardState(state.getBoardState(), m);
            }
            row++;
            StringBuilder sb = new StringBuilder(state.getLimit());
            sb.setCharAt(4, (char) (row + '0'));
            st.setLimit(sb.toString());
            if (fromSetChildren)
                state.children.add(st);
            else
                return st;


        }
        return null;
    }

    public static State setSexCol(State state, boolean isMax, boolean fromSetChildren) {
        //six row
        int row = Integer.parseInt(String.valueOf(state.getLimit().charAt(5)));
        int x, y, f;
        if (row < 6) {
            State st = new State();
            st.setBoardState(state.getBoardState(), state.getRemainBoardState());

            if (isMax) {
                x = row * 14 + 11;
                y = 19;
                f = 5;
            } else {
                x = row * 14 + 10;
                y = 18;
                f = 4;
            }

            if (row < 4) {
                long z = state.getBoardState() | (long) (Math.pow(2, x));
                st.setBoardState(z, state.getRemainBoardState());
            } else if (row == 4) {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, f));
                st.setBoardState(state.getBoardState(), m);

            } else {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, y));
                st.setBoardState(state.getBoardState(), m);
            }
            row++;
            StringBuilder sb = new StringBuilder(state.getLimit());
            sb.setCharAt(5, (char) (row + '0'));
            st.setLimit(sb.toString());
            if (fromSetChildren)
                state.children.add(st);
            else
                return st;

        }

        return null;
    }

    public static State setSevenCol(State state, boolean isMax, boolean fromSetChildren) {

        //seven  col
        int row = Integer.parseInt(String.valueOf(state.getLimit().charAt(6)));
        int x, y, f;
        if (row < 6) {
            State st = new State();
            st.setBoardState(state.getBoardState(), state.getRemainBoardState());
            if (isMax) {
                x = row * 14 + 13;
                y = 21;
                f = 7;
            } else {
                x = row * 14 + 12;
                y = 20;
                f = 6;
            }
            if (row < 4) {
                long z = state.getBoardState() | (long) (Math.pow(2, x));
                st.setBoardState(z, state.getRemainBoardState());
            } else if (row == 4) {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, f));
                st.setBoardState(state.getBoardState(), m);

            } else {
                int m = state.getRemainBoardState() | (int) (Math.pow(2, y));
                st.setBoardState(state.getBoardState(), m);
            }


            row++;
            StringBuilder sb = new StringBuilder(state.getLimit());
            sb.setCharAt(6, (char) (row + '0'));
            st.setLimit(sb.toString());
            if (fromSetChildren)
                state.children.add(st);
            else
                return st;


        }
        return null;
    }

    public static void setLimit(State state) {

        int limit1 = 6;
        String limit = "";
        for (int i = 0; i < 5; i++) {
            long l = (long) (Math.pow(2, i * 14) + Math.pow(2, i * 14 + 1)) & state.getBoardState();
            if (l == 0) {
                limit1 = i;
                break;
            }
        }
        if (limit1 == 6) {
            int l = (int) (Math.pow(2, 8) + Math.pow(2, 9)) & state.getRemainBoardState();
            if (l == 0) {
                limit1 = 5;
            }
        }
        limit += limit1;
        limit1 = 6;

        for (int i = 0; i < 5; i++) {
            long l = (long) (Math.pow(2, i * 14 + 2) + Math.pow(2, i * 14 + 3)) & state.getBoardState();
            if (l == 0) {
                limit1 = i;
                break;
            }
        }

        if (limit1 == 6) {
            int l = (int) (Math.pow(2, 10) + Math.pow(2, 11)) & state.getRemainBoardState();
            if (l == 0) {
                limit1 = 5;
            }
        }

        limit += limit1;
        limit1 = 6;

        for (int i = 0; i < 5; i++) {
            long l = (long) (Math.pow(2, i * 14 + 4) + Math.pow(2, i * 14 + 5)) & state.getBoardState();
            if (l == 0) {
                limit1 = i;
                break;
            }
        }
        if (limit1 == 6) {
            int l = (int) (Math.pow(2, 12) + Math.pow(2, 13)) & state.getRemainBoardState();
            if (l == 0) {
                limit1 = 5;
            }
        }

        limit += limit1;
        limit1 = 6;

        for (int i = 0; i < 5; i++) {
            long l = (long) (Math.pow(2, i * 14 + 7) + Math.pow(2, i * 14 + 6)) & state.getBoardState();

            if (l == 0) {
                limit1 = i;
                break;
            }
        }

        if (limit1 == 6) {
            int l = (int) (Math.pow(2, 0) + Math.pow(2, 1)) & state.getRemainBoardState();
            if (l == 0) {
                limit1 = 4;
            } else {
                l = (int) (Math.pow(2, 14) + Math.pow(2, 15)) & state.getRemainBoardState();
                if (l == 0) {
                    limit1 = 5;
                }
            }
        }

        limit += limit1;
        limit1 = 6;

        for (int i = 0; i < 4; i++) {
            long l = (long) (Math.pow(2, i * 14 + 8) + Math.pow(2, i * 14 + 9)) & state.getBoardState();
            if (l == 0) {
                limit1 = i;
                break;
            }
        }
        if (limit1 == 6) {
            int l = (int) (Math.pow(2, 2) + Math.pow(2, 3)) & state.getRemainBoardState();
            if (l == 0) {
                limit1 = 4;
            } else {
                l = (int) (Math.pow(2, 16) + Math.pow(2, 17)) & state.getRemainBoardState();
                if (l == 0) {
                    limit1 = 5;
                }
            }
        }

        limit += limit1;
        limit1 = 6;
        for (int i = 0; i < 4; i++) {
            long l = (long) (Math.pow(2, i * 14 + 10) + Math.pow(2, i * 14 + 11)) & state.getBoardState();
            if (l == 0) {
                limit1 = i;
                break;
            }
        }

        if (limit1 == 6) {
            int l = (int) (Math.pow(2, 4) + Math.pow(2, 5)) & state.getRemainBoardState();
            if (l == 0) {
                limit1 = 4;
            } else {
                l = (int) (Math.pow(2, 18) + Math.pow(2, 19)) & state.getRemainBoardState();
                if (l == 0) {
                    limit1 = 5;
                }
            }
        }

        limit += limit1;
        limit1 = 6;

        for (int i = 0; i < 4; i++) {
            long l = (long) (Math.pow(2, i * 14 + 12) + Math.pow(2, i * 14 + 13)) & state.getBoardState();
            if (l == 0) {
                limit1 = i;
                break;
            }
        }
        if (limit1 == 6) {
            int l = (int) (Math.pow(2, 6) + Math.pow(2, 7)) & state.getRemainBoardState();
            if (l == 0) {
                limit1 = 4;
            } else {
                l = (int) (Math.pow(2, 20) + Math.pow(2, 21)) & state.getRemainBoardState();
                if (l == 0) {
                    limit1 = 5;
                }
            }
        }
        limit += limit1;
        state.setLimit(limit);
    }
}
