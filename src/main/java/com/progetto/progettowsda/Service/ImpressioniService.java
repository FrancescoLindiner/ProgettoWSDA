package com.progetto.progettowsda.Service;

import com.progetto.progettowsda.Repository.ImpressioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ImpressioniService {
    @Autowired
    private ImpressioniRepository impressioniRepository;

    public List<Object[]> searchImpressions(String idImpianto, String idPalinsesto, String idCartellone, Long durata, LocalDateTime timestampFrom) {
        return impressioniRepository.searchImpressions(idImpianto, idPalinsesto, idCartellone, durata, timestampFrom);
    }
}