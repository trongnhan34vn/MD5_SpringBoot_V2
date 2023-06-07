package com.example.md5_ss5_baitap_1_ungdungnghenhac.model;

import javax.persistence.*;

@Entity
@Table(name = "Audios")
public class Audio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int audioId;
    private String audioName;
    private String artist;
    private String category;
    @Column(columnDefinition = "TEXT")
    private String url;

    public Audio() {
    }

    public Audio(int audioId, String audioName, String artist, String category, String url) {
        this.audioId = audioId;
        this.audioName = audioName;
        this.artist = artist;
        this.category = category;
        this.url = url;
    }

    public int getAudioId() {
        return audioId;
    }

    public void setAudioId(int audioId) {
        this.audioId = audioId;
    }

    public String getAudioName() {
        return audioName;
    }

    public void setAudioName(String audioName) {
        this.audioName = audioName;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
