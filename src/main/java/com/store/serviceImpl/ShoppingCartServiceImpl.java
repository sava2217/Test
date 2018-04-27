package com.store.serviceImpl;

import com.store.entity.ShoppingCart;
import com.store.repository.ShoppingCartRepository;
import com.store.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return shoppingCartRepository.findAll();
    }

    @Override
    public Optional<ShoppingCart> findOne(Long id) {
        return shoppingCartRepository.findById(id);
    }

    @Override
    public void save(ShoppingCart shoppingCart) {
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void delete(Long id) {
        shoppingCartRepository.deleteById(id);
    }

    @Override
    public Page<ShoppingCart> findAll(Pageable pageable) {
        return shoppingCartRepository.findAll(pageable);
    }
}