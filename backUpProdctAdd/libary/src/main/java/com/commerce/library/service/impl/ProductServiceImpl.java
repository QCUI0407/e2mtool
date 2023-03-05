package com.commerce.library.service.impl;

import com.commerce.library.dao.ProductDao;
import com.commerce.library.model.Product;
import com.commerce.library.repository.ProductRepository;
import com.commerce.library.service.ProductService;
import com.commerce.library.utils.ImageUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ImageUpload imageUpload;
    @Override
    public List<ProductDao> findAll() {
        List<ProductDao> productDaoList = new ArrayList<>();
        List<Product> products = productRepository.findAll();
        for (Product product: products){
            ProductDao productDao = new ProductDao();
            productDao.setId(product.getId());
            productDao.setName(product.getName());
            productDao.setDescription(product.getDescription());
            productDao.setCostPrice(product.getCostPrice());
            productDao.setSalePrice(product.getSalePrice());
            productDao.setCurrentQuantity(product.getCurrentQuantity());
            productDao.setCategory(product.getCategory());
            productDao.setImage(product.getImage());
            productDao.setActivated(product.is_activated());
            productDao.setDeleted(product.is_deleted());
            productDaoList.add(productDao);
        }
        return productDaoList;
    }

    @Override
    public Product save(MultipartFile imageProduct, ProductDao productDao) {
        try {
            Product product =new Product();
            if(imageProduct == null){
                product.setImage(null);
            }else {
                if(imageUpload.uploadImage(imageProduct)){
                    System.out.println("update!!!!");
                }
//            img name
                product.setImage(imageProduct.getOriginalFilename());
            }
            product.setName(productDao.getName());
            product.setDescription(productDao.getDescription());
            product.setCategory(productDao.getCategory());
            product.setCostPrice(productDao.getCostPrice());
            product.setCurrentQuantity(productDao.getCurrentQuantity());
            product.set_activated(true);
            product.set_deleted(false);
            return productRepository.save(product);
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public Product update(ProductDao productDao) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void enableById(Long id) {

    }
}