/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "twitter_user_profiles")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TwitterUserProfiles.findAll", query = "SELECT t FROM TwitterUserProfiles t"),
    @NamedQuery(name = "TwitterUserProfiles.findByIdTwUserProfile", query = "SELECT t FROM TwitterUserProfiles t WHERE t.idTwUserProfile = :idTwUserProfile"),
    @NamedQuery(name = "TwitterUserProfiles.findByTwitterUserFullname", query = "SELECT t FROM TwitterUserProfiles t WHERE t.twitterUserFullname = :twitterUserFullname"),
    @NamedQuery(name = "TwitterUserProfiles.findByTwitterProfileName", query = "SELECT t FROM TwitterUserProfiles t WHERE t.twitterProfileName = :twitterProfileName"),
    @NamedQuery(name = "TwitterUserProfiles.findByBirthDate", query = "SELECT t FROM TwitterUserProfiles t WHERE t.birthDate = :birthDate"),
    @NamedQuery(name = "TwitterUserProfiles.findByTwitterImageUrl", query = "SELECT t FROM TwitterUserProfiles t WHERE t.twitterImageUrl = :twitterImageUrl")})
public class TwitterUserProfiles implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_tw_user_profile")
    private Integer idTwUserProfile;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "twitter_user_fullname")
    private String twitterUserFullname;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "twitter_profile_name")
    private String twitterProfileName;
    @Column(name = "birth_date")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 2147483647)
    @Column(name = "twitter_image_url")
    private String twitterImageUrl;
    @OneToMany(mappedBy = "twUserProfile")
    private List<UserAccounts> userAccountsList;

    public TwitterUserProfiles() {
    }

    public TwitterUserProfiles(Integer idTwUserProfile) {
        this.idTwUserProfile = idTwUserProfile;
    }

    public TwitterUserProfiles(Integer idTwUserProfile, String twitterUserFullname, String twitterProfileName) {
        this.idTwUserProfile = idTwUserProfile;
        this.twitterUserFullname = twitterUserFullname;
        this.twitterProfileName = twitterProfileName;
    }

    public Integer getIdTwUserProfile() {
        return idTwUserProfile;
    }

    public void setIdTwUserProfile(Integer idTwUserProfile) {
        this.idTwUserProfile = idTwUserProfile;
    }

    public String getTwitterUserFullname() {
        return twitterUserFullname;
    }

    public void setTwitterUserFullname(String twitterUserFullname) {
        this.twitterUserFullname = twitterUserFullname;
    }

    public String getTwitterProfileName() {
        return twitterProfileName;
    }

    public void setTwitterProfileName(String twitterProfileName) {
        this.twitterProfileName = twitterProfileName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getTwitterImageUrl() {
        return twitterImageUrl;
    }

    public void setTwitterImageUrl(String twitterImageUrl) {
        this.twitterImageUrl = twitterImageUrl;
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
        hash += (idTwUserProfile != null ? idTwUserProfile.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TwitterUserProfiles)) {
            return false;
        }
        TwitterUserProfiles other = (TwitterUserProfiles) object;
        if ((this.idTwUserProfile == null && other.idTwUserProfile != null) || (this.idTwUserProfile != null && !this.idTwUserProfile.equals(other.idTwUserProfile))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.TwitterUserProfiles[ idTwUserProfile=" + idTwUserProfile + " ]";
    }
    
}
