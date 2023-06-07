package com.example.md5_ss10_baitap_giohang.model;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> products = new HashMap<>();

    public Cart() {
    }

    public Cart(Map<Product, Integer> products) {
        this.products = products;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }

    private boolean checkItemInCart(Product product) {
        for (Map.Entry<Product, Integer> entry: products.entrySet()) {
            if(entry.getKey().getProductId().equals(product.getProductId())) {
                return true;
            }
        }
        return false;
    }

    private Map.Entry<Product,Integer> selectItem(Product product) {
        for (Map.Entry<Product, Integer> entry: products.entrySet()) {
            if(entry.getKey().getProductId().equals(product.getProductId())) {
                return entry;
            }
        }
        return null;
    }

//  Thêm sản phẩm vào giỏ hàng

    public void addProduct(Product product) {
        if (!checkItemInCart(product)) {
//            nếu sản phẩm chưa tồn tại trong giỏ hàng
            products.put(product, 1);
        } else {
//            nếu sản phẩm đã tồn tại trong giỏ hàng
//            trường hợp chỉ thêm được 1 sản phẩm vào giỏ hàng
            Map.Entry<Product,Integer> item = selectItem(product);
            Integer newQuantity = item.getValue() + 1;
            products.replace(item.getKey(), newQuantity);
        }
    }

//    Xoá sản phẩm
    public void removeProduct(Product product){
        if (!checkItemInCart(product)){
            products.put(product,1);
        } else {
            Map.Entry<Product, Integer> itemEntry = selectItem(product);
            Integer newQuantity = itemEntry.getValue() - 1;
            if(itemEntry.getValue()==0){
                newQuantity=0;
            }
            products.replace(itemEntry.getKey(),newQuantity);
        }
    }


    public Integer countProductQuantity(){
        Integer productQuantity = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productQuantity += entry.getValue();
        }
        return productQuantity;
    }

    public Integer countItemQuantity(){
        return products.size();
    }

    public Float countTotalPayment(){
        float payment = 0;
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            payment += entry.getKey().getPrice() * (float) entry.getValue();
        }
        return payment;
    }
}
