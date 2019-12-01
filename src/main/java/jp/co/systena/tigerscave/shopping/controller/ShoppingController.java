package jp.co.systena.tigerscave.shopping.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.shopping.model.Cart;
import jp.co.systena.tigerscave.shopping.model.DeleteForm;
import jp.co.systena.tigerscave.shopping.model.ListForm;
import jp.co.systena.tigerscave.shopping.model.Order;
import jp.co.systena.tigerscave.shopping.service.ListService;

@Controller
public class ShoppingController {

  @Autowired
  HttpSession session;

  ListService listService = new ListService();


  @RequestMapping(value = "/Shopping", method = RequestMethod.GET)
  public ModelAndView list(ModelAndView mav) {

    mav.addObject("itemList", listService.getItemList());
    mav.setViewName("ListView");

    return mav;
  }

  @RequestMapping(value = "/AddOrder", method = RequestMethod.POST)
  public ModelAndView order(HttpSession session, ModelAndView mav, @Valid ListForm listForm) {

    Cart cart = getCart();

    int itemId = listForm.getItemId();
    int num = listForm.getNum();
    int price = listForm.getPrice();

    Order order = new Order(itemId, num, price);
    cart.addOrder(order);
    cart.setTotalPrice(0);

    int totalPrice = cart.getTotalPrice();

    session.setAttribute("cart", cart);
    mav.addObject("itemList", listService.getItemList());
    mav.addObject("cart", cart);
    mav.addObject("totalPrice", totalPrice);
    mav.setViewName("CartView");

    return mav;
  }

  @RequestMapping(value = "/DeleteOrder", method = RequestMethod.POST)
  public ModelAndView deleteOrder(HttpSession session, ModelAndView mav, @Valid DeleteForm deleteForm) {

    Cart cart = getCart();

    int itemId = deleteForm.getItemId();

    cart.deleteOrder(itemId);
    cart.setTotalPrice(0);
    int totalPrice = cart.getTotalPrice();

    session.setAttribute("cart", cart);
    mav.addObject("itemList", listService.getItemList());
    mav.addObject("cart", cart);
    mav.addObject("totalPrice", totalPrice);
    mav.setViewName("cartView");

    return mav;
  }

  public Cart getCart() {
    Cart cart = (Cart) session.getAttribute("cart");

    if (cart == null) {
      cart = new Cart();
      session.setAttribute("cart", cart);
    }

    return cart;

  }


}


