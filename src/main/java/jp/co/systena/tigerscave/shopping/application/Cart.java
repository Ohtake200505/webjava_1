package jp.co.systena.tigerscave.shopping.application;

import java.util.ArrayList;
import java.util.List;

public class Cart {

  private List<Order> orderList = new ArrayList<Order>();
  private int totalPrice = 0;

  public void addOrder(Order order) {

	  boolean process = false;

	  if(orderList != null) {
		  for(Order existOrder : orderList) {
			  if(existOrder.getItemId() == order.getItemId()){
				  existOrder.setNum(existOrder.getNum() + order.getNum());
				  process = true;
			  }
		  }
	  }

	  if(process == false) {
		  orderList.add(order);
	  }
  }

  public List getOrderList() {
	  return this.orderList;
  }

  public void setTotalPrice(int price){
	  totalPrice = price;
  }

  public int getTotalPrice() {
	  return this.totalPrice;
  }

  public int operateTotalPrice() {

	  if(orderList != null) {
		  for(Order orders : orderList) {
			  totalPrice += orders.getPrice()*orders.getNum();
		  }
		  return totalPrice;
	  }else {
		  return 0;
	  }

  }

  public void deleteOrder(int itemId) {

    for(int i=0; i<orderList.size(); i++) {
      if(orderList.get(i).getItemId() == itemId){
          orderList.remove(i);
      }
    }
  }

}


