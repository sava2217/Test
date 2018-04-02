package com.store.serviceImpl;

import com.store.entity.ClothesMaterial;
import com.store.repository.ClothesMaterialRepository;
import com.store.service.ClothesMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClothesMaterialServiceImpl implements ClothesMaterialService {

    private final ClothesMaterialRepository clothesMaterialRepository;
    @Autowired
    public ClothesMaterialServiceImpl(ClothesMaterialRepository clothesMaterialRepository){
        this.clothesMaterialRepository = clothesMaterialRepository;
    }
    @Override
    public Iterable<ClothesMaterial> findAll(){
        return clothesMaterialRepository.findAll();
    }
    @Override
    public Optional<ClothesMaterial> findOne(Long id){
        return clothesMaterialRepository.findById(id);
    }
    @Override
    public ClothesMaterial save(ClothesMaterial clothesMaterial){
        return  clothesMaterialRepository.save(clothesMaterial);
    }
    @Override
    public void delete(Long id){
        clothesMaterialRepository.deleteById(id);
    }
}