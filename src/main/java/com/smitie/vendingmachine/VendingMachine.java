package com.smitie.vendingmachine;

import java.util.List;
import java.util.Map;

public class VendingMachine implements Selector {

    private final Inventory<Item> itemInventory = new Inventory<>();
    private final Inventory<Coin> coinInventory = new Inventory<>();

    private int totalSales;
    private int currentBalance;

    private Item currentItem;

    public VendingMachine() {
    }

    @Override
    public int checkPriceBtn(Item item) {
        return 0;
    }

    @Override
    public void insertCoinBtn(Coin coin) {

    }

    @Override
    public Map<Item, List<Coin>> buyBtn() {
        return null;
    }

    @Override
    public List<Coin> refundBtn() {
        return null;
    }

    @Override
    public void resetBtn() {

    }

    private void initMachine() {
        System.out.println("Initializing vending machine with coin and items..");
    }

    private Item collectItem() {
        return null;
    }

    private List<Coin> collectChange() {
        return null;
    }

    private boolean isFullPaid() {
        return false;
    }

    private List<Coin> getChange(int amount) {
        return null;
    }

    private boolean hasSufficientChange() {
        return false;
    }

    private boolean hasSufficientChangeForAmount(long amount) {
        return false;
    }

    private void updateCoinInventory(List<Coin> coins) {
    }

    private void updateItemInventory(List<Item> items) {
    }


    protected int getTotalSales() {
        return totalSales;
    }

    protected int getCurrentBalance() {
        return currentBalance;
    }

}
