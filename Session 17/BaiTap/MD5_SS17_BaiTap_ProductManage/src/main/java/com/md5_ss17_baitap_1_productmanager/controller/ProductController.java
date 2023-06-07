package com.md5_ss17_baitap_1_productmanager.controller;

import com.md5_ss17_baitap_1_productmanager.model.Product;
import com.md5_ss17_baitap_1_productmanager.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/")
public class ProductController {
    @Autowired
    IProductService productService;

    @GetMapping
    public ResponseEntity<?> listProduct() {
        return new ResponseEntity<>(productService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<?> createProduct(@RequestBody Product newProduct) {
        productService.save(newProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Product> selectProduct = productService.findById(id);
        if (!selectProduct.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(selectProduct,HttpStatus.OK);
    }

    @PutMapping ("/edit")
    public ResponseEntity<?> updateProduct(@RequestBody Product newProduct) {
        productService.save(newProduct);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        productService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
