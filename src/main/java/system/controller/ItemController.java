package system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import system.model.*;
import system.service.CartListService;
import system.service.ItemInOrderService;
import system.service.ItemService;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes("cart")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @Autowired
    private CartListService cartListService;

    @Autowired
    private ItemInOrderService itemInOrderService;

    @ModelAttribute("cart")
    public Cart newCart(){
        return new Cart();
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public ModelAndView getItemList(@ModelAttribute("cart") Cart cart){
        ModelAndView modelAndView = new ModelAndView();
        List<Item> itemList = itemService.getItemList();
        modelAndView.addObject("itemList", itemList);
        modelAndView.addObject("cart", cart);
        System.out.println("home page price " + cart.getTotalPrice() + " home page quantity " + cart.getTotalQuantity());
        modelAndView.setViewName("home");
        return modelAndView;
    }

    @RequestMapping(value = "/addtocart", method = RequestMethod.GET, produces="application/json")
    public @ResponseBody Cart  getMyCart (@RequestParam(value = "id", required = false) int id,
                                          @RequestParam(value ="price", required = false) int price,
                                          @RequestParam(value = "quantity", required = false) int quantity,
                                          @ModelAttribute("cart") Cart cart) {

        Item item = itemService.getItemById(id);
        ItemInCart itemInCart = new ItemInCart(id, item.getCode(), item.getName(), price, quantity, price*quantity);
        cart.addItem(itemInCart);
        System.out.println("item " +item);
        return cart;

    }

    @RequestMapping(value = "/cleancart", method = RequestMethod.GET)
    public @ResponseBody Cart cleanCart (@ModelAttribute("cart") Cart cart,
                                         HttpSession session, SessionStatus status) {
        status.setComplete();
         return new Cart();
    }

    @RequestMapping(value = "/savecart", method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
    public @ResponseBody String saveCart(@ModelAttribute("cart") Cart cart) {

        int cartNumber ;
        cartNumber = cartListService.getLastId();
        cartNumber++;
        CartList cartList = new CartList();
        cartList.setName("Корзина " + cartNumber);
        cartListService.addCart(cartList);

        for (ItemInCart obj: cart.getOrder()){
            ItemInOrder itemInOrder = new ItemInOrder(cartNumber, obj.getId(), obj.getQuantity(), obj.getTotal());
            itemInOrderService.addtoDb(itemInOrder);
        }


        return "Заказ добавлен в базу данных. Номер заказа " + cartNumber;
    }


}
