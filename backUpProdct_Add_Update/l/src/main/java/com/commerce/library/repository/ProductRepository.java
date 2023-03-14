package com.commerce.library.repository;

import com.commerce.library.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    /*Admin*/
    @Query("select p from Product p")
    Page<Product> pageProduct(Pageable pageable);

    @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
    Page<Product> searchProducts(String keyword, Pageable pageable);

    @Query("select p from Product p")
    List<Product> pageProduct();

    @Query("select p from Product p where p.description like %?1% or p.name like %?1%")
    List<Product> searchProducts(String keyword);

    @Query("select p from Product p where (p.description like %?1% or p.name like %?1%) and p.is_activated = true and p.category IN (select c.id from Category c where c.is_activated = true)")
    List<Product> searchHome(String keyword);

    @Query("select p from Product p where p.is_activated = true and p.is_deleted = false and p.category IN (select c.id from Category c where c.is_activated = true) ")
    List<Product> showProducts();




}