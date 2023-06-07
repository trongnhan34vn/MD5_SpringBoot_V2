package com.example.md5_ss10_baitap_giohang.controller;

import com.example.md5_ss10_baitap_giohang.model.Cart;
import com.example.md5_ss10_baitap_giohang.model.Product;
import com.example.md5_ss10_baitap_giohang.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@SessionAttributes("cart")
public class ProductController {
    @Autowired
    private IProductService productService;
    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("product", new Product());
        return "/addProd";
    }

    @PostMapping("/create")
    public String createNewProduct(@ModelAttribute Product product, Model model) {
        productService.save(product);
        model.addAttribute("message", "Create Product Success!");
        return "/addProd";
    }

    @ModelAttribute("cart")
    public Cart setupCart() {
        return new Cart();
    }

    @GetMapping
    public String show(Model model) {
        model.addAttribute("listProducts", productService.findAll());
        return "/index";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam ("id") Long id, @ModelAttribute Cart cart) {
        cart.addProduct(productService.findById(id).get());
        return "redirect:/";
    }

    @GetMapping("/add")
    public String add(@RequestParam Long id, @ModelAttribute Cart cart, @RequestParam String action) {
        if (action.equals("increase")) {
            cart.addProduct(productService.findById(id).get());
        } else {
            cart.removeProduct(productService.findById(id).get());
        }
        return "redirect:/shopping-cart";
    }
}
