/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.login;

/**
 *
 * @author Javier
 */
public class TwitterUser {

    private String ID;
    private String Provider;
    private String Prefix;
    private String FirstName;
    private String MiddleName;
    private String LastName;
    private String Suffix;
    private String FullName;
    private String NickName;
    private String ProfileName;
    private String BirthDate;
    private String Gender;
    private String ImageUrl;
    private String ThumbnailImageUrl;
    private String Email;
    private Country Country;
    private String LocalCountry;
    private String ProfileCountry;

    public TwitterUser() {
        System.out.println("Twitter User Constructor");
    }   
    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getProvider() {
        return Provider;
    }

    public void setProvider(String Provider) {
        this.Provider = Provider;
    }

    public String getPrefix() {
        return Prefix;
    }

    public void setPrefix(String Prefix) {
        this.Prefix = Prefix;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getMiddleName() {
        return MiddleName;
    }

    public void setMiddleName(String MiddleName) {
        this.MiddleName = MiddleName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getSuffix() {
        return Suffix;
    }

    public void setSuffix(String Suffix) {
        this.Suffix = Suffix;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String FullName) {
        this.FullName = FullName;
    }

    public String getNickName() {
        return NickName;
    }

    public void setNickName(String NickName) {
        this.NickName = NickName;
    }

    public String getProfileName() {
        return ProfileName;
    }

    public void setProfileName(String ProfileName) {
        this.ProfileName = ProfileName;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthDate) {
        this.BirthDate = BirthDate;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String Gender) {
        this.Gender = Gender;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String ImageUrl) {
        this.ImageUrl = ImageUrl;
    }

    public String getThumbnailImageUrl() {
        return ThumbnailImageUrl;
    }

    public void setThumbnailImageUrl(String ThumbnailImageUrl) {
        this.ThumbnailImageUrl = ThumbnailImageUrl;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public Country getCountry() {
        return Country;
    }

    public void setCountry(Country Country) {
        this.Country = Country;
    }

    public String getLocalCountry() {
        return LocalCountry;
    }

    public void setLocalCountry(String LocalCountry) {
        this.LocalCountry = LocalCountry;
    }

    public String getProfileCountry() {
        return ProfileCountry;
    }

    public void setProfileCountry(String ProfileCountry) {
        this.ProfileCountry = ProfileCountry;
    }   
    
    public TwitterUser userService(String name, String password){
        if(name.equalsIgnoreCase("") && password.equalsIgnoreCase("")){
            return this;
        }
        return null;
    }
}
