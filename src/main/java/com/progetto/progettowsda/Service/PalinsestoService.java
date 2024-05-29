package com.progetto.progettowsda.Service;

import com.progetto.progettowsda.Model.Palinsesto;
import com.progetto.progettowsda.Repository.PalinsestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PalinsestoService {

    @Autowired
    private PalinsestoRepository palinsestoRepository;

    /*public Palinsesto getPalinsestoByIdImpianto(String idImpianto) {
        return palinsestoRepository.findByIdImpianto(idImpianto);
    }*/

    public List<Palinsesto> getAllPalinsesti() {
        return palinsestoRepository.findAll();
    }
}
