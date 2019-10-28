package jp.co.systena.tigerscave.shopping.application;

public class Order {

  private int itemId;
  private int num;

  public Order(int itemId, int num) {
	  this.itemId = itemId;
	  this.num = num;
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

}


