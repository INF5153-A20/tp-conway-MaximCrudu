package conway;

public class JeuxDeLaVie {

    private Plateau plateau;
    private int nbSimulation;

    /**
     * @param plateau la configuration initiale du plateau
     * @param nbSimulation le nombre de pas de simulation à effectuer
     */
    public JeuxDeLaVie(Plateau plateau, int nbSimulation) {
        this.plateau = plateau;
        this.nbSimulation = nbSimulation;
    }

    /**
     * La méthode simuler, appelée par la classe Main
     * Itère le plateau en changeant son état selon les règles d'affaires du jeu
     *
     * @return void
     */
    public void simuler() {

        for (int i = 0; i < nbSimulation; i++) {
            Plateau nouvelEtat = new Plateau();
            for (Cellule cellule : plateau) {
                int voisinsVivants = plateau.getVoisinsVivants(cellule);
                if (cellule.estMorte() && voisinsVivants == 3) {
                    nouvelEtat.enregistrerCellule(new Cellule(cellule).prendVie());
                } else if (cellule.estVivante() && voisinsVivants < 2) {
                    nouvelEtat.enregistrerCellule(new Cellule(cellule).meurt());
                } else if (cellule.estVivante() && voisinsVivants > 3) {
                    nouvelEtat.enregistrerCellule(new Cellule(cellule).meurt());
                } else {
                    nouvelEtat.enregistrerCellule(new Cellule(cellule));
                }
            }
            plateau = nouvelEtat;
        }
        plateau.afficher();
    }
}
