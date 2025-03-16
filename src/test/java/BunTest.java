package praktikum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BunTest {

    private static final String NAME = "black bun";
    private static final float PRICE = 100f;
    private Bun bun;

    @Before
    public void setUp() {
        bun = new Bun(NAME, PRICE);
    }

    @Test
    public void testBunName() {
        assertEquals(NAME, bun.getName());
    }

    @Test
    public void testBunPrice() {
        assertEquals(PRICE, bun.getPrice(), 0);
    }
}