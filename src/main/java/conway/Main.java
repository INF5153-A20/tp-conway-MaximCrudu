package conway;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * The main class
 */
public class Main {

    /**
     * The main method, called by Maven
     * @param args the arguments given to main as an array of strings
     */
    public static void main(String[] args) {
        String f = null;
        int cnt = -1;
        try {
            f = args[0];
            cnt = Integer.parseInt(args[1]); //nombre de pas d'utilisation
            System.out.println("La valeur de cnt est " + cnt);
        } catch (Exception e) { System.exit(1); }

        boolean[][] gs = null; // first, we initialize gs with null
        try {
            BufferedReader r = new BufferedReader(new FileReader(f));
            int d = Integer.parseInt(r.readLine().trim()); //la premiere ligne

            gs = new boolean[d][d]; // gs is now d x d
            int x = 0;
            while (x < d) {
                String l = r.readLine(); //lire ligne par ligne
                String[] cs = l.trim().split(" "); //la ligne sans espaces
                for(int y = 0; y < cs.length; y++) { //lire caractere par caractere
                    switch(cs[y]) {
                        case "_": gs[x][y] = false; break;
                        case "X": gs[x][y] = true; break;
                        default:  System.exit(2);
                    }
                }
                x++;
            }
            r.close();
        } catch (Exception e) { System.exit(2); }

        for(int cpt = 0; cpt < cnt; cpt++) {
            int d = gs.length;
            boolean[][] ns = new boolean[d][d]; //la grille suite a un pas
            for(int x = 0; x < d; x++) { //parcours d'une ligne
                for (int y = 0; y < d; y++) {  //cas par cas
                    int n = 0;
                    if (x > 0){//verifier si on depasse pas en haut la grille d'une ligne
                        if (y > 0 && gs[x-1][y-1]) { n++; }// 1
                        if (gs[x-1][y])              { n++; }// 2
                        if (y+1 < d && gs[x-1][y+1]) { n++; }
                    }
                    if (y > 0 && gs[x][y-1]) { n++; } // 4
                    if (y+1 < d && gs[x][y+1]) { n++; }  // 5
                    if(x+1 < d) { //verifier si on depasse pas en bas la grille d'une ligne
                        if (y > 0 && gs[x+1][y-1]) { n++; } // 6
                        if (gs[x+1][y])              { n++; } // 7
                        if (y+1 < d && gs[x+1][y+1]) { n++; } // 8
                    }
                    if      (gs[x][y] && n  < 2)  { ns[x][y] = false;    } // sous-population
                    else if (gs[x][y] && n  > 3)  { ns[x][y] = false;    } // surpopulation
                    else if (!gs[x][y] && n == 3) { ns[x][y] = true;     } // cell morte devient vivante
                    else                          { ns[x][y] = gs[x][y]; } // reste telle quelle
                }
            }
            gs = ns; // passe a l'etape suivante
        }

        System.out.println(gs.length);
        for(int x = 0; x < gs.length; x++){
            for(int y = 0; y < gs[x].length; y++) {
                if (gs[x][y]) { System.out.print("X"); }
                else { System.out.print("_"); }
                System.out.print(" ");
            }
            System.out.println();
        }
        System.exit(0);
    }
}
