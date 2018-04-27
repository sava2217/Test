package com.store.serviceImpl;

import com.store.entity.ShoesMaterial;
import com.store.filter.SimpleFilter;
import com.store.repository.ShoesMaterialRepository;
import com.store.service.ShoesMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShoesMaterialServiceImpl implements ShoesMaterialService {

    private final ShoesMaterialRepository shoesMaterialRepository;

    @Autowired
    public ShoesMaterialServiceImpl(ShoesMaterialRepository shoesMaterialRepository) {
        this.shoesMaterialRepository = shoesMaterialRepository;

    }

    @Override
    public List<ShoesMaterial> findAll() {
        return (List<ShoesMaterial>) shoesMaterialRepository.findAll();
    }

    @Override
    public Optional<ShoesMaterial> findById(Long id) {
        return shoesMaterialRepository.findById(id);
    }

    @Override
    public void save(ShoesMaterial color) {
        shoesMaterialRepository.save(color);
    }

    @Override
    public void delete(Long id) {
        shoesMaterialRepository.deleteById(id);
    }

    @Override
    public Page<ShoesMaterial> findAll(SimpleFilter filter, Pageable pageable) {
        return shoesMaterialRepository.findAll(filterMethod(filter), pageable);
    }

    @Override
    public Page<ShoesMaterial> findAll(Pageable pageable) {
        return shoesMaterialRepository.findAll(pageable);
    }

    private Specification<ShoesMaterial> filterMethod(SimpleFilter filter) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (filter.getSearch().isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), filter.getSearch() + "%");
        });
    }

}