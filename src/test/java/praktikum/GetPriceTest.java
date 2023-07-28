package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class GetPriceTest {
    float bunPrice;
    float mockIngredient1rename;
    float mockIngredient2rename;
    float expectedPrice;

    public GetPriceTest(float bunPrice, float mockIngredient1rename, float mockIngredient2rename, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.mockIngredient1rename = mockIngredient1rename;
        this.mockIngredient2rename = mockIngredient2rename;
        this.expectedPrice = expectedPrice;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][] {
                { 10f, 5f, 7f, 32f},
                { 0f, 0f, 0f, 0f},
                { 20.22f, 10.55f, 6.89f, 57.879997f}
        };
    }

    @Test
    public void shouldGetPricePositiveCheckPrice(){
        Burger burger = new Burger();
        Bun mockBun = Mockito.mock(Bun.class);
        Ingredient mockIngredient1 = Mockito.mock(Ingredient.class);
        Ingredient mockIngredient2 = Mockito.mock(Ingredient.class);
        burger.setBuns(mockBun);
        burger.addIngredient(mockIngredient1);
        burger.addIngredient(mockIngredient2);

        Mockito.when(mockBun.getPrice()).thenReturn(bunPrice);
        Mockito.when(mockIngredient1.getPrice()).thenReturn(mockIngredient1rename);
        Mockito.when(mockIngredient2.getPrice()).thenReturn(mockIngredient2rename);

        assertEquals("Сумма ингредиентов не совпадает", expectedPrice, burger.getPrice(), 0);
    }
}
