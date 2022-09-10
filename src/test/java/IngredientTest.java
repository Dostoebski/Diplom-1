import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTest {

    private final IngredientType ingredientType;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType ingredientType, String name, float price) {
        this.ingredientType = ingredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {IngredientType.FILLING, "dinosour", 50.05f},
                {IngredientType.SAUCE, "cream", 40}
        };
    }
    // test for getPrice()
    @Test
    public void getPriceReturnsPrice() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(price, ingredient.getPrice(), 0);
    }
    // test for getName()
    @Test
    public void getNameReturnsName() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(name, ingredient.getName());
    }
    // two tests for getType() for different types
    @Test
    public void getType() {
        Ingredient ingredient = new Ingredient(ingredientType, name, price);
        Assert.assertEquals(ingredientType, ingredient.getType());
    }
}
