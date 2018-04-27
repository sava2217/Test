package com.store.serviceImpl;

import com.store.entity.Brand;
import com.store.filter.SimpleFilter;
import com.store.repository.BrandRepository;
import com.store.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;

    @Autowired
    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;


    }

    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }

    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }

    @Override
    public void save(Brand brand) {
        brandRepository.save(brand);
    }

    @Override
    public void delete(Long id) {
        brandRepository.deleteById(id);
    }

    @Override
    public Page<Brand> findAll(SimpleFilter filter, Pageable pageable) {
        return brandRepository.findAll(filterMethod(filter), pageable);
    }

    @Override
    public Page<Brand> findAll(Pageable pageable) {
        return brandRepository.findAll(pageable);
    }

    private Specification<Brand> filterMethod(SimpleFilter filter) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (filter.getSearch().isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), filter.getSearch() + "%");
        });
    }

}