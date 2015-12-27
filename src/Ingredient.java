/**
 * Created by zook on 12/26/15.
 */
public class Ingredient {
    private int quantity;
    private Unit unit;
    private String ingredient;
    public Ingredient(int quantity, Unit unit, String ingredient) {
        this.quantity = quantity;
        this.unit = unit;
        this.ingredient = ingredient;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getIngredient() {
        return ingredient;
    }
}
