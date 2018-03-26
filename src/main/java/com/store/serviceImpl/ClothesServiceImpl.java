package com.store.serviceImpl;

import com.store.entity.Clothes;
import com.store.repository.ClothesRepostirory;
import com.store.service.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClothesServiceImpl implements ClothesService {

    private final ClothesRepostirory clothesRepository;

    @Autowired
    public ClothesServiceImpl(ClothesRepostirory clothesRepository) {
        this.clothesRepository = clothesRepository;
    }

    @Override
    public Optional<Clothes> findOne(Long id) {
        return clothesRepository.findById(id);
    }
    @Override
    public Iterable<Clothes> findAll() {
        return clothesRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        clothesRepository.deleteById(id);
    }

    @Override
    public Clothes save(Clothes accessories) {
        return clothesRepository.save(accessories);
    }
}