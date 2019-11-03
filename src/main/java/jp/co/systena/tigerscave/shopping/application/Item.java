package jp.co.systena.tigerscave.shopping.application;

public class Item {

  private int itemId;
  private String name;
  private int price;

  public Item(int itemId, String name, int price) {
    this.itemId = itemId;
    this.name = name;
    this.price = price;
  }

  public int getItemId(){
    return itemId;
  }

   public void setItemId(int itemId){
     this.itemId = itemId;
   }

   public String getName(){
     return name;
   }

   public void setName(String name){
     this.name = name;
   }

   public int getPrice(){
     return price;
   }

   public void setPrice(int price){
     this.price = price;
   }
}


