package jp.co.systena.tigerscave.shopping.application.controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.co.systena.tigerscave.shopping.application.Cart;
import jp.co.systena.tigerscave.shopping.application.ListForm;
import jp.co.systena.tigerscave.shopping.application.ListService;
import jp.co.systena.tigerscave.shopping.application.Order;

@Controller
public class ShoppingController {

  @Autowired
  HttpSession session;

  ListService listService = new ListService();
  ListForm listForm = new ListForm();
  Cart cart = new Cart();


  @RequestMapping("/Shopping")
//  public String list(Model model) {
  public ModelAndView list(ModelAndView mav) {

//    model.addAttribute("itemList", listService.getItemList());
//    model.addAttribute("listForm", listForm);
    mav.addObject("itemList", listService.getItemList());
    mav.addObject("listForm", listForm);
    mav.setViewName("ListView");

//    return "ListView";
    return mav;
  }

  @RequestMapping(value = "/order", method = RequestMethod.POST)
//  public String oder(HttpSession session, Model model, @Valid ListForm listForm) {
  public ModelAndView oder(HttpSession session, ModelAndView mav, @Valid ListForm listForm) {

//    model.addAttribute("itemList", listService.getItemList());
    mav.addObject("itemList", listService.getItemList());

    int itemId = listForm.getItemId();
    int num = listForm.getNum();

    Order order = new Order(itemId, num);
    cart.addOrder(order);
    cart.setTotalPrice(0);
    session.setAttribute("cart", cart);

    Cart cartSession = (Cart)session.getAttribute("cart");
//    model.addAttribute("cart", cartSession);
    mav.addObject("cart", cartSession);

    mav.setViewName("cartView");

//    return "cartView";
    return mav;
  }

}


