package conway;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordonneeTest {

    @Test
    public void testGetX() {

        Coordonee c = new Coordonee(3, 4);
        assertEquals(3, c.getX());
    }

    @Test
    public void testGetY() {

        Coordonee c = new Coordonee(3, 4);
        assertEquals(4, c.getY());
    }
}


