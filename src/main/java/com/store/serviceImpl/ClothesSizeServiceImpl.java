package com.store.serviceImpl;

import com.store.entity.ClothesSize;
import com.store.filter.SimpleFilter;
import com.store.repository.ClothesSizeRepository;
import com.store.service.ClothesSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ClothesSizeServiceImpl implements ClothesSizeService {

    private final ClothesSizeRepository clothesSizeRepository;

    @Autowired
    public ClothesSizeServiceImpl(ClothesSizeRepository clothesSizeRepository) {
        this.clothesSizeRepository = clothesSizeRepository;

    }

    @Override
    public Iterable<ClothesSize> findAll() {
        return clothesSizeRepository.findAll();
    }


    @Override
    public Optional<ClothesSize> findById(Long id) {
        return clothesSizeRepository.findById(id);
    }

    @Override
    public void save(ClothesSize color) {
        clothesSizeRepository.save(color);
    }

    @Override
    public void delete(Long id) {
        clothesSizeRepository.deleteById(id);
    }

    @Override
    public Page<ClothesSize> findAll(SimpleFilter filter, Pageable pageable) {
        return clothesSizeRepository.findAll(filterMethod(filter), pageable);
    }

    @Override
    public Page<ClothesSize> findAll(Pageable pageable) {
        return clothesSizeRepository.findAll(pageable);
    }

    private Specification<ClothesSize> filterMethod(SimpleFilter filter) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (filter.getSearch().isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), filter.getSearch() + "%");
        });
    }

}