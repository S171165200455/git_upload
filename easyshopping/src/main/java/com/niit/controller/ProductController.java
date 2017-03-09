package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.niit.model.Product;
import com.niit.service.CategoryService;
import com.niit.service.ProductService;

@Controller
public class ProductController {

@Autowired
private ProductService productService;
@Autowired
private CategoryService categoryService;	
	
public ProductController(){
	System.out.println("CREATING INSTANCE FOR PRODUCTCONTROLLER");
}

//http://localhost:8080/project1/admin/product/productform
@RequestMapping("/admin/product/productform")
public String getProductForm(Model model){
	System.out.println("aminside getAllProducts");
	
		model.addAttribute("product",new Product());
		System.out.println("hai222");
	model.addAttribute("categories",categoryService.getCategories());
	return "productform";
}

@RequestMapping("/admin/product/addProduct")
public String saveProduct(
	@Valid  @ModelAttribute(value="product") Product product,BindingResult result,Model model){
	System.out.println("aminside addProduct");
	if(result.hasErrors())
	{
		return"productform";
	}
		String path = "D:\\ecommerce\\easyshopping\\src\\main\\webapp\\WEB-INF\\resources\\images\\";
	productService.saveProduct(product);
	System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
	path=path+String.valueOf(product.getId())+".png";
	File f=new File(path);
	MultipartFile filedet=product.getImage();
	if(!filedet.isEmpty())
	{
		try
		{
		  byte[] bytes=filedet.getBytes();
		  System.out.println(bytes.length);
		  FileOutputStream fos=new FileOutputStream(f);
      			BufferedOutputStream bs=new BufferedOutputStream(fos);
      			bs.write(bytes);
      			bs.close();
     			 System.out.println("File Uploaded Successfully");
		}
		catch(Exception e)
		{
			System.out.println("Exception Arised"+e);
		}
	}
	else
	{
		System.out.println("File is Empty not Uploaded");
		
}
       
	return "redirect:/all/product/getAllProducts";
}	




@RequestMapping("/all/product/getAllProducts")
public String getAllProducts(Model model){
	List<Product> products=productService.getAllProducts();
	System.out.println("aminside getAllProducts");
	//Assigning list of products to model attribute products
	model.addAttribute("productList",products);
	return "productlist";
}
@RequestMapping("/all/product/viewproduct/{id}")
public String viewProduct(@PathVariable String id,Model model){
	System.out.println("am inside viewproducts");
	System.out.println("id is --------------------->"+id);
	
	Product product=productService.getProductById(id);
	model.addAttribute("product",product);
return "viewproduct";
}

@RequestMapping("/admin/product/deleteproduct/{id}")
public String deleteProduct(@PathVariable String id){
	System.out.println("aminside deleteProducts");
	
	productService.deleteProduct(id);
	return "redirect:/all/product/getAllProducts";
}



@RequestMapping("/admin/product/editform/{id}")
public String editProductForm(@PathVariable String id,Model model){
	System.out.println("aminside editform");
	
	Product product=productService.getProductById(id);
	model.addAttribute("product",product);
	model.addAttribute("categories",categoryService.getCategories());
	return "editproductform";
}
@RequestMapping("/admin/product/editProduct")
public String editProductDetails(@Valid @ModelAttribute("product") Product product,
		BindingResult result){System.out.println("aminside editproduct");
		
	if(result.hasErrors())
		return "productform";
	productService.updateProduct(product);
	return "redirect:/all/product/getAllProducts";
		}

@RequestMapping("/all/product/productsByCategory")
public String getProductsByCategory(@RequestParam(name="searchCondition") String searchCondition,
		Model model){
	System.out.println("aminside productbycategory");
	
	List<Product> products=productService.getAllProducts();
	//Assigning list of products to model attribute products
	model.addAttribute("productList",products);
	model.addAttribute("searchCondition",searchCondition);
	return "productlist";
}


}