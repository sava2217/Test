package com.store.serviceImpl;

import com.store.entity.Shoes;
import com.store.filter.ShoesFilter;
import com.store.repository.ShoesRepository;
import com.store.service.ShoesService;
import com.store.specification.ShoesSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
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
    public Page<Shoes> findAll(Pageable pageable) {
        return shoesRepository.findAll(pageable);
    }

    @Override
    public Page<Shoes> findAll(Pageable pageable, ShoesFilter filter) {
        return shoesRepository.findAll(new ShoesSpecification(filter), pageable);
    }

    @Override
    public Optional<Shoes> findOne(Long id) {
        return shoesRepository.findById(id);
    }

    @Override
    public void save(Shoes shoes) {
        shoesRepository.save(shoes);
    }


    @Override
    public void delete(Long id) {
        shoesRepository.deleteById(id);
    }


}