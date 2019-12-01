package jp.co.systena.tigerscave.shopping.service;

import java.util.HashMap;
import java.util.Map;

import jp.co.systena.tigerscave.shopping.model.Item;

public class ListService {
  Map<Integer, Item> itemList = new HashMap<>();

  public Map<Integer, Item> getItemList() {
    Item item1 = new Item(1,"首輪",3000);
    Item item2 = new Item(2,"リード",2000);
    Item item3 = new Item(3,"カリカリ",5000);

    itemList.put(1, item1);
    itemList.put(2, item2);
    itemList.put(3, item3);

    return itemList;
  }


}


