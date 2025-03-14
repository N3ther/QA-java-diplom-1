package praktikum;

import static org.junit.Assert.*;
import org.junit.Test;


public class BunTest {

    @Test
    public void testBunCreation() {
        Bun bun = new Bun("black bun", 100f);
        assertEquals("black bun", bun.getName());
        assertEquals(100f, bun.getPrice(), 0);
    }
}