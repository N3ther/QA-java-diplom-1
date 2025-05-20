package praktikum;

import static org.junit.Assert.*;
import org.junit.Test;


public class IngredientTypeTest {

    @Test
    public void testSauceType() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void testFillingType() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

}