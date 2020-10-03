package conway;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class JeuxDeLaVieTest {

    @Test
    public void simulerTest1() {
        String[] donnees = {
                "_ _ _ _ _",
                "_ X X _ _",
                "_ _ X _ X",
                "_ _ _ _ X",
                "_ _ _ _ _"};

        String[] resultat = {
                "_ _ _ _ _",
                "_ X X X _",
                "_ X X _ _",
                "_ _ _ X _",
                "_ _ _ _ _"};

        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++){
            p.remplirPlateau(donnees[x].split(" "),x);
        }

        JeuxDeLaVie jeu = new JeuxDeLaVie(p, 1);

        // Le bloc utilisé du site (voir PlateauTest.java)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        jeu.simuler();
        System.out.flush();
        System.setOut(old);

        String[] sortie = baos.toString().trim().split("\n");
        for (int x=1; x<donnees.length; x++ ){
            String ligneSortie = sortie[x].substring(0,sortie[x].length()-1);
            assertEquals(resultat[x-1],ligneSortie);
        }
    }

    @Test
    public void simulerTest2() {
        String[] donnees = {
                "_ _ _ _ _",
                "_ X X _ _",
                "_ _ X _ X",
                "_ _ _ _ X",
                "_ _ _ _ _"};

        String[] resultat = {
                "_ _ _ _ _",
                "_ X X _ _",
                "_ _ _ _ _",
                "_ _ _ _ _",
                "_ _ _ _ _"};

        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++){
            p.remplirPlateau(donnees[x].split(" "),x);
        }

        JeuxDeLaVie jeu = new JeuxDeLaVie(p, 4);

        // Le bloc utilisé du site (voir PlateauTest.java)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        jeu.simuler();
        System.out.flush();
        System.setOut(old);

        String[] sortie = baos.toString().trim().split("\n");
        for (int x=1; x<donnees.length; x++ ){
            String ligneSortie = sortie[x].substring(0,sortie[x].length()-1);
            assertEquals(resultat[x-1],ligneSortie);
        }
    }

    @Test
    public void simulerTest3() {
        String[] donnees = {
                "_ _ _ _ X _",
                "_ _ _ _ X _",
                "_ _ _ _ X _",
                "_ _ _ _ X _",
                "_ _ _ _ X _",
                "_ _ _ _ X _"};

        String[] resultat = {
                "_ _ _ _ _ _",
                "_ _ _ X X X",
                "_ _ _ X X X",
                "_ _ _ X X X",
                "_ _ _ X X X",
                "_ _ _ _ _ _"};

        Plateau p = new Plateau();
        for (int x = 0; x < donnees.length; x++){
            p.remplirPlateau(donnees[x].split(" "),x);
        }

        JeuxDeLaVie jeu = new JeuxDeLaVie(p, 1);

        // Le bloc utilisé du site (voir PlateauTest.java)
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);
        jeu.simuler();
        System.out.flush();
        System.setOut(old);

        String[] sortie = baos.toString().trim().split("\n");
        for (int x=1; x<donnees.length; x++ ){
            String ligneSortie = sortie[x].substring(0,sortie[x].length()-1);
            assertEquals(resultat[x-1],ligneSortie);
        }
    }
}
