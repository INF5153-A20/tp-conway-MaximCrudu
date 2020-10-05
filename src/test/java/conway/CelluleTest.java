package conway;

import org.junit.Test;

import static org.junit.Assert.*;

public class CelluleTest {

    @Test
    public void testCelluleMeurt1() {

        Cellule c = new Cellule(new Coordonee(15, 22), true);
        c.meurt();
        assertTrue(c.estMorte());
        assertFalse(c.estVivante());
    }

    @Test
    public void testCelluleMeurt2() {
        Cellule c = new Cellule(new Coordonee(0, 2), false);
        c.meurt();
        assertTrue(c.estMorte());
        assertFalse(c.estVivante());
    }

    @Test
    public void testCellulePrendVie1() {
        Cellule c = new Cellule(new Coordonee(55, 87), true);
        c.prendVie();
        assertTrue(c.estVivante());
        assertFalse(c.estMorte());
    }

    @Test
    public void testCellulePrendVie2() {
        Cellule c = new Cellule(new Coordonee(3, 25), false);
        c.prendVie();
        assertTrue(c.estVivante());
        assertFalse(c.estMorte());
    }

    @Test
    public void testCelluleEstMorte1() {
        Cellule c = new Cellule(new Coordonee(2, 3), false);
        assertTrue(c.estMorte());
    }

    @Test
    public void testCelluleEstMorte2() {
        Cellule c = new Cellule(new Coordonee(0, 1), true);
        assertFalse(c.estMorte());
    }

    @Test
    public void testCelluleEstVivante1() {
        Cellule c = new Cellule(new Coordonee(2, 3), true);
        assertTrue(c.estVivante());
    }

    @Test
    public void testCelluleEstVivante2() {
        Cellule c = new Cellule(new Coordonee(134, 99), false);
        assertFalse(c.estVivante());
    }

    @Test
    public void test1GetCoordonneesX() {
        Cellule c = new Cellule(new Coordonee(134, 99), false);
        assertEquals(134, c.getCoordonneeX());
    }

    @Test
    public void test2GetCoordonneesX() {
        Cellule c = new Cellule(new Coordonee(134, 99), false);
        assertNotEquals(133, c.getCoordonneeX());
    }

    @Test
    public void test1GetCoordonneesY() {
        Cellule c = new Cellule(new Coordonee(134, 99), false);
        assertEquals(99, c.getCoordonneeY());
    }

    @Test
    public void test2GetCoordonneesY() {
        Cellule c = new Cellule(new Coordonee(134, 99), false);
        assertNotEquals(100, c.getCoordonneeY());
    }
}
