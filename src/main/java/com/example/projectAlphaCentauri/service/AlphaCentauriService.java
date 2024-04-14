package com.example.projectAlphaCentauri.service;

import com.example.projectAlphaCentauri.model.AlphaCentauri;
import com.example.projectAlphaCentauri.model.Image;
import com.example.projectAlphaCentauri.repository.AlphaCentauriRepository;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

@Service
public class AlphaCentauriService {

    public final AlphaCentauriRepository alphaCentauriRepository;


    public AlphaCentauriService(AlphaCentauriRepository alphaCentauriRepository) {
        this.alphaCentauriRepository = alphaCentauriRepository;
    }
    public List<AlphaCentauri> alphaCentauriList(String username) {
        if (username != null) return alphaCentauriRepository.findByUsername(username);
        return alphaCentauriRepository.findAll();
    }
    private static Logger log = Logger.getLogger(AlphaCentauri.class.getName());

    private Image toImageEntity(MultipartFile file) throws IOException {
        Image image = new Image();
        image.setName(file.getName());
        image.setOriginalFileName(file.getOriginalFilename());
        image.setContentType(file.getContentType());
        image.setSize(file.getSize());
        image.setBytes(file.getBytes());
        return image;
    }

    public void saveAlphaCentauri(AlphaCentauri alphaCentauri, MultipartFile file1) throws IOException{
        Image image1;
        if (file1.getSize() != 0) {
            image1 = toImageEntity(file1);
            image1.setPreviewImage(true);
            alphaCentauri.addImageToAlphaCentauri(image1);
        }
        log.info(alphaCentauri.getUsername());
        AlphaCentauri alphaCentauriFromDB = alphaCentauriRepository.save(alphaCentauri);
        alphaCentauriFromDB.setPreviewImageId(alphaCentauriFromDB.getImages().get(0).getId());
        alphaCentauriRepository.save(alphaCentauri);
    }
    public void deleteAlphaCentauri(Long id) { alphaCentauriRepository.deleteById(id);}
    public AlphaCentauri getAlphaCentauriById(Long id) { return alphaCentauriRepository.findById(id).orElse(null);}
}