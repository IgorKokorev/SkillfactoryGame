package game.merchant;

import game.merchant.Good.GoodType;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Merchant {
    private int gold;
    private List<Good> listOfGoods = new ArrayList<>();
    public Merchant() {
        gold = 0;

        // filling the stock
        listOfGoods.add(new Good(GoodType.HP_ELIXIR, "Health elixir", 100, 100));
        listOfGoods.add(new Good(GoodType.HP_ELIXIR, "Health elixir", 500, 400));
        listOfGoods.add(new Good(GoodType.EXP_POTION, "Experience points", 10, 100));
        listOfGoods.add(new Good(GoodType.EXP_POTION, "Experience points", 50, 400));
    }

}
