package conway;

public class Cellule {

    private Coordonee emplacement;
    private boolean etatVie;

    public Cellule(Coordonee emplacement, boolean etat) {
        this.emplacement = emplacement;
        this.etatVie = etat;
    }

    public Cellule(Cellule meme) {
        this.emplacement = meme.emplacement;
        this.etatVie = meme.etatVie;
    }

    public Cellule meurt() {
        this.etatVie = false;
        return this;
    }

    public Cellule prendVie() {
        this.etatVie = true;
        return this;
    }

    public boolean estVivante() {
        return this.etatVie;
    }

    public boolean estMorte() {
        return !this.etatVie;
    }

    public int getCoordonneeX() {
        return this.emplacement.getX();
    }

    public int getCoordonneeY() {
        return this.emplacement.getY();
    }
}

