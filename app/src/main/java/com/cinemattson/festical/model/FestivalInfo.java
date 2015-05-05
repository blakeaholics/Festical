package com.cinemattson.festical.model;

/**
 * Created by Blake on 19/12/14.
 */
public class FestivalInfo {
    String urlImage;
    String Name = "";
    String EstDate = "";
    String SubDate = "";
    String Website = "";
    String Bio = "";
    String Rating = "";

    public FestivalInfo(String Name, String EstDate, String SubDate, String Website, String Bio, String Rating, String urlImage) {
        this.Name = Name;
        this.EstDate = EstDate;
        this.SubDate = SubDate;
        this.Website = Website;
        this.Bio = Bio;
        this.Rating = Rating;
        this.urlImage = urlImage;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEstDate() {
        return this.EstDate;
    }

    public void setEstDate(String Date) {
        this.EstDate = Date;
    }

    public String getSubDate() {
        return this.SubDate;
    }

    public void setSubDate(String Date) {
        this.SubDate = Date;
    }

    public String getWebsite() {
        return this.Website;
    }

    public void setWebsite(String Site) {
        this.Website = Site;
    }

    public String getBio() {
        return this.Bio;
    }

    public void setBio(String Bio) {
        this.Bio = Bio;
    }

    public String getRating() {
        return Rating;
    }
}
