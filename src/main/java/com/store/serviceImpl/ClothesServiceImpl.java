package com.store.serviceImpl;

import com.store.entity.Clothes;
import com.store.filter.ClothesFilter;
import com.store.repository.ClothesRepostirory;
import com.store.service.ClothesService;
import com.store.specification.ClothesSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Clothes> findAll(Pageable pageable) {
        return clothesRepository.findAll(pageable);
    }

    @Override
    public Page<Clothes> findAll(Pageable pageable, ClothesFilter filter) {
        return clothesRepository.findAll(new ClothesSpecification(filter), pageable);
    }

    @Override
    public void delete(Long id) {
        clothesRepository.deleteById(id);
    }

    @Override
    public void save(Clothes clothes) {
        clothesRepository.save(clothes);
    }
}