package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.Cart;
import com.niit.model.CartIteam;
import com.niit.model.Customer;
import com.niit.model.Product;
import com.niit.service.CartIteamService;
import com.niit.service.CustomerService;
import com.niit.service.ProductService;

@Controller
public class CartItemController {
	
	@Autowired
	private CartIteamService cartItemService;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private ProductService productService;
	
	public  CartItemController()
	{
	System.out.println("construct cartiteam controller");
	}
	
	
	
@RequestMapping("cart/addCartItem/{pid}")
public void addCartItem(@RequestParam(value="pid") String pId){
	
	System.out.println("product id----------------------------------->"+pId);
	//String p=productId;
	
	//int pid;
	//pid=Integer.parseInt(p);
	System.out.println("product id----------------------------------->"+pId);
	User user=
			(User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	
	String username=user.getUsername();
	Customer customer=customerService.getCustomerByUsername(username);//from Users where username=?
	Cart cart=customer.getCart();
	List<CartIteam> cartItems= cart.getCartItems();
	
	Product  product = productService.getProductById(pId);
	
	for (int i = 0; i <cartItems.size(); i++) {
		CartIteam cartItem=cartItems.get(i);
		Product p=cartItem.getProduct();
		     //1    ==  1
		if(p.getId()==pId){
			cartItem.setQuantity(cartItem.getQuantity() + 1);//increment the quantity
			cartItem.setTotalPrice(cartItem.getQuantity() * p.getPrice()); //update the total price
			cartItemService.addCartItem(cartItem);//update the quantity in the cartitem
			return;
		}	
	}
	
	CartIteam cartItem=new CartIteam();
	cartItem.setQuantity(1);
	cartItem.setTotalPrice(cartItem.getQuantity() * product.getPrice());
	cartItem.setProduct(product); //set product id
	cartItem.setCart(cart);//set cart id
	cartItemService.addCartItem(cartItem); //insert query	
}
}