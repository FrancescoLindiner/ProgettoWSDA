package com.progetto.progettowsda.Service;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Repository.ImpiantoRepository;
import com.progetto.progettowsda.Repository.PalinsestoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpiantoService {
    @Autowired
    private ImpiantoRepository impiantoRepository;

    @Autowired
    private PalinsestoRepository palinsestoRepository;


    public List<Impianto> getAllImpianti() {
        // Ottieni tutti gli impianti
        List<Impianto> impianti = impiantoRepository.findAll();

        return impianti;
    }

    public Boolean aggiornaImpianto(String idImpianto, String descrizione, boolean stato, float latitudine, float longitudine) {
        Impianto impianto = impiantoRepository.findByIdImpianto(idImpianto);
        if (impianto != null) {
            impianto.setDescrizione(descrizione);
            impianto.setStato(stato);
            impianto.setLatitudine(latitudine);
            impianto.setLongitudine(longitudine);
            impiantoRepository.save(impianto);
            return true;
        }
        return false;
    }

    public Boolean aggiornaImpiantoPalinsesto(String idImpianto, String idPalinsesto) {
        Impianto impianto = impiantoRepository.findByIdImpianto(idImpianto);
        if (impianto != null) {
            impianto.setPalinsesto_path(idPalinsesto);
            impiantoRepository.save(impianto);
            return true;
        } else {
            return false;
        }
    }

    public Impianto getPalinsestoByIdImpianto(String id) {
        return impiantoRepository.findByIdImpianto(id);
    }
}
