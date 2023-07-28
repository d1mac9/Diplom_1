package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    private Bun bun;
    private Burger burger;
    private Ingredient expectedIngredient;
    @Mock
    private Bun mockBun;
    @Mock
    private Ingredient mockIngredient1;
    @Mock
    private Ingredient mockIngredient2;

    @Test
    public void shouldSetBunsSetCorrectNameField() {
        bun = new Bun("Name", 10.2f);
        burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Не совпадает имя", "Name", burger.bun.getName());
    }

    @Test
    public void shouldSetBunsSetCorrectFieldField() {
        bun = new Bun("Name", 10.2f);
        burger = new Burger();
        burger.setBuns(bun);
        assertEquals("Не совпадает цена", 10.2f, burger.bun.getPrice(), 0);
    }

    @Test
    public void shouldAddIngredient() {
        burger = new Burger();
        expectedIngredient = new Ingredient(SAUCE, "Name", 10.2f);
        burger.addIngredient(expectedIngredient);
        assertEquals("Ингредиент не добавлен", expectedIngredient, burger.ingredients.get(0));
    }

    @Test
    public void shouldRemoveIngredient() {
        burger = new Burger();
        expectedIngredient = new Ingredient(SAUCE, "Name", 10.2f);
        burger.addIngredient(expectedIngredient);
        burger.removeIngredient(0);

        assertTrue("Ингредиент не удален", burger.ingredients.isEmpty());
    }

    @Test
    public void shouldMoveIngredient() {
        burger = new Burger();
        Ingredient expectedIngredient1 = new Ingredient(SAUCE, "Name1", 10.2f);
        Ingredient expectedIngredient2 = new Ingredient(FILLING, "Name2", 11.2f);
        burger.addIngredient(expectedIngredient1);
        burger.addIngredient(expectedIngredient2);

        burger.moveIngredient(0, 1);
        List<Ingredient> expectedList = List.of(expectedIngredient2, expectedIngredient1);

        assertEquals("Порядок ингредиентов не совпадает", expectedList, burger.ingredients);
    }

    @Test
    public void shouldNotMoveIngredientWithTheSameIndex() {
        burger = new Burger();
        Ingredient expectedIngredient1 = new Ingredient(SAUCE, "Name1", 10.2f);
        Ingredient expectedIngredient2 = new Ingredient(FILLING, "Name2", 11.2f);

        burger.addIngredient(expectedIngredient1);
        burger.addIngredient(expectedIngredient2);
        burger.moveIngredient(0, 0);
        List<Ingredient> expectedList = List.of(expectedIngredient1, expectedIngredient2);

        assertEquals("Порядок ингредиентов не совпадает", expectedList, burger.ingredients);
    }

    @Test
    public void shouldInvokeMethodGetPrice1Time() {
        Burger burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        burger.getPrice();

        Mockito.verify(mockBun, Mockito.times(1)).getPrice();
        Mockito.verify(mockIngredient1, Mockito.times(1)).getPrice();
        Mockito.verify(mockIngredient2, Mockito.times(1)).getPrice();
    }

    @Test
    public void shouldGetReceiptCorrectView() {
        burger = new Burger();
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);

        Mockito.when(mockBun.getName()).thenReturn("MockBunName");
        Mockito.when(mockIngredient1.getType()).thenReturn(SAUCE);
        Mockito.when(mockIngredient1.getName()).thenReturn("MockIngredientName");
        Mockito.when(burger.getPrice()).thenReturn(10f);
        String expected = "(==== MockBunName ====)\r\n" +
                "= sauce MockIngredientName =\r\n" +
                "(==== MockBunName ====)\r\n" +
                "\r\n" +
                "Price: 10,000000\r\n";

        assertEquals("Строка не совпадает", expected, burger.getReceipt());
    }
}