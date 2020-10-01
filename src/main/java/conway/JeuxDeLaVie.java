package conway;

public class JeuxDeLaVie {

    public static void simuler(Plateau plateau, int nbSimulation) {

        for(int i = 0; i < nbSimulation; i++) {
            Plateau nouvelEtat = new Plateau();
            for (Cellule cellule : plateau) {
                int voisinsVivants = plateau.getVoisinsVivants(cellule);
                if (cellule.estMorte() && voisinsVivants == 3){
                    nouvelEtat.enregistrer(new Cellule(cellule).vivante());
                } else if (cellule.estVivante() && voisinsVivants < 2) {
                    nouvelEtat.enregistrer(new Cellule(cellule).morte());
                } else if (cellule.estVivante() && voisinsVivants > 3) {
                    nouvelEtat.enregistrer(new Cellule(cellule).morte());
                } else{
                    nouvelEtat.enregistrer(new Cellule(cellule));
                }
            }
            plateau = nouvelEtat;
        }
        plateau.afficher();
    }
}
