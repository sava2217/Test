package com.store.serviceImpl;

import com.store.entity.Shoes;
import com.store.repository.ShoesRepository;
import com.store.service.ShoesService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class ShoesServiceImpl implements ShoesService {
    private final ShoesRepository shoesRepository;
    @Autowired
    public ShoesServiceImpl(ShoesRepository shoesRepository) {
        this.shoesRepository = shoesRepository;
    }
    @Override
    public Iterable<Shoes> findAll() {
        return shoesRepository.findAll();
    }
    @Override
    public Optional<Shoes> findOne(Long id) {
        return shoesRepository.findById(id);
    }
    @Override
    public Shoes save(Shoes shoes) {
        return shoesRepository.save(shoes);
    }
    @Override
    public void delete(Long id) {
        shoesRepository.deleteById(id);
    }
}