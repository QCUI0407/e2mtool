package com.commerce.library.service;

import com.commerce.library.dao.ProductDao;
import com.commerce.library.model.Product;

import java.util.List;



public interface HomeService {
    List<ProductDao> findAll();

    ProductDao getByID(Long id);
    List<Product> searchHome(String keyword);

    List<ProductDao> showProducts();
}
