package com.ecommerce.admin.controller;

import com.commerce.library.dao.ProductDao;
import com.commerce.library.model.Category;
import com.commerce.library.model.Product;
import com.commerce.library.service.CategoryService;
import com.commerce.library.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.method.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/products")
    public String products(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        List<ProductDao> productDaoList = productService.findAll();
        model.addAttribute("title","Manage Product");
        model.addAttribute("products", productDaoList);
        model.addAttribute("size", productDaoList.size());
        return "products";
    }

    @GetMapping("/add-product")
    public String addProductFrom(Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        List<Category> categories = categoryService.findAllByActivated();
        model.addAttribute("categories", categories);
        model.addAttribute("product", new ProductDao());
        return "add-product";
    }

    @PostMapping("/save-product")
    public String saveProduct(@ModelAttribute("product")ProductDao productDao,
                              @RequestParam("imageProduct")MultipartFile imageProduct,
                              RedirectAttributes attributes){
        try{
            productService.save(imageProduct, productDao);
            attributes.addFlashAttribute("success", "Product add successfully!");
        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("error","Failed to add");
        }
        return "redirect:/products";
    }

    @GetMapping("/update-product/{id}")
    public String updateProductForm(@PathVariable("id") Long id, Model model, Principal principal){
        if(principal == null){
            return "redirect:/login";
        }
        model.addAttribute("title", "Update products");
        List<Category> categories = categoryService.findAllByActivated();
        ProductDao productDao = productService.getByID(id);
        model.addAttribute("categories",categories);
        model.addAttribute("productDao", productDao);
        return "update-product";
    }

    @PostMapping("/update-product/{id}")
    public String processUpdate(@PathVariable("id")Long id,
                                @ModelAttribute("productDao") ProductDao productDao,
                                @RequestParam("imageProduct") MultipartFile imageProuct,
                                RedirectAttributes attributes
                                ){
        try{
            productService.update(imageProuct,productDao);
            attributes.addFlashAttribute("success", "Update successfully!");

        }catch (Exception e){
            e.printStackTrace();
            attributes.addFlashAttribute("error","Filed to update");
        }
        return "redirect:/products";
    }


}










