/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "resources_goals_users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResourcesGoalsUsers.findAll", query = "SELECT r FROM ResourcesGoalsUsers r"),
    @NamedQuery(name = "ResourcesGoalsUsers.findByIdResource", query = "SELECT r FROM ResourcesGoalsUsers r WHERE r.resourcesGoalsUsersPK.idResource = :idResource"),
    @NamedQuery(name = "ResourcesGoalsUsers.findByIdGoal", query = "SELECT r FROM ResourcesGoalsUsers r WHERE r.resourcesGoalsUsersPK.idGoal = :idGoal"),
    @NamedQuery(name = "ResourcesGoalsUsers.findByIdUser", query = "SELECT r FROM ResourcesGoalsUsers r WHERE r.resourcesGoalsUsersPK.idUser = :idUser"),
    @NamedQuery(name = "ResourcesGoalsUsers.findByTimestamp", query = "SELECT r FROM ResourcesGoalsUsers r WHERE r.timestamp = :timestamp")})
public class ResourcesGoalsUsers implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResourcesGoalsUsersPK resourcesGoalsUsersPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "timestamp")
    @Temporal(TemporalType.TIME)
    private Date timestamp;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user_account", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private UserAccounts userAccounts;
    @JoinColumn(name = "id_resource", referencedColumnName = "id_resource", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resources resources;
    @JoinColumn(name = "id_goal", referencedColumnName = "id_goal_tag", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GoalTags goalTags;

    public ResourcesGoalsUsers() {
    }

    public ResourcesGoalsUsers(ResourcesGoalsUsersPK resourcesGoalsUsersPK) {
        this.resourcesGoalsUsersPK = resourcesGoalsUsersPK;
    }

    public ResourcesGoalsUsers(ResourcesGoalsUsersPK resourcesGoalsUsersPK, Date timestamp) {
        this.resourcesGoalsUsersPK = resourcesGoalsUsersPK;
        this.timestamp = timestamp;
    }

    public ResourcesGoalsUsers(int idResource, int idGoal, int idUser) {
        this.resourcesGoalsUsersPK = new ResourcesGoalsUsersPK(idResource, idGoal, idUser);
    }

    public ResourcesGoalsUsersPK getResourcesGoalsUsersPK() {
        return resourcesGoalsUsersPK;
    }

    public void setResourcesGoalsUsersPK(ResourcesGoalsUsersPK resourcesGoalsUsersPK) {
        this.resourcesGoalsUsersPK = resourcesGoalsUsersPK;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public UserAccounts getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(UserAccounts userAccounts) {
        this.userAccounts = userAccounts;
    }

    public Resources getResources() {
        return resources;
    }

    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public GoalTags getGoalTags() {
        return goalTags;
    }

    public void setGoalTags(GoalTags goalTags) {
        this.goalTags = goalTags;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resourcesGoalsUsersPK != null ? resourcesGoalsUsersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourcesGoalsUsers)) {
            return false;
        }
        ResourcesGoalsUsers other = (ResourcesGoalsUsers) object;
        if ((this.resourcesGoalsUsersPK == null && other.resourcesGoalsUsersPK != null) || (this.resourcesGoalsUsersPK != null && !this.resourcesGoalsUsersPK.equals(other.resourcesGoalsUsersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.ResourcesGoalsUsers[ resourcesGoalsUsersPK=" + resourcesGoalsUsersPK + " ]";
    }
    
}
