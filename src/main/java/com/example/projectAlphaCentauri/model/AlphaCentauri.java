package com.example.projectAlphaCentauri.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "project_alphacentauri")
@Data
public class AlphaCentauri {



    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;  //логин
    @Column(name = "password")
    private String password;  //пароль

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "alphaCentauri")
    private List<Image> images = new ArrayList<>();

    private LocalDateTime dateOfCreated;

    private long PreviewImageId;

    @PrePersist
    private void init() { dateOfCreated = LocalDateTime.now(); }

    public void addImageToAlphaCentauri(Image image) {
        image.setAlphaCentauri(this);
        images.add(image);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public LocalDateTime getDateOfCreated() {
        return dateOfCreated;
    }

    public void setDateOfCreated(LocalDateTime dateOfCreated) {
        this.dateOfCreated = dateOfCreated;
    }

    public long getPreviewImageId() {
        return PreviewImageId;
    }

    public void setPreviewImageId(long previewImageId) {
        PreviewImageId = previewImageId;
    }
}
