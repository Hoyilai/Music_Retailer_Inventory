package com.album.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Album{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "album_id_seq")
    @SequenceGenerator(name = "album_id_seq", sequenceName = "album_id_seq", allocationSize = 100)
    private Integer albumId;
    private String title;
    private String artist;
    private Date dateReleased ;
    private String genre;
    private Integer tracks;
    private Double price;

    public Album(){

    }


    public Album(int albumId,String title,String artist, Date dateReleased, String genre, int tracks, double price) {
        this.albumId = albumId;
        this.title = title;
        this.artist = artist;
        this.dateReleased = dateReleased;
        this.genre = genre;
        this.tracks = tracks;
        this.price = price;
    }

    @Override
    public String toString(){
        return "albumID" + albumId + "title " + title + "artist " + artist + "datarelease " + dateReleased + "genre "+ genre
                + "tracks " + tracks + "price " + price;
    }

    public Integer getAlbumId() {
        return albumId;
    }

    public void setAlbumId(Integer albumId) {
        this.albumId = albumId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Date getDateReleased() {
        return dateReleased;
    }

    public void setDateReleased(Date dateReleased) {
        this.dateReleased = dateReleased;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Integer getTracks() {
        return tracks;
    }

    public void setTracks(Integer tracks) {
        this.tracks = tracks;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}



