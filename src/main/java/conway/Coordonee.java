package conway;

public class Coordonee {
    private final int X;
    private final int Y;

    /**
     * @param X coordonnée x
     * @param Y coordonnée y
     */
    public Coordonee(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }
}
