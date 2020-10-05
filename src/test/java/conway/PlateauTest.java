package conway;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class PlateauTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    public void testRemplirPlateau1() {
        String[] donnees = {
                "_ X X _ X _",
                "_ X X _ X _",
                "X _ X _ X _",
                "_ X X _ X _",
                "X _ X _ X _",
                "_ X X _ X _"};

        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++) {
            Validation valide = new Validation(donnees[x].split(" "));
            p.remplirPlateau(valide.getLigne(), x);
        }
        assertNotNull(p);
    }

    @Test
    public void testRemplirPlateau2() {
        String[] donnees = {
                "_ _ _ _ _ _",
                "_ _ _ _ _ _",
                "_ _ _ _ _ _",
                "_ _ _ _ _ _",
                "_ _ _ _ _ _",
                "_ _ _ _ _ _"};

        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++) {
            Validation valide = new Validation(donnees[x].split(" "));
            p.remplirPlateau(valide.getLigne(), x);
        }
        assertNotNull(p);
    }

    @Test
    public void testEnregistrerCellule() {
        String[] donnees = {
                "_ _ _ _ _ _",
                "_ _ _ _ _ _",
                "_ _ _ _ _ _",
                "_ _ _ _ _ _",
                "_ _ _ _ _ _",
                "_ _ _ _ _"};

        Cellule c = new Cellule(new Coordonee(5, 5), true);
        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++) {
            Validation valide = new Validation(donnees[x].split(" "));
            p.remplirPlateau(valide.getLigne(), x);
        }
        p.enregistrerCellule(c);
        int nbCell = 0;
        for (Cellule cell : p) {
            nbCell++;
        }
        assertEquals(36, nbCell);
    }

    @Test
    public void testGetVoisinsVivants1() {
        String[] donnees = {
                "_ X X _ X _",
                "_ X X _ _ _",
                "X _ X _ _ _",
                "_ X X _ X _",
                "X _ _ _ _ _",
                "_ X _ _ X _"};
        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++) {
            Validation valide = new Validation(donnees[x].split(" "));
            p.remplirPlateau(valide.getLigne(), x);
        }
        for (Cellule c : p) {
            if (c.getCoordonneeX() == 2 && c.getCoordonneeY() == 1) {
                assertEquals(6, p.getVoisinsVivants(c));
            }
        }

    }

    @Test
    public void testGetVoisinsVivants2() {
        String[] donnees = {
                "_ X X _ X _",
                "_ X X _ _ _",
                "X _ X _ _ _",
                "_ X X _ X _",
                "X _ _ _ _ _",
                "_ X _ _ _ _"};
        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++) {
            Validation valide = new Validation(donnees[x].split(" "));
            p.remplirPlateau(valide.getLigne(), x);
        }
        for (Cellule c : p) {
            if (c.getCoordonneeX() == 4 && c.getCoordonneeY() == 4) {
                assertEquals(1, p.getVoisinsVivants(c));
            }
        }
    }

    @Test
    public void testGetVoisinsVivants3() {
        String[] donnees = {
                "_ X X _ X _",
                "_ X X _ _ _",
                "X _ X _ _ _",
                "_ X X _ X _",
                "X _ _ _ _ _",
                "_ X _ _ _ _"};
        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++) {
            Validation valide = new Validation(donnees[x].split(" "));
            p.remplirPlateau(valide.getLigne(), x);
        }
        for (Cellule c : p) {
            if (c.getCoordonneeX() == 5 && c.getCoordonneeY() == 3) {
                assertEquals(0, p.getVoisinsVivants(c));
            }
        }
    }

    /* Afin de rediriger la sortie, on a utilisé les informations trouvées sur le site
    https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java/8708357
    Comme on peut le voir, les informations de la sortie sont redirigées et entrées dans une variable.
    P.S. Ce bloc peut être trouvé plusieurs fois dans les fichiers de test.
    */
    @Test
    public void testAfficher1() {
        String[] donnees = {
                "_ X X _ X _",
                "_ X X _ X _",
                "X _ X _ X _",
                "_ X X _ X _",
                "X _ X _ X _",
                "_ X X _ X _"};

        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++) {
            Validation valide = new Validation(donnees[x].split(" "));
            p.remplirPlateau(valide.getLigne(), x);
        }

        // Le bloc utilisé du site
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        p.afficher();
        System.out.flush();
        System.setOut(old);

        String[] sortie = baos.toString().trim().split("\n");
        for (int x = 1; x < donnees.length; x++) {
            String ligneSortie = sortie[x].substring(0, sortie[x].length() - 1);
            assertEquals(donnees[x - 1], ligneSortie);
        }
    }

    @Test
    public void testAfficher2() {
        String[] donnees = {
                "X _ _ _ X _ X",
                "_ X _ _ X _ X",
                "X _ X _ X _ X",
                "_ X _ _ X _ _",
                "X _ _ _ X _ _",
                "X _ X _ X _ X",
                "_ X _ _ X _ X"};

        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++) {
            Validation valide = new Validation(donnees[x].split(" "));
            p.remplirPlateau(valide.getLigne(), x);
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        p.afficher();
        System.out.flush();
        System.setOut(old);

        String[] sortie = baos.toString().trim().split("\n");
        for (int x = 1; x < donnees.length; x++) {
            String ligneSortie = sortie[x].substring(0, sortie[x].length() - 1);
            assertEquals(donnees[x - 1], ligneSortie);
        }
    }
}
