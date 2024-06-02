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

    public Boolean aggiornaImpianto(String idImpianto, String descrizione, boolean stato, float latitudine, float longitudine) {
        Impianto impianto = impiantoRepository.findByIdImpianto(idImpianto);
        if (impianto != null) {
            impianto.setDescrizione(descrizione);
            impianto.setLatitudine(latitudine);
            impianto.setStato(stato);
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

    public Boolean aggiornaStato(String idImpianto, boolean stato) {
        try {
            Impianto impianto = impiantoRepository.findByIdImpianto(idImpianto);
            impianto.setStato(stato);
            impiantoRepository.save(impianto);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean aggiungiImpianto(String idImpianto, String descrizione, float latitudine, float longitudine, String palinsestoPath, boolean stato) {
        try {
            // Verifica se l'ID dell'impianto è già presente nel repository
            if (impiantoRepository.existsByIdImpianto(idImpianto)) {
                return false; // L'ID dell'impianto è duplicato, quindi non possiamo aggiungere l'impianto
            }

            // Creazione del nuovo impianto e impostazione dei valori
            Impianto nuovoImpianto = new Impianto();
            nuovoImpianto.setIdImpianto(idImpianto);
            nuovoImpianto.setDescrizione(descrizione);
            nuovoImpianto.setLatitudine(latitudine);
            nuovoImpianto.setLongitudine(longitudine);
            nuovoImpianto.setPalinsesto_path(palinsestoPath);
            nuovoImpianto.setStato(stato);

            // Salvataggio del nuovo impianto nel repository
            impiantoRepository.save(nuovoImpianto);
            return true; // L'aggiunta dell'impianto è avvenuta con successo
        } catch (Exception e) {
            e.printStackTrace(); // Oppure gestisci l'eccezione in base alle tue esigenze
            return false; // Si è verificato un errore durante l'aggiunta dell'impianto
        }
    }
}
