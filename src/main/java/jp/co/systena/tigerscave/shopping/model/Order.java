package jp.co.systena.tigerscave.shopping.model;

public class Order {

  private int itemId;
  private int num;
  private int price;

  public Order(int itemId, int num, int price) {
	  this.itemId = itemId;
	  this.num = num;
	  this.price = price;
  }

  public int getItemId(){
	  return itemId;
  }

  public void setItemId(int itemId){
	  this.itemId = itemId;
  }

  public int getNum(){
	  return num;
  }

  public void setNum(int num){
	  this.num = num;
  }

  public int getPrice(){
	  return price;
  }

  public void setPrice(int price){
	  this.price = price;
  }

}


