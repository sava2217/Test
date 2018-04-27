package com.store.serviceImpl;

import com.store.entity.ShoesSize;
import com.store.filter.SimpleFilter;
import com.store.repository.ShoesSizeRepository;
import com.store.service.ShoesSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ShoesSizeServiceImpl implements ShoesSizeService {

    private final ShoesSizeRepository shoesSizeRepository;

    @Autowired
    public ShoesSizeServiceImpl(ShoesSizeRepository shoesSizeRepository) {
        this.shoesSizeRepository = shoesSizeRepository;

    }

    @Override
    public List<ShoesSize> findAll() {
        return (List<ShoesSize>) shoesSizeRepository.findAll();
    }

    @Override
    public Optional<ShoesSize> findById(Long id) {
        return shoesSizeRepository.findById(id);
    }

    @Override
    public void save(ShoesSize color) {
        shoesSizeRepository.save(color);
    }

    @Override
    public void delete(Long id) {
        shoesSizeRepository.deleteById(id);
    }

    @Override
    public Page<ShoesSize> findAll(SimpleFilter filter, Pageable pageable) {
        return shoesSizeRepository.findAll(filterMethod(filter), pageable);
    }

    @Override
    public Page<ShoesSize> findAll(Pageable pageable) {
        return shoesSizeRepository.findAll(pageable);
    }

    private Specification<ShoesSize> filterMethod(SimpleFilter filter) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (filter.getSearch().isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), filter.getSearch() + "%");
        });
    }

}