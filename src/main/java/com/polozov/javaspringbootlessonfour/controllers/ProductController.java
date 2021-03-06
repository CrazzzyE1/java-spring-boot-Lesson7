package com.polozov.javaspringbootlessonfour.controllers;

import com.polozov.javaspringbootlessonfour.entities.Product;
import com.polozov.javaspringbootlessonfour.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String indexPage(Model model, @RequestParam(name = "titleFilter", required = false) String titleFilter){
        if (titleFilter == null || titleFilter.isBlank()) {
            model.addAttribute("products", productService.getAllProduct());
        } else {
            model.addAttribute("products", productService.getByTitle(titleFilter));
        }
        return "product_views/index";
    }

    @GetMapping("/show")
    public String showMinMaxPrice(Model model, @RequestParam(name = "minPriceFilter", required = false) BigDecimal minPriceFilter,
                                               @RequestParam(name = "maxPriceFilter", required = false) BigDecimal maxPriceFilter){
        if(minPriceFilter == null && maxPriceFilter == null) {
            model.addAttribute("products", productService.getAllProduct());
        } else if (minPriceFilter == null) {
            model.addAttribute("products", productService.findProductByPriceBefore(maxPriceFilter));
        } else if (maxPriceFilter == null) {
            model.addAttribute("products", productService.findProductByPriceAfter(minPriceFilter));
        } else {
            model.addAttribute("products", productService.findProductByPriceBetween(minPriceFilter, maxPriceFilter));
        }
        return "product_views/index";
    }

    @GetMapping("/{id}")
    public String editProduct(@PathVariable(value = "id") Long id,
                              Model model) {
        model.addAttribute("product", productService.getById(id));
        return "product_views/product_form";
    }

    @PostMapping("/product_update")
    public String updateProduct(Product product) {
        productService.addOrUpdate(product);
        return "redirect:/product";
    }

    @GetMapping("/new")
    public String newProduct(Model model) {
        model.addAttribute(new Product());
        return "product_views/product_form";
    }

    @GetMapping("/delete/{id}")
    public String removeProduct(@PathVariable(value = "id") Long id) {
        productService.remove(id);
        return "redirect:/product";
    }
}
