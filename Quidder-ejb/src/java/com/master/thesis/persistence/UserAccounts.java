/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "user_accounts")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccounts.findAll", query = "SELECT u FROM UserAccounts u"),
    @NamedQuery(name = "UserAccounts.findByIdUserAccount", query = "SELECT u FROM UserAccounts u WHERE u.idUserAccount = :idUserAccount"),
    @NamedQuery(name = "UserAccounts.findByUserName", query = "SELECT u FROM UserAccounts u WHERE u.userName = :userName"),
    @NamedQuery(name = "UserAccounts.findByDisplayName", query = "SELECT u FROM UserAccounts u WHERE u.displayName = :displayName"),
    @NamedQuery(name = "UserAccounts.findByLocalCountry", query = "SELECT u FROM UserAccounts u WHERE u.localCountry = :localCountry"),
    @NamedQuery(name = "UserAccounts.findByPassword", query = "SELECT u FROM UserAccounts u WHERE u.password = :password"),
    @NamedQuery(name = "UserAccounts.findByGender", query = "SELECT u FROM UserAccounts u WHERE u.gender = :gender"),
    @NamedQuery(name = "UserAccounts.findByStartDate", query = "SELECT u FROM UserAccounts u WHERE u.startDate = :startDate")})
public class UserAccounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user_account")
    private Integer idUserAccount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "display_name")
    private String displayName;
    @Size(max = 2147483647)
    @Column(name = "local_country")
    private String localCountry;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "password")
    private String password;
    @Size(max = 2147483647)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @NotNull
    @Column(name = "start_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;
    @JoinColumn(name = "tw_user_profile", referencedColumnName = "id_tw_user_profile")
    @ManyToOne
    private TwitterUserProfiles twUserProfile;
    @JoinColumn(name = "fb_user_profile", referencedColumnName = "id_fb_user_profile")
    @ManyToOne
    private FacebookUserProfiles fbUserProfile;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userAccounts")
    private List<ResourcesGoalsUsers> resourcesGoalsUsersList;

    public UserAccounts() {
    }

    public UserAccounts(Integer idUserAccount) {
        this.idUserAccount = idUserAccount;
    }

    public UserAccounts(Integer idUserAccount, String userName, String displayName, String password, Date startDate) {
        this.idUserAccount = idUserAccount;
        this.userName = userName;
        this.displayName = displayName;
        this.password = password;
        this.startDate = startDate;
    }

    public Integer getIdUserAccount() {
        return idUserAccount;
    }

    public void setIdUserAccount(Integer idUserAccount) {
        this.idUserAccount = idUserAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLocalCountry() {
        return localCountry;
    }

    public void setLocalCountry(String localCountry) {
        this.localCountry = localCountry;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public TwitterUserProfiles getTwUserProfile() {
        return twUserProfile;
    }

    public void setTwUserProfile(TwitterUserProfiles twUserProfile) {
        this.twUserProfile = twUserProfile;
    }

    public FacebookUserProfiles getFbUserProfile() {
        return fbUserProfile;
    }

    public void setFbUserProfile(FacebookUserProfiles fbUserProfile) {
        this.fbUserProfile = fbUserProfile;
    }

    @XmlTransient
    public List<ResourcesGoalsUsers> getResourcesGoalsUsersList() {
        return resourcesGoalsUsersList;
    }

    public void setResourcesGoalsUsersList(List<ResourcesGoalsUsers> resourcesGoalsUsersList) {
        this.resourcesGoalsUsersList = resourcesGoalsUsersList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUserAccount != null ? idUserAccount.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccounts)) {
            return false;
        }
        UserAccounts other = (UserAccounts) object;
        if ((this.idUserAccount == null && other.idUserAccount != null) || (this.idUserAccount != null && !this.idUserAccount.equals(other.idUserAccount))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.UserAccounts[ idUserAccount=" + idUserAccount + " ]";
    }
    
}
