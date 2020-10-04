package conway;

import java.util.*;

public class Plateau implements Iterable<Cellule> {

    private List<List<Cellule>> grille = new ArrayList<>();
    private List<Cellule> grillePointer = new ArrayList<>();

    public Plateau() {
    }

    /**
     * @param nouveau un tableau initialisé
     */
    public Plateau(Plateau nouveau) {
        this.grille = nouveau.grille;
        this.grillePointer = nouveau.grillePointer;
    }

    /**
     * La méthode remplirPlateau, appelée par la classe Read
     * Introduit les données présentes dans le tableau booléen dans les cellules du plateau
     *
     * @return void
     */
    public void remplirPlateau(boolean[] etatActuel, int x) {
        List<Cellule> ligne = new ArrayList<>();
        for (int y = 0; y < etatActuel.length; y++) {
            ligne.add(new Cellule(new Coordonee(x, y), etatActuel[y]));
            grillePointer.add(ligne.get(ligne.size() - 1));
        }
        grille.add(ligne);
    }

    /**
     * La méthode enregistrerCellule, appelée par la classe JeuxDeLaVie
     * Enregistre une nouvelle cellule dans le plateau qui représentera un nouvel état
     *
     * @return void
     */
    public void enregistrerCellule(Cellule cellule) {
        if (grille.size() <= cellule.getCoordonneeX()) {
            grille.add(new ArrayList<>());
        }
        grille.get(cellule.getCoordonneeX()).add(cellule);
        grillePointer.add(cellule);
    }

    /**
     * La méthode enregistrerCellule, appelée par la classe JeuxDeLaVie
     * Compte le nombre de voisins vivants autour d'une cellule
     *
     * @return int le nombre de voisins vivants
     */
    public int getVoisinsVivants(Cellule cellule) {
        int x = cellule.getCoordonneeX();
        int y = cellule.getCoordonneeY();
        int voisinsViv = 0;
        try {
            if (x > 0) {
                if (y > 0 && grille.get(x - 1).get(y - 1).estVivante()) {
                    voisinsViv++;
                }
                if (grille.get(x - 1).get(y).estVivante()) {
                    voisinsViv++;
                }
                if (y + 1 < grille.get(y).size() && grille.get(x - 1).get(y + 1).estVivante()) {
                    voisinsViv++;
                }
            }
            if (y > 0 && grille.get(x).get(y - 1).estVivante()) {
                voisinsViv++;
            }
            if (y + 1 < grille.get(y).size() && grille.get(x).get(y + 1).estVivante()) {
                voisinsViv++;
            }
            if (x + 1 < grille.size()) {
                if (y > 0 && grille.get(x + 1).get(y - 1).estVivante()) {
                    voisinsViv++;
                }
                if (grille.get(x + 1).get(y).estVivante()) {
                    voisinsViv++;
                }
                if (y + 1 < grille.get(y).size() && grille.get(x + 1).get(y + 1).estVivante()) {
                    voisinsViv++;
                }
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("La grille entrée ne suit pas la forme souhaitée");
            System.exit(4);
        }
        return voisinsViv;
    }

    /**
     * La méthode afficher, appelée par la classe JeuxDeLaVie
     * Affiche l'état final du plateau
     *
     * @return void
     */
    public void afficher() {
        List<List<Cellule>> it_lignes = grille;
        System.out.println(grille.size());
        for (List<Cellule> ligne : it_lignes) {
            for (Cellule cellule : ligne) {
                if (cellule.estVivante()) {
                    System.out.print("X");
                } else {
                    System.out.print("_");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    /**
     * La méthode iterator, appelée par la classe JeuxDeLaVie
     *
     * @return Iterator un itérateur de la liste de pointeurs sur la grille du plateau
     */
    @Override
    public Iterator<Cellule> iterator() {
        return Collections.unmodifiableList(grillePointer).iterator();
    }
}

