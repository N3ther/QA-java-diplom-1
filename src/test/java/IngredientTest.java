package praktikum;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)

public class IngredientTest {
    private Ingredient ingredient;

    @Before
    public void setUp() {
        ingredient = new Ingredient(IngredientType.FILLING, "cutlet", 150f);
    }

    @Test
    public void testGetName() {
        assertEquals("cutlet", ingredient.getName());
    }

    @Test
    public void testGetType() {
        assertEquals(IngredientType.FILLING, ingredient.getType());
    }

    @Test
    public void testGetPrice() {
        assertEquals(150f, ingredient.getPrice(), 0);
    }
}