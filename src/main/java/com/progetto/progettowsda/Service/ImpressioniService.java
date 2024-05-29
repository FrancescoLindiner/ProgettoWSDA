package com.progetto.progettowsda.Service;

import com.progetto.progettowsda.Model.Impianto;
import com.progetto.progettowsda.Repository.ImpiantoRepository;
import com.progetto.progettowsda.Repository.ImpressioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImpressioniService {

    @Autowired
    private ImpressioniRepository impressioniRepository;

    @Autowired
    private ImpiantoRepository impiantoRepository;

    public List<Object []> getAllImpressions() {
        return impressioniRepository.getDurataTotalePerImpiantoPalinsestoCartellone();
    }

    public void aggiornaImpianto(String idImpianto, String descrizione, boolean stato, float latitudine, float longitudine) {
        Optional<Impianto> impiantoOptional = impiantoRepository.findByIdImpianto(idImpianto);
        if (impiantoOptional.isPresent()) {
            Impianto impianto = impiantoOptional.get();
            impianto.setDescrizione(descrizione);
            impianto.setStato(stato);
            impianto.setLatitudine(latitudine);
            impianto.setLongitudine(longitudine);
            impiantoRepository.save(impianto);
        }
    }
}
