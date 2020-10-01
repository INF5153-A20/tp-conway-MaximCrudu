package conway;

import java.util.*;

public class Plateau implements Iterable<Cellule>{

    private int dimension;
//    private Cellule[][] grille;
    private List<List<Cellule>> grille = new ArrayList<>();
    private List<Cellule> pointGrille = new ArrayList<>();

    public Plateau() {
    }

    public Plateau(int dimension) {
        this.dimension = dimension;
//        grille = new Cellule[dimension][dimension];
    }

    public Plateau(Plateau nouveau) {
        this.pointGrille = nouveau.pointGrille;
        this.grille = nouveau.grille;
    }

    public void remplir(String[] etatActuel, int x) {
        List<Cellule> ligne= new ArrayList<>();
        for (int y = 0; y < etatActuel.length; y++){
//          grille[x][y] = new Cellule(new Coordonee(x, y), etatActuel[y]);
          ligne.add(new Cellule(new Coordonee(x, y), etatActuel[y]));
          pointGrille.add(ligne.get(ligne.size()-1));
      }
        grille.add(ligne);
    }

    public void enregistrer(Cellule cellule) {
        if(grille.size() <= cellule.getCoordonneeX()){
            grille.add(new ArrayList<>());
        }
        grille.get(cellule.getCoordonneeX()).add(cellule);
   //     List<Cellule> iterator = grille.get(cellule.getCoordonneeX());
   //     iterator.add(cellule);
        pointGrille.add(cellule);
    }

    public int getVoisinsVivants(Cellule cellule) {
        int x = cellule.getCoordonneeX();
        int y = cellule.getCoordonneeY();
        int voisinsViv = 0 ;
        if(x > 0){
            if (y > 0 && grille.get(x-1).get(y-1).estVivante()){
                voisinsViv++;
            }
            if (grille.get(x-1).get(y).estVivante()){
                voisinsViv++;
            }
            if (y+1 < grille.get(y).size() && grille.get(x-1).get(y+1).estVivante()){
                voisinsViv ++;
            }
        }
        if (y > 0 && grille.get(x).get(y-1).estVivante()){
            voisinsViv ++;
        }
        if (y+1 < grille.get(y).size() && grille.get(x).get(y+1).estVivante()){
            voisinsViv ++;
        }
        if (x+1 < grille.size()){
            if (y > 0 && grille.get(x+1).get(y-1).estVivante()){
                voisinsViv ++;
            }
            if (grille.get(x+1).get(y).estVivante()){
                voisinsViv ++;
            }
            if (y+1 < grille.get(y).size() && grille.get(x+1).get(y+1).estVivante()) {
                voisinsViv ++;
            }
        }
        return voisinsViv;
    }

    public void afficher() {
        List<List<Cellule>> it_lignes= grille;
        System.out.println(grille.size());
        for(List<Cellule> ligne: it_lignes){
            for (Cellule cellule: ligne){
                if(cellule.estVivante()) {
                    System.out.print("X");
                }
                else { System.out.print("_");
                }
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    @Override
    public Iterator<Cellule> iterator() {
        return this.pointGrille.iterator();
    }
}

