package conway;

public class Cellule {

    private Coordonee emplacement;
    private boolean etatVie;

    /**
     * @param emplacement coordonnée de cellule
     * @param etat état de la cellule
     */
    public Cellule(Coordonee emplacement, boolean etat) {
        this.emplacement = emplacement;
        this.etatVie = etat;
    }

    /**
     * @param meme cellule à copier
     */
    public Cellule(Cellule meme) {
        this.emplacement = meme.emplacement;
        this.etatVie = meme.etatVie;
    }

    /**
     * La méthode meurt, appelée par la classe JeuxDeLaVie
     * Change l'état de la cellule en mort
     *
     * @return Cellule la cellule dont l'état est mort
     */
    public Cellule meurt() {
        this.etatVie = false;
        return this;
    }

    /**
     * La méthode prendVie, appelée par la classe JeuxDeLaVie
     * Change l'état de la cellule en tant que vivant
     *
     * @return Cellule la cellule dont l'état est vivant
     */
    public Cellule prendVie() {
        this.etatVie = true;
        return this;
    }

    /**
     * La méthode estVivante, appelée par la classe Plateau
     *
     * @return boolean par rapport à l'état vivant de la cellule
     */
    public boolean estVivante() {
        return this.etatVie;
    }

    /**
     * La méthode estMorte, appelée par la classe Plateau
     *
     * @return boolean par rapport à l'état mort de la cellule
     */
    public boolean estMorte() {
        return !this.etatVie;
    }

    /**
     * La méthode getCoordonneeX, appelée par la classe Plateau
     *
     * @return int coordonnée x
     */
    public int getCoordonneeX() {
        return this.emplacement.getX();
    }

    /**
     * La méthode getCoordonneeY, appelée par la classe Plateau
     *
     * @return int coordonnée y
     */
    public int getCoordonneeY() {
        return this.emplacement.getY();
    }
}

