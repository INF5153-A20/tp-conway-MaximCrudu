package conway;

import java.io.BufferedReader;
import java.io.FileReader;

public class Read {

    public static Plateau entrerDonnees(String fichier) {

        Plateau contenu = null;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fichier));
            int dimension = Integer.parseInt(reader.readLine().trim());

            contenu = new Plateau(dimension);

            int iter = 0;
            while (iter < dimension) {
                String ligne = reader.readLine();
                contenu.remplir(ligne.trim().split(" "), iter);

                iter++;
            }
            reader.close();
        } catch (Exception e) { System.exit(2); }

        return contenu;
    }

//    public static boolean verifEntree(String fichier) {
//        return true;
//    }

}
