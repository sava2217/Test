package com.store.serviceImpl;

import com.store.entity.Season;
import com.store.filter.SimpleFilter;
import com.store.repository.SeasonRepository;
import com.store.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;

    }

    @Override
    public List<Season> findAll() {
        return (List<Season>) seasonRepository.findAll();
    }

    @Override
    public Optional<Season> findById(Long id) {
        return seasonRepository.findById(id);
    }

    @Override
    public void save(Season season) {
        seasonRepository.save(season);
    }

    @Override
    public void delete(Long id) {
        seasonRepository.deleteById(id);
    }

    @Override
    public Page<Season> findAll(SimpleFilter filter, Pageable pageable) {
        return seasonRepository.findAll(filterMethod(filter), pageable);
    }

    @Override
    public Page<Season> findAll(Pageable pageable) {
        return seasonRepository.findAll(pageable);
    }

    private Specification<Season> filterMethod(SimpleFilter filter) {
        return ((root, criteriaQuery, criteriaBuilder) -> {
            if (filter.getSearch().isEmpty()) return null;
            return criteriaBuilder.like(root.get("name"), filter.getSearch() + "%");
        });
    }

}