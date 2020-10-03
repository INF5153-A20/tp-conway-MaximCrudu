package conway;

/**
 * The main class
 */
public class Main {

    /**
     * The main method, called by Maven
     *
     * @param args the arguments given to main as an array of strings
     */
    public static void main(String[] args) {

        String fichier = null;
        int nbSimulation = -1;
        try {
            fichier = args[0];
            nbSimulation = Integer.parseInt(args[1]);
        } catch (Exception e) {
            System.exit(1);
        }

        Read configuration = new Read(fichier);
        Plateau plateau = new Plateau(configuration.entrerDonnees());

        JeuxDeLaVie jeu = new JeuxDeLaVie(plateau, nbSimulation);
        jeu.simuler();

        System.exit(0);
    }
}
