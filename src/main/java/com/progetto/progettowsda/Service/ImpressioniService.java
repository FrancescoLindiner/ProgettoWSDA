package com.progetto.progettowsda.Service;

import com.progetto.progettowsda.Model.ImpressioneDTO;
import com.progetto.progettowsda.Repository.ImpressioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImpressioniService {
    @Autowired
    private ImpressioniRepository impressioniRepository;

    public List<ImpressioneDTO> searchIdImpiantoIdPalinsesto(String idImpianto, String idPalinsesto) {
        return impressioniRepository.searchIdImpiantoIdPalinsesto(idImpianto, idPalinsesto);
    }

    public List<ImpressioneDTO> searchIdImpiantoIdPalinsestoIdCartellone(String idImpianto, String idPalinsesto, String idCartellone) {
        return impressioniRepository.searchIdImpiantoIdPalinsestoIdCartellone(idImpianto, idPalinsesto, idCartellone);
    }

    public List<ImpressioneDTO> searchIdImpiantoIdPalinsestoDate(String idImpianto, String idPalinsesto, LocalDateTime timestampFrom, LocalDateTime timestampTo) {
        return impressioniRepository.searchIdImpiantoIdPalinsestoDate(idImpianto, idPalinsesto, timestampFrom, timestampTo);
    }

    public List<ImpressioneDTO> searchAll(String idImpianto, String idPalinsesto, String idCartellone, LocalDateTime timestampFrom, LocalDateTime timestampTo) {
        return impressioniRepository.searchAll(idImpianto, idPalinsesto, idCartellone, timestampFrom, timestampTo);
    }

    public List<ImpressioneDTO> searchIdImpiantoIdPalinsestoIdCartelloneDateFrom(String idImpianto, String idPalinsesto, String idCartellone, LocalDateTime timestampFrom) {
        return impressioniRepository.searchIdImpiantoIdPalinsestoIdCartelloneDateFrom(idImpianto, idPalinsesto, idCartellone, timestampFrom);
    }

    public List<ImpressioneDTO> searchIdImpiantoIdPalinsestoIdCartelloneDateTo(String idImpianto, String idPalinsesto, String idCartellone, LocalDateTime timestampTo) {
        return impressioniRepository.searchIdImpiantoIdPalinsestoIdCartelloneDateTo(idImpianto, idPalinsesto, idCartellone, timestampTo);
    }

    public List<ImpressioneDTO> searchIdImpiantoIdPalinsestoDateTo(String idImpianto, String idPalinsesto, LocalDateTime timestampTo) {
        return impressioniRepository.searchIdImpiantoIdPalinsestoDateTo(idImpianto, idPalinsesto, timestampTo);
    }

    public List<ImpressioneDTO> searchIdImpiantoIdPalinsestoDateFrom(String idImpianto, String idPalinsesto, LocalDateTime timestampFrom) {
        return impressioniRepository.searchIdImpiantoIdPalinsestoDateFrom(idImpianto, idPalinsesto, timestampFrom);
    }

    public List<ImpressioneDTO> getImpiantoAttivo() {
        return impressioniRepository.getImpiantoAttivo();
    }

    public List<ImpressioneDTO> getPalinsestoAttivo() {
        return impressioniRepository.getPalinsestoAttivo();
    }

    public List<ImpressioneDTO> getCartelloneAttivo() {
        return impressioniRepository.getCartelloneAttivo();
    }

    public List<ImpressioneDTO> searchImpianto(String idImpianto) {
        return impressioniRepository.searchImpianto(idImpianto);
    }
}