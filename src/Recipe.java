import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zook on 12/26/15.
 */
public class Recipe {
    private String name;
    List<Ingredient> ingredients = new ArrayList<>();

    public Recipe(String name) {
        this.name = name;
    }

    public void addIngredient(int quantity, Unit unit, String ingredient) {
        ingredients.add(new Ingredient(quantity, unit, ingredient));
    }

    public String getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
