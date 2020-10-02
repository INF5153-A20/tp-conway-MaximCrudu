package conway;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CelluleTest {

//    @Test
//    public void testCelluleMeurt(){
//       // Cellule c = new Cellule();
//    }

    @Test
    public void testCelluleMorte1(){
         Cellule c = new Cellule(new Coordonee(2,3),"_");
         assertEquals(true, c.estMorte());
    }

    @Test
    public void testCelluleMorte2(){
        Cellule c = new Cellule(new Coordonee(0,1),"X");
        assertEquals(false, c.estMorte());
    }


    @Test
    public void testCelluleVivante1(){
        Cellule c = new Cellule(new Coordonee(2,3),"X");
        assertEquals(true, c.estVivante());
    }

    @Test
    public void testCelluleVivante2(){
        Cellule c = new Cellule(new Coordonee(134,99),"_");
        assertEquals(false, c.estVivante());
    }

}
