package praktikum;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class IngredientTest {

    @Test
    public void testIngredientCreation() {
        Ingredient ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 150f);
        assertEquals("cutlet", ingredient.getName());
        assertEquals(IngredientType.FILLING, ingredient.getType());
        assertEquals(150f, ingredient.getPrice(), 0);
    }
}