package com.example.projectAlphaCentauri.service;

import com.example.projectAlphaCentauri.model.AlphaCentauri;
import com.example.projectAlphaCentauri.repository.AlphaCentauriRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class AlphaCentauriService {

    public final AlphaCentauriRepository alphaCentauriRepository;


    public AlphaCentauriService(AlphaCentauriRepository alphaCentauriRepository) {
        this.alphaCentauriRepository = alphaCentauriRepository;
    }

//    List<AlphaCentauri> alphaCentauriList();
}