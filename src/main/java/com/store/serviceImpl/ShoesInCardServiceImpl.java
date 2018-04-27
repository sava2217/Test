package com.store.serviceImpl;

import com.store.entity.ShoesInCard;
import com.store.repository.ShoesInCardRepository;
import com.store.service.ShoesInCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ShoesInCardServiceImpl implements ShoesInCardService {

    private final ShoesInCardRepository shoesInCardRepository;

    @Autowired
    public ShoesInCardServiceImpl(ShoesInCardRepository shoesInCardRepository) {
        this.shoesInCardRepository = shoesInCardRepository;
    }

    @Override
    public List<ShoesInCard> findAll() {
        return shoesInCardRepository.findAll();
    }

    @Override
    public Optional<ShoesInCard> findOne(Long id) {
        return shoesInCardRepository.findById(id);
    }

    @Override
    public void save(ShoesInCard clothesInCard) {
        shoesInCardRepository.save(clothesInCard);
    }

    @Override
    public void delete(Long id) {
        shoesInCardRepository.deleteById(id);
    }
}