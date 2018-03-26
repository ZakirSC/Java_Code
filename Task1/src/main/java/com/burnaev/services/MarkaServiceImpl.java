package com.burnaev.services;

import com.burnaev.models.Marka;
import com.burnaev.repositories.MarkaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkaServiceImpl implements MarkaService {

    @Autowired
    private MarkaRepository markaRepository;
    @Override
    public Marka getMarka(long id) {
        return markaRepository.findOne(id);
    }

    @Override
    public List<Marka> getMarks() {
        return markaRepository.findAll();
    }
}
