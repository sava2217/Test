package com.store.serviceImpl;

import com.store.entity.Season;
import com.store.repository.SeasonRepository;
import com.store.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class SeasonServiceImpl implements SeasonService {

    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonServiceImpl(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @Override
    public Iterable<Season> findAll() {
        return seasonRepository.findAll();
    }

    @Override
    public Optional<Season> findOne(Long id) {
        return seasonRepository.findById(id);
    }

    @Override
    public Season save(Season season) {
        return seasonRepository.save(season);
    }

    @Override
    public void delete(Long id) {
        seasonRepository.deleteById(id);
    }
}