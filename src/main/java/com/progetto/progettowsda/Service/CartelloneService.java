package com.progetto.progettowsda.Service;

import com.progetto.progettowsda.Model.Cartellone;
import com.progetto.progettowsda.Repository.CartelloneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartelloneService {
    @Autowired
    private CartelloneRepository cartelloneRepository;

    public List<Cartellone> getAllCartelloni() {
        List<Cartellone> cartelloni = cartelloneRepository.findAll();

        return cartelloni;
    }
}
