import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;

@RunWith(Parameterized.class)
public class BunTest {

    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"red bun", 120},
                {"black bun", 144.5f}
        };
    }

    @Test
    public void getNameReturnActualName() {
        Bun bun = new Bun(name, price);
        String returnedName = bun.getName();
        Assert.assertEquals(name, returnedName);
    }

    @Test
    public void getPriceReturnActualPrice() {
        Bun bun = new Bun(name, price);
        float returnedPrice = bun.getPrice();
        Assert.assertEquals(price, returnedPrice, 0);
    }
}
