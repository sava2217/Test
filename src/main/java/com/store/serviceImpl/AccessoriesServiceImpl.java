package com.store.serviceImpl;

import com.store.entity.Accessories;
import com.store.repository.AccessoriesRepository;
import com.store.service.AccessoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccessoriesServiceImpl implements AccessoriesService {

    private final AccessoriesRepository accessoriesRepository;

    @Autowired
    public AccessoriesServiceImpl(AccessoriesRepository accessoriesRepository) {
        this.accessoriesRepository = accessoriesRepository;
    }

    @Override
    public Optional<Accessories> findOne(Long id) {
        return accessoriesRepository.findById(id);
    }
    @Override
    public Iterable<Accessories> findAll() {
        return accessoriesRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        accessoriesRepository.deleteById(id);
    }

    @Override
    public Accessories save(Accessories accessories) {
        return accessoriesRepository.save(accessories);
    }
}