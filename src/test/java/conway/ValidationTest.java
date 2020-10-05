package conway;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationTest {

    @Test
    public void testGetLine1() {
        String ligneBrute = "X _ _ _ X _ X";
        String[] ligne = ligneBrute.split(" ");
        Validation val = new Validation(ligneBrute.split(" "));
        boolean[] valBool = val.getLigne();
        for (int i = 0; i < ligne.length; i++) {
            if (ligne[i].equals("X")) {
                assertTrue(valBool[i]);
            }
        }
    }

    @Test
    public void testGetLine2() {
        String ligneBrute = "X _ _ _ X _ X";
        String[] ligne = ligneBrute.split(" ");
        Validation val = new Validation(ligneBrute.split(" "));
        boolean[] valBool = val.getLigne();
        for (int i = 0; i < ligne.length; i++) {
            if (ligne[i].equals("_")) {
                assertFalse(valBool[i]);
            }
        }
    }
}
