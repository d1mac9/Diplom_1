package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;
import static praktikum.IngredientType.SAUCE;

public class IngredientTest {
    private final Ingredient ingredient = new Ingredient(SAUCE,"Name", 10.2f);

    @Test
    public void shouldGetPriceReturnCorrectPrice() {
        assertEquals("Цена не совпадает", 10.2f, ingredient.getPrice(), 0);
    }

    @Test
    public void shouldGetNameReturnCorrectName() {
        assertEquals("Имя не совпадает", "Name", ingredient.getName());
    }

    @Test
    public void shouldGetTypeReturnCorrectType() {
        assertEquals("Тип ингредиента не совпадает", SAUCE, ingredient.getType());
    }
}