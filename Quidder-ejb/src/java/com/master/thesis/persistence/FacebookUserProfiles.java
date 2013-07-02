/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "facebook_user_profiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacebookUserProfiles.findAll", query = "SELECT f FROM FacebookUserProfiles f"),
    @NamedQuery(name = "FacebookUserProfiles.findByIdFbUserProfile", query = "SELECT f FROM FacebookUserProfiles f WHERE f.idFbUserProfile = :idFbUserProfile"),
    @NamedQuery(name = "FacebookUserProfiles.findByFullName", query = "SELECT f FROM FacebookUserProfiles f WHERE f.fullName = :fullName"),
    @NamedQuery(name = "FacebookUserProfiles.findByImageUrl", query = "SELECT f FROM FacebookUserProfiles f WHERE f.imageUrl = :imageUrl"),
    @NamedQuery(name = "FacebookUserProfiles.findByLocalCountry", query = "SELECT f FROM FacebookUserProfiles f WHERE f.localCountry = :localCountry"),
    @NamedQuery(name = "FacebookUserProfiles.findByProfileUrl", query = "SELECT f FROM FacebookUserProfiles f WHERE f.profileUrl = :profileUrl")})
public class FacebookUserProfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_fb_user_profile")
    private Integer idFbUserProfile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "full_name")
    private String fullName;
    @Size(max = 2147483647)
    @Column(name = "image_url")
    private String imageUrl;
    @Size(max = 2147483647)
    @Column(name = "local_country")
    private String localCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "profile_url")
    private String profileUrl;
    @OneToMany(mappedBy = "fbUserProfile")
    private List<UserAccounts> userAccountsList;

    public FacebookUserProfiles() {
    }

    public FacebookUserProfiles(Integer idFbUserProfile) {
        this.idFbUserProfile = idFbUserProfile;
    }

    public FacebookUserProfiles(Integer idFbUserProfile, String fullName, String profileUrl) {
        this.idFbUserProfile = idFbUserProfile;
        this.fullName = fullName;
        this.profileUrl = profileUrl;
    }

    public Integer getIdFbUserProfile() {
        return idFbUserProfile;
    }

    public void setIdFbUserProfile(Integer idFbUserProfile) {
        this.idFbUserProfile = idFbUserProfile;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocalCountry() {
        return localCountry;
    }

    public void setLocalCountry(String localCountry) {
        this.localCountry = localCountry;
    }

    public String getProfileUrl() {
        return profileUrl;
    }

    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    @XmlTransient
    public List<UserAccounts> getUserAccountsList() {
        return userAccountsList;
    }

    public void setUserAccountsList(List<UserAccounts> userAccountsList) {
        this.userAccountsList = userAccountsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFbUserProfile != null ? idFbUserProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacebookUserProfiles)) {
            return false;
        }
        FacebookUserProfiles other = (FacebookUserProfiles) object;
        if ((this.idFbUserProfile == null && other.idFbUserProfile != null) || (this.idFbUserProfile != null && !this.idFbUserProfile.equals(other.idFbUserProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.FacebookUserProfiles[ idFbUserProfile=" + idFbUserProfile + " ]";
    }
    
}
