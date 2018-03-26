
package com.store.serviceImpl;

import com.store.entity.ClothesSize;
import com.store.repository.ClothesSizeRepository;
import com.store.service.ClothesSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClothesSizeServiceImpl implements ClothesSizeService {

    private final ClothesSizeRepository clothesSizeRepository;
    @Autowired
    public ClothesSizeServiceImpl(ClothesSizeRepository clothesSizeRepository){
        this.clothesSizeRepository = clothesSizeRepository;
    }
    @Override
    public Iterable<ClothesSize> findAll(){
        return clothesSizeRepository.findAll();
    }
    @Override
    public Optional<ClothesSize> findOne(Long id){
        return clothesSizeRepository.findById(id);
    }
    @Override
    public ClothesSize save(ClothesSize clothesSize){
        return  clothesSizeRepository.save(clothesSize);
    }
    @Override
    public void delete(Long id){
        clothesSizeRepository.deleteById(id);
    }
}
