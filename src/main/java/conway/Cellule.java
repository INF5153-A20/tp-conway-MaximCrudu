package conway;

public class Cellule {

    private Coordonee emplacement;
    private boolean etatVie;

    public Cellule(String etat) {
        this.etatVie = verifEtat(etat);
    }

    public Cellule(Coordonee emplacement, String etat) {
        this.emplacement = emplacement;
        this.etatVie = verifEtat(etat);
    }

    public Cellule(Cellule nouvCell, String etat) {
        System.out.println("Dans le constr Cellule" + etat);
    }

    public Cellule(Cellule meme) {
        this.emplacement = meme.emplacement;
        this.etatVie = meme.etatVie;
    }

    private boolean verifEtat(String etatCell) {
        switch(etatCell) {
            case "_": return this.etatVie = false; //return Etat.MORTE;
            case "X": return this.etatVie = true; //return Etat.VIVANTE;
            default: System.exit(2);
        }
        return false;
    }

    public Cellule morte() {
        this.etatVie = false;
        return this;
    }

    public Cellule vivante() {
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
