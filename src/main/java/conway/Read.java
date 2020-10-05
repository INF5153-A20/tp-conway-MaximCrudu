package conway;

import java.io.BufferedReader;
import java.io.FileReader;

public class Read {

    private String fichier;

    /**
     * @param fichier contient le chemin et le nom du fichier inséré dans l'argument
     */
    public Read(String fichier) {
        this.fichier = fichier;
    }

    /**
     * La méthode entrerDonnees, appelée par la classe Main
     * Lit les données dans le fichier
     *
     * @return Plateau - un tableau contenant de cellules avec de valeurs booléens et ses coordonnées
     */
    public Plateau entrerDonnees() {

        Plateau contenu = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            int dimension = Integer.parseInt(reader.readLine().trim());

            contenu = new Plateau();
            int nrLigne = 0;

            while (nrLigne < dimension) {
                String ligneBrute = reader.readLine();
                String[] ligne = ligneBrute.trim().split(" ");

                Validation valeurBool = new Validation(ligne);
                contenu.remplirPlateau(valeurBool.getLigne(), nrLigne);
                nrLigne++;
            }
            reader.close();
        } catch (Exception e) {
            System.exit(2);
        }
        return contenu;
    }
}
