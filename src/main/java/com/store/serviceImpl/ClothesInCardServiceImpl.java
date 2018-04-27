package com.store.serviceImpl;

import com.store.entity.ClothesInCard;
import com.store.repository.ClothesInCardRepository;
import com.store.service.ClothesInCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesInCardServiceImpl implements ClothesInCardService {

    private final ClothesInCardRepository clothesInCardRepository;

    @Autowired
    public ClothesInCardServiceImpl(ClothesInCardRepository clothesInCardRepository) {
        this.clothesInCardRepository = clothesInCardRepository;
    }

    @Override
    public List<ClothesInCard> findAll() {
        return clothesInCardRepository.findAll();
    }

    @Override
    public Optional<ClothesInCard> findOne(Long id) {
        return clothesInCardRepository.findById(id);
    }

    @Override
    public void save(ClothesInCard clothesInCard) {
        clothesInCardRepository.save(clothesInCard);
    }

    @Override
    public void delete(Long id) {
        clothesInCardRepository.deleteById(id);
    }
}