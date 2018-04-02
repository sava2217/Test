package com.store.serviceImpl;

import com.store.entity.Shoes;
import com.store.entity.ShoesSize;
import com.store.repository.ShoesRepository;
import com.store.repository.ShoesSizeRepository;
import com.store.service.ShoesSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShoesSizeServiceImpl implements ShoesSizeService {
    private final ShoesSizeRepository shoesSizeRepository;
    @Autowired
    ShoesSizeServiceImpl(ShoesSizeRepository shoesSizeRepository){
        this.shoesSizeRepository = shoesSizeRepository;
    }
    @Override
    public Iterable<ShoesSize> findAll() {
        return shoesSizeRepository.findAll();
    }
    @Override
    public Optional<ShoesSize> findOne(Long id) {
        return  shoesSizeRepository.findById(id);
    }
    @Override
    public ShoesSize save(ShoesSize shoesSize) {
        return shoesSizeRepository.save(shoesSize);
    }
    @Override
    public void delete(Long id) {
        shoesSizeRepository.deleteById(id);
    }
}