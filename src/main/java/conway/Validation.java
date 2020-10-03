package conway;

public class Validation {

    boolean[] ligneBool;

    public Validation(String[] ligne) {
        this.ligneBool = transformLigne(ligne);
    }

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

    public boolean[] getLigne() {
        return ligneBool.clone();
    }
}
