package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

public class IngredientTypeTest {

    @Test
    public void values() {
        IngredientType[] expectedList = {SAUCE, FILLING};
        assertArrayEquals("Значения типов не совпадают", expectedList, IngredientType.values());
    }
}