package com.store.serviceImpl;

import com.store.entity.ClothesGender;
import com.store.repository.ClothesGenderRepository;
import com.store.service.ClothesGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClothesGenderServiceImpl implements ClothesGenderService {

    private final ClothesGenderRepository clothesGenderRepository;

    @Autowired
    public ClothesGenderServiceImpl(ClothesGenderRepository clothesGenderRepository) {
        this.clothesGenderRepository = clothesGenderRepository;
    }

    @Override
    public Iterable<ClothesGender> findAll() {
        return clothesGenderRepository.findAll();
    }

    @Override
    public Optional<ClothesGender> findOne(Long id) {
        return clothesGenderRepository.findById(id);
    }

    @Override
    public ClothesGender save(ClothesGender brand) {
        return clothesGenderRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        clothesGenderRepository.deleteById(id);
    }
}
