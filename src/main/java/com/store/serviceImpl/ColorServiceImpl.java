package com.store.serviceImpl;

import com.store.entity.Color;
import com.store.repository.ColorRepository;
import com.store.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ColorServiceImpl implements ColorService{

    private final  ColorRepository colorRepository;
    @Autowired
    public ColorServiceImpl(ColorRepository colorRepository) {
        this.colorRepository = colorRepository;
    }

    @Override
    public Iterable<Color> findAll() {
        return colorRepository.findAll();
    }

    @Override
    public Optional<Color> findOne(Long id) {
        return colorRepository.findById(id);
    }

    @Override
    public Color save(Color color) {
        return colorRepository.save(color);
    }

    @Override
    public void delete(Long id) {
        colorRepository.deleteById(id);
    }
}
