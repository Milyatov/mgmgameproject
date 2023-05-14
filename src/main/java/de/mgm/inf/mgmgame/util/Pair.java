package de.mgm.inf.mgmgame.util;

public class Pair<X,Y> {
    X first;
    Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getFirst() {
        return first;
    }

    public Y getSecond() {
        return second;
    }

    public static <X,Y> Pair<X,Y> of(X first, Y second) {
        return new Pair<>(first, second);
    }
}
