package com.store.serviceImpl;

import com.store.entity.ShoesMaterial;
import com.store.repository.ShoesMaterialRepository;
import com.store.service.ShoesMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ShoesMaterialServiceImpl implements ShoesMaterialService {
    private final ShoesMaterialRepository shoesMaterialRepository;
    @Autowired
    public ShoesMaterialServiceImpl(ShoesMaterialRepository shoesMaterialRepository) {
        this.shoesMaterialRepository = shoesMaterialRepository;
    }
    @Override
    public Iterable<ShoesMaterial> findAll() {
        return shoesMaterialRepository.findAll();
    }
    @Override
    public Optional<ShoesMaterial> findOne(Long id) {
        return shoesMaterialRepository.findById(id);
    }
    @Override
    public ShoesMaterial save(ShoesMaterial shoesMaterial) {
        return shoesMaterialRepository.save(shoesMaterial);
    }
    @Override
    public void delete(Long id) {
        shoesMaterialRepository.deleteById(id);
    }
}