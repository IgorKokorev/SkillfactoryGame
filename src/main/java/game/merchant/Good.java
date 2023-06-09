package game.merchant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@AllArgsConstructor
public class Good {
    public static enum GoodType { HP_ELIXIR, EXP_POTION }

    private GoodType type;
    private String name;
    private int quantity;
    private int price;

    @Override
    public String toString() {
        return name + ": quantity = " + quantity + ", price=" + price;
    }
}
