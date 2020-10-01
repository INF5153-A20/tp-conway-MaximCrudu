package conway;

/**
 * The main class
 */
public class Main {

    /**
     * The main method, called by Maven
     * @param args the arguments given to main as an array of strings
     */
    public static void main(String[] args) {

        String fichier = null;
        int nbSimulation = -1;
        try {
            fichier = args[0];
            nbSimulation = Integer.parseInt(args[1]);
        } catch (Exception e) { System.exit(1); }

        Plateau plateau = new Plateau(Read.entrerDonnees(fichier));

        if (plateau == null){
            System.exit(2);
        }
        JeuxDeLaVie.simuler(plateau ,nbSimulation);

        System.exit(0);
    }
}
