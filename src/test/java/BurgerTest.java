package praktikum;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;


@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    private Bun bunMock;

    @InjectMocks
    private Burger burger;

    @Before
    public void setUp() {
        // Setting up a mock bun
        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        Ingredient ingredientMock = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        burger.addIngredient(ingredientMock);
        assertTrue(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void testRemoveIngredient() {
        Ingredient ingredientMock = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        burger.addIngredient(ingredientMock);

        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredientMock));
    }

    @Test
    public void testMoveIngredient() {
        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        Ingredient ingredient2 = new Ingredient(IngredientType.FILLING, "sauce", 50f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.moveIngredient(0, 1); // move cutlet to index 1
        assertEquals(ingredient1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        bunMock = new Bun("black bun", 100f);
        burger.setBuns(bunMock);
        burger.addIngredient(new Ingredient(IngredientType.FILLING, "cutlet", 100f));
        burger.addIngredient(new Ingredient(IngredientType.SAUCE, "hot sauce", 50f));

        float expectedPrice = (bunMock.getPrice() * 2) + 100f + 50f;
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        bunMock = new Bun("black bun", 100f);
        burger.setBuns(bunMock);

        Ingredient ingredient1 = new Ingredient(IngredientType.FILLING, "cutlet", 100f);
        Ingredient ingredient2 = new Ingredient(IngredientType.SAUCE, "hot sauce", 50f);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        String expectedReceipt = "(==== black bun ====)\n= filling cutlet =\n= sauce hot sauce =\n(==== black bun ====)\n\nPrice: 350.0\n";
        assertEquals(expectedReceipt, burger.getReceipt());
    }

}