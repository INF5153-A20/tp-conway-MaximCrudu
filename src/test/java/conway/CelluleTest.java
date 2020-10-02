package conway;

import org.junit.Test;

import static org.junit.Assert.*;

public class CelluleTest {

    @Test
    public void testCelluleMeurt1(){
        Cellule c = new Cellule(new Coordonee(15,22),"X");
        c.meurt();
        assertTrue(c.estMorte());
        assertFalse(c.estVivante());
    }

    @Test
    public void testCelluleMeurt2(){
        Cellule c = new Cellule(new Coordonee(0,2),"_");
        c.meurt();
        assertTrue(c.estMorte());
        assertFalse(c.estVivante());
    }

    @Test
    public void testCellulePrendVie1(){
        Cellule c = new Cellule(new Coordonee(55,87),"_");
        c.prendVie();
        assertTrue(c.estVivante());
        assertFalse(c.estMorte());
    }

    @Test
    public void testCellulePrendVie2(){
        Cellule c = new Cellule(new Coordonee(3,25),"X");
        c.prendVie();
        assertTrue(c.estVivante());
        assertFalse(c.estMorte());
    }

    @Test
    public void testCelluleEstMorte1(){
         Cellule c = new Cellule(new Coordonee(2,3),"_");
         assertTrue(c.estMorte());
    }

    @Test
    public void testCelluleEstMorte2(){
        Cellule c = new Cellule(new Coordonee(0,1),"X");
        assertFalse(c.estMorte());
    }

    @Test
    public void testCelluleEstVivante1(){
        Cellule c = new Cellule(new Coordonee(2,3),"X");
        assertTrue(c.estVivante());
    }

    @Test
    public void testCelluleEstVivante2(){
        Cellule c = new Cellule(new Coordonee(134,99),"_");
        assertFalse(c.estVivante());
    }

    @Test
    public void test1GetCoordonneesX(){
        Cellule c = new Cellule(new Coordonee(134,99),"_");
        assertEquals(134, c.getCoordonneeX());
    }

    @Test
    public void test2GetCoordonneesX(){
        Cellule c = new Cellule(new Coordonee(134,99),"_");
        assertNotEquals(133, c.getCoordonneeX());
    }

    @Test
    public void test1GetCoordonneesY(){
        Cellule c = new Cellule(new Coordonee(134,99),"_");
        assertEquals(99, c.getCoordonneeY());
    }

    @Test
    public void test2GetCoordonneesY(){
        Cellule c = new Cellule(new Coordonee(134,99),"_");
        assertNotEquals(100, c.getCoordonneeY());
    }
}
