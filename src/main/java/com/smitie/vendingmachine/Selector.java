package com.smitie.vendingmachine;

import java.util.List;
import java.util.Map;

public interface Selector {

    int checkPriceBtn(Item item);
    void insertCoinBtn(Coin coin);
    Map<Item, List<Coin>> buyBtn();

    List<Coin> refundBtn();
    void resetBtn();

}
