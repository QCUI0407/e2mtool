package com.ecommerce.admin.controller;


import com.commerce.library.dao.ProductDao;
import com.commerce.library.model.Product;
import com.commerce.library.repository.ProductRepository;
import com.commerce.library.service.CategoryService;
import com.commerce.library.service.HomeService;
import com.commerce.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

//    @Autowired
//    private HomeService homeService;

    @GetMapping ( "/")

    public String home(Model model){
//        List<ProductDao> productDaoList = productService.findAll();
        List<Product> productDaoList = productService.showProducts();
        model.addAttribute("title","Manage Product");
        model.addAttribute("products", productDaoList);
        model.addAttribute("size", productDaoList.size());
        return "home";
    }

    @GetMapping("/contact")
    public String contact(){
     return "contact";
    }

    @GetMapping("/home-search")
    public String searchHome(@RequestParam("keyword")String keyword, Model model){

        List<Product> products = productService.searchHome(keyword);
        model.addAttribute("title","Search Result");
        model.addAttribute("products",products);
        model.addAttribute("size",products.size());
        System.out.println(products);
        return "search-home";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
