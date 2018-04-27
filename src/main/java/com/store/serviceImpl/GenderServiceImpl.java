package com.store.serviceImpl;

import com.store.entity.Gender;
import com.store.filter.SimpleFilter;
import com.store.repository.GenderRepository;
import com.store.service.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class GenderServiceImpl implements GenderService {

    private final GenderRepository genderRepository;

    @Autowired
    public GenderServiceImpl(GenderRepository genderRepository) {
        this.genderRepository = genderRepository;

    }

    @Override
    public List<Gender> findAll() {
        return (List<Gender>) genderRepository.findAll();
    }

    @Override
    public Optional<Gender> findById(Long id) {
        return genderRepository.findById(id);
    }

    @Override
    public void save(Gender gender) {
        genderRepository.save(gender);
    }

    @Override
    public void delete(Long id) {
        genderRepository.deleteById(id);
    }

    @Override
    public Page<Gender> findAll(SimpleFilter filter, Pageable pageable) {
        return genderRepository.findAll(filterMethod(filter), pageable);
    }

    @Override
    public Page<Gender> findAll(Pageable pageable) {
        return genderRepository.findAll(pageable);
    }

    private Specification<Gender> filterMethod(SimpleFilter filter) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (filter.getSearch().isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), filter.getSearch() + "%");
        });
    }

}