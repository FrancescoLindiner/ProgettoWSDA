package com.progetto.progettowsda.Service;

import com.progetto.progettowsda.Repository.ImpressioniRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImpressioniService {

    @Autowired
    private ImpressioniRepository impressioniRepository;

    public List<Object []> getAllImpressions() {
        return impressioniRepository.getDurataTotalePerImpiantoPalinsestoCartellone();
    }
}
