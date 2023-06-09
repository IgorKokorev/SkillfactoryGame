package game.merchant;

import game.characters.Hero;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Scanner;

@Data
@AllArgsConstructor
public class Shop {
    Merchant merchant;
    Hero hero;

    public void startTrading() {

        System.out.println("\nMerchant: Welcome to our blessed shop, weary traveler!");
        System.out.println("Merchant: We have everything you need to replenish your strength.");
        menu();
        System.out.println("Merchant: Thank you for visiting us, hope to see you soon!");
    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("\nMerchant: What do you wish to obtain?");
            for (int i = 0; i < merchant.getListOfGoods().size(); i++) {
                System.out.println((i + 1) + ". " + merchant.getListOfGoods().get(i));
            }
            System.out.println((merchant.getListOfGoods().size() + 1) + ". Exit");

            String inp = scanner.nextLine();

            int choice;

            try {
                choice = Integer.parseInt(inp);
            } catch (NumberFormatException e) {
                System.out.println("Merchant: Sorry, traveler, I'm too old and my ears are failing me. Could you repeat please.");
                continue;
            }

            if (choice < 1 || choice > (merchant.getListOfGoods().size() + 1)) {
                System.out.println("Merchant: Sorry, traveler, I'm too old and my ears are failing me. Could you repeat please.");
                continue;
            }

            if (choice == (merchant.getListOfGoods().size() + 1)) break;

            buy(merchant.getListOfGoods().get(choice - 1));

        } while (true);
    }

    // return true if the purchase is successfull
    private boolean buy(Good good) {
        if (hero.getGold() < good.getPrice()) {
            System.out.println("Merchant: Sorry, traveler, it's too expensive for you.");
            return false;
        }

        switch (good.getType()) {
            case HP_ELIXIR -> {
                hero.setHp(hero.getCurrentHp() + good.getQuantity());
            }
            case EXP_POTION -> {
                hero.setExp(hero.getExp() + good.getQuantity());
            }
        }

        hero.setGold(hero.getGold() - good.getPrice());
        merchant.setGold(merchant.getGold() + good.getPrice());

        System.out.println("Merchant: It's a very good buy!");

        return true;
    }
}
