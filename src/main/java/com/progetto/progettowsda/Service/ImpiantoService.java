package com.progetto.progettowsda.Service;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Repository.ImpiantoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpiantoService {
    @Autowired
    private ImpiantoRepository impiantoRepository;

    public List<Impianto> getAllImpianti() {
        // Ottieni tutti gli impianti
        List<Impianto> impianti = impiantoRepository.findAll();

        return impianti;
    }
}
