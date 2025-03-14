package praktikum;

import static org.junit.Assert.*;
import org.junit.Test;


public class IngredientTypeTest {

    @Test
    public void testIngredientType() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

}