package vendingmachine;

import vendingmachine.coin.CoinExchangeMachine;
import vendingmachine.coin.Coins;
import vendingmachine.dto.servicedto.ItemsInventoryInfo;
import vendingmachine.item.ItemFactory;
import vendingmachine.item.Items;

public class VendingMachineService {
    private final CoinExchangeMachine coinExchangeMachine = new CoinExchangeMachine();
    private final ItemFactory itemFactory = new ItemFactory();
    private VendingMachine vendingMachine;

    public void createVendingMachine() {
        this.vendingMachine = new VendingMachine();
    }

    public Coins createCoinBalance(int coinBalance) {
        return vendingMachine.depositCoinBalance(coinExchangeMachine.changeIntoCoins(coinBalance));
    }

    public Items createItems(ItemsInventoryInfo inputItemInventoryInfo) {
        return vendingMachine.storeItems(itemFactory.createByInventoryList(inputItemInventoryInfo));
    }

    public VendingMachine getVendingMachine() {
        return vendingMachine;
    }
}
