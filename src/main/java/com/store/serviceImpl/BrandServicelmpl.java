package com.store.serviceImpl;

import com.store.entity.Brand;
import com.store.repository.BrandRepository;
import com.store.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BrandServicelmpl implements BrandService {

    private final BrandRepository brandRepository;
    @Autowired
    public BrandServicelmpl(BrandRepository brandRepository){
        this.brandRepository = brandRepository;
    }
    @Override
    public Iterable<Brand> findAll(){
        return brandRepository.findAll();
    }
    @Override
    public Optional<Brand> findOne(Long id){
        return brandRepository.findById(id);
    }
    @Override
    public Brand save(Brand brand){
        return  brandRepository.save(brand);
    }
    @Override
    public void delete(Long id){
        brandRepository.deleteById(id);
    }
}
