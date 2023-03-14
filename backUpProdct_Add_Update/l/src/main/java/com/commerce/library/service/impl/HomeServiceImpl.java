package com.commerce.library.service.impl;

import com.commerce.library.dao.ProductDao;
import com.commerce.library.model.Product;
import com.commerce.library.repository.ProductRepository;
import com.commerce.library.service.HomeService;
import com.commerce.library.utils.ImageUpload;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class HomeServiceImpl implements HomeService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ImageUpload imageUpload;

    @Override
    public List<ProductDao> findAll() {
        List<ProductDao> productDaoList = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            ProductDao productDao = new ProductDao();
            productDao.setId(product.getId());
            productDao.setName(product.getName());
            productDao.setDescription(product.getDescription());
            productDao.setSalePrice(product.getSalePrice());
            productDao.setCurrentQuantity(product.getCurrentQuantity());
            productDao.setCategory(product.getCategory());
            productDao.setImage(product.getImage());
            productDao.setActivated(product.is_activated());

        }
        return productDaoList;

    }

    @Override
    public ProductDao getByID(Long id) {
        return null;
    }


    @Override
    public List<Product> searchHome(String keyword) {
        return productRepository.searchHome(keyword);
    }
    @Override
    public List<ProductDao> showProducts() {
        List<ProductDao> productDaoList = new ArrayList<>();

        List<Product> products = productRepository.showProducts();
        for (Product product : products) {
            ProductDao productDao = new ProductDao();
            productDao.setId(product.getId());
            productDao.setName(product.getName());
            productDao.setDescription(product.getDescription());
            productDao.setSalePrice(product.getSalePrice());
            productDao.setCurrentQuantity(product.getCurrentQuantity());
            productDao.setCategory(product.getCategory());
            productDao.setImage(product.getImage());
            productDao.setActivated(product.is_activated());

        }
        return productDaoList;

    }



}
