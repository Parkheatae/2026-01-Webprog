package kr.hnu.ice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ProductService {
    private HashMap<String, Product> products;

    // 기본 생성자 - Product 객체 5개 생성
    public ProductService() {
        products = new HashMap<>();

        // 삼성 휴대폰
        products.put("samsung_galaxy_s24", new Product("samsung_galaxy_s24", "Galaxy S24", "Samsung", 1200000, "2024-01-15"));

        // 애플 휴대폰
        products.put("apple_iphone15", new Product("apple_iphone15", "iPhone 15", "Apple", 1500000, "2023-09-15"));

        // LG 휴대폰
        products.put("lg_velvet", new Product("lg_velvet", "LG Velvet", "LG", 800000, "2020-05-15"));

        // 샤오미 휴대폰
        products.put("xiaomi_mi13", new Product("xiaomi_mi13", "Xiaomi Mi 13", "Xiaomi", 900000, "2023-12-01"));

        // 구글 휴대폰
        products.put("google_pixel8", new Product("google_pixel8", "Google Pixel 8", "Google", 1100000, "2023-10-12"));
    }

    // 모든 Product 리스트 반환
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    // ID로 특정 Product 찾기
    public Product find(String id) {
        return products.get(id);
    }
}