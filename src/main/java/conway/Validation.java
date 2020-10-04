package conway;

public class Validation {

    boolean[] ligneBool;

    /**
     * @param ligne un tableau de chaînes de caractères dont chaque cas
     *              ne contient qu'un seul caractère
     */
    public Validation(String[] ligne) {
        this.ligneBool = transformLigne(ligne);
    }

    /**
     * La méthode transformLigne, appelée par la classe Read
     * Valide les données présentes dans le tableau String en entrant ses valeurs sous
     * forme booléenne dans un autre tableau
     *
     * @return boolean[] - un tableau contenant de valeurs booléennes
     */
    private boolean[] transformLigne(String[] ligne) {

        boolean[] ligneRes = new boolean[ligne.length];

        for (int i = 0; i < ligne.length; i++) {
            switch (ligne[i]) {
                case "_":
                    ligneRes[i] = false;
                    break;
                case "X":
                    ligneRes[i] = true;
                    break;
                default:
                    System.out.println("Un caractère invalide est entré: " + ligne[i]);
                    System.exit(3);
            }
        }
        return ligneRes;
    }

    /**
     * La méthode getLigne, appelée par la classe Read
     *
     * @return boolean[] - un tableau contenant de valeurs booléennes
     */
    public boolean[] getLigne() {
        return ligneBool.clone();
    }
}
