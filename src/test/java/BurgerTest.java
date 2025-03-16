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

    @Mock
    private Ingredient ingredientMock1;

    @Mock
    private Ingredient ingredientMock2;

    @InjectMocks
    private Burger burger;

    @Before
    public void setUp() {
        when(bunMock.getName()).thenReturn("black bun");
        when(bunMock.getPrice()).thenReturn(100f);

        when(ingredientMock1.getType()).thenReturn(IngredientType.FILLING);
        when(ingredientMock1.getName()).thenReturn("cutlet");
        when(ingredientMock1.getPrice()).thenReturn(100f);

        when(ingredientMock2.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredientMock2.getName()).thenReturn("hot sauce");
        when(ingredientMock2.getPrice()).thenReturn(50f);
    }

    @Test
    public void testSetBuns() {
        burger.setBuns(bunMock);
        assertEquals(bunMock, burger.bun);
    }

    @Test
    public void testAddIngredient() {
        burger.addIngredient(ingredientMock1);
        assertTrue(burger.ingredients.contains(ingredientMock1));
    }

    @Test
    public void testRemoveIngredient() {
        burger.addIngredient(ingredientMock1);
        burger.removeIngredient(0);
        assertFalse(burger.ingredients.contains(ingredientMock1));
    }

    @Test
    public void testMoveIngredient() {
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);
        burger.moveIngredient(0, 1);
        assertEquals(ingredientMock1, burger.ingredients.get(1));
    }

    @Test
    public void testGetPrice() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        float expectedPrice = (bunMock.getPrice() * 2) +
                ingredientMock1.getPrice() +
                ingredientMock2.getPrice();

        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void testGetReceipt() {
        burger.setBuns(bunMock);
        burger.addIngredient(ingredientMock1);
        burger.addIngredient(ingredientMock2);

        String expectedReceipt = "(==== black bun ====)\n" +
                "= filling cutlet =\n" +
                "= sauce hot sauce =\n" +
                "(==== black bun ====)\n\n" +
                "Price: 350.0\n";

        assertEquals(expectedReceipt, burger.getReceipt());
    }

}