package com.store.service;

import com.store.entity.Clothes;
import com.store.entity.Shoes;
import com.store.entity.ShoppingCart;
import com.store.filter.ClothesFilter;
import com.store.filter.ShoesFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ShoppingCartService {

    List<ShoppingCart> findAll();

    Optional<ShoppingCart> findOne(Long id);

    void save(ShoppingCart shoppingCart);

    void delete(Long id);

    Page<ShoppingCart> findAll(Pageable pageable);



}