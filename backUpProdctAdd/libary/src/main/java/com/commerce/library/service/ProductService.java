package com.commerce.library.service;

import com.commerce.library.dao.ProductDao;
import com.commerce.library.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {

    List<ProductDao> findAll();
    Product save(MultipartFile multipartFile, ProductDao productDao);
    Product update(ProductDao productDao);
    void deleteById(Long id);
    void enableById(Long id);
}
