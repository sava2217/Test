package com.store.serviceImpl;

import com.store.entity.Gender;
import com.store.repository.GenderRepository;
import com.store.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class GenderServiceImpl implements GenderService{

    private final  GenderRepository genderRepository;
    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;
    }

    @Override
    public Iterable<Gender> findAll() {
        return genderRepository.findAll();
    }

    @Override
    public Optional<Gender> findOne(Long id) {
        return genderRepository.findById(id);
    }

    @Override
    public Gender save(Gender color) {
        return genderRepository.save(color);
    }

    @Override
    public void delete(Long id) {
        genderRepository.deleteById(id);
    }
}