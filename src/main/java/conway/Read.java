package conway;

import java.io.BufferedReader;
import java.io.FileReader;

public class Read {

    private String fichier;

    public Read(String fichier) {
        this.fichier = fichier;
    }

    public Plateau entrerDonnees() {

        Plateau contenu = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            int dimension = Integer.parseInt(reader.readLine().trim());

            contenu = new Plateau();
            int iter = 0;

            while (iter < dimension) {
                String ligneBrute = reader.readLine();
                String[] ligne = ligneBrute.trim().split(" ");

                Validation valeurBool = new Validation(ligne);
                contenu.remplirPlateau(valeurBool.getLigne(), iter);
                iter++;
            }
            reader.close();
        } catch (Exception e) {
            System.exit(2);
        }
        return contenu;
    }
}
