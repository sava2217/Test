package com.store.serviceImpl;

import com.store.entity.ClothesMaterial;
import com.store.filter.SimpleFilter;
import com.store.repository.ClothesMaterialRepository;
import com.store.service.ClothesMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClothesMaterialServiceImpl implements ClothesMaterialService {

    private final ClothesMaterialRepository clothesMaterialRepository;

    @Autowired
    public ClothesMaterialServiceImpl(ClothesMaterialRepository clothesMaterialRepository) {
        this.clothesMaterialRepository = clothesMaterialRepository;
    }

    @Override
    public Iterable<ClothesMaterial> findAll() {
        return clothesMaterialRepository.findAll();
    }

    @Override
    public Optional<ClothesMaterial> findById(Long id) {
        return clothesMaterialRepository.findById(id);
    }

    @Override
    public void save(ClothesMaterial clothesMaterial) {
        clothesMaterialRepository.save(clothesMaterial);
    }

    @Override
    public void delete(Long id) {
        clothesMaterialRepository.deleteById(id);
    }

    @Override
    public Page<ClothesMaterial> findAll(SimpleFilter filter, Pageable pageable) {
        return clothesMaterialRepository.findAll(filterMethod(filter), pageable);
    }

    @Override
    public Page<ClothesMaterial> findAll(Pageable pageable) {
        return clothesMaterialRepository.findAll(pageable);
    }

    private Specification<ClothesMaterial> filterMethod(SimpleFilter filter) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (filter.getSearch().isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), filter.getSearch() + "%");
        });
    }

}