import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    // test for setBuns()
    @Test
    public void setBunsBunObjectSucceed() {
        Burger burger = new Burger();

        burger.setBuns(bun);
        Assert.assertNotNull(burger.bun);
    }

    // test for addIngredient()
    @Test
    public void addIngredientAddsElementToIngredientsList() {
        Burger burger = new Burger();
        Assert.assertTrue(burger.ingredients.isEmpty());
        int ingredientsNumber = 1;

        burger.addIngredient(ingredient);
        Assert.assertEquals(ingredientsNumber, burger.ingredients.size());
    }

    // test for removeIngredient()
    @Test
    public void removeIngredientIndexInBoundsRemovesElementFromIngredientsList() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        int index = burger.ingredients.indexOf(ingredient);

        burger.removeIngredient(index);
        Assert.assertFalse(burger.ingredients.contains(ingredient));
    }

    // test for moveIngredient()
    @Test
    public void moveIngredientInsertsElementAtSpecifiedPosition() {
        Ingredient secondIngredient = Mockito.mock(Ingredient.class);
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(secondIngredient);

        burger.moveIngredient(1, 0);
        Assert.assertEquals(secondIngredient, burger.ingredients.get(0));
    }

    // test for getPrice()
    @Test
    public void getPriceTwoIngredientsReturnsTotalPrice() {
        float bunPrice = 50.05f;
        float ingredientPrice = 40.17f;

        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);

        float expectedPrice = (bunPrice * 2) + ingredientPrice + ingredientPrice;
        Assert.assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    // test for getReceipt()
    @Test
    public void getReceiptTwoIngredientsReturnsReceiptString() {
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);

        Mockito.when(bun.getName()).thenReturn("black bun");
        Mockito.when(ingredient.getType()).thenReturn(IngredientType.FILLING);
        Mockito.when(ingredient.getName()).thenReturn("dinosaur");

        String expectedReceipt = "(==== black bun ====)\r\n" +
                                 "= filling dinosaur =\r\n" +
                                 "= filling dinosaur =\r\n" +
                                 "(==== black bun ====)\r\n" +
                                 "\r\nPrice: 0,000000\r\n";

        Assert.assertEquals(expectedReceipt, burger.getReceipt());
    }
}
