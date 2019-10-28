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

  public int operateTotalPrice(int price) {
	  totalPrice += price;

	  return totalPrice;
  }
}


