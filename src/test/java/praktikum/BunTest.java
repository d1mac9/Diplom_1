package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {
    private final Bun bun = new Bun("Name", 10.25f);

    @Test
    public void shouldGetNameReturnCorrectValueNameField() {
        assertEquals("Имя не совпадает", "Name", bun.getName());
    }

    @Test
    public void shouldGetPriceReturnCorrectValuePriceField() {
        assertEquals("Цена не совпадает", 10.25f, bun.getPrice(), 0);
    }
}