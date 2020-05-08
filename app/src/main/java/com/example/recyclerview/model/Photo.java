package com.example.recyclerview.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.SerializedName;

/**
 * {
 * albumId: 1,
 * id: 1,
 * title: "accusamus beatae ad facilis cum similique qui sunt",
 * url: "https://via.placeholder.com/600/92c952",
 * thumbnailUrl: "https://via.placeholder.com/150/92c952"
 * }
 */
public class Photo {

    private Integer albumId;
    private Integer id;
    @SerializedName("title")
    private String titulo;
    private String url;
    private String thumbnailUrl;

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}
