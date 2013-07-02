/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Javier
 */
@Entity
@Table(name = "resources_goals")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResourcesGoals.findAll", query = "SELECT r FROM ResourcesGoals r"),
    @NamedQuery(name = "ResourcesGoals.findByIdResources", query = "SELECT r FROM ResourcesGoals r WHERE r.resourcesGoalsPK.idResources = :idResources"),
    @NamedQuery(name = "ResourcesGoals.findByIdGoals", query = "SELECT r FROM ResourcesGoals r WHERE r.resourcesGoalsPK.idGoals = :idGoals"),
    @NamedQuery(name = "ResourcesGoals.findByAmount", query = "SELECT r FROM ResourcesGoals r WHERE r.amount = :amount")})
public class ResourcesGoals implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ResourcesGoalsPK resourcesGoalsPK;
    @Column(name = "amount")
    private Integer amount;
    @JoinColumn(name = "id_resources", referencedColumnName = "id_resource", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Resources resources;
    @JoinColumn(name = "id_goals", referencedColumnName = "id_goal_tag", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private GoalTags goalTags;

    public ResourcesGoals() {
    }

    public ResourcesGoals(ResourcesGoalsPK resourcesGoalsPK) {
        this.resourcesGoalsPK = resourcesGoalsPK;
    }

    public ResourcesGoals(int idResources, int idGoals) {
        this.resourcesGoalsPK = new ResourcesGoalsPK(idResources, idGoals);
    }

    public ResourcesGoalsPK getResourcesGoalsPK() {
        return resourcesGoalsPK;
    }

    public void setResourcesGoalsPK(ResourcesGoalsPK resourcesGoalsPK) {
        this.resourcesGoalsPK = resourcesGoalsPK;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
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
        hash += (resourcesGoalsPK != null ? resourcesGoalsPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourcesGoals)) {
            return false;
        }
        ResourcesGoals other = (ResourcesGoals) object;
        if ((this.resourcesGoalsPK == null && other.resourcesGoalsPK != null) || (this.resourcesGoalsPK != null && !this.resourcesGoalsPK.equals(other.resourcesGoalsPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.ResourcesGoals[ resourcesGoalsPK=" + resourcesGoalsPK + " ]";
    }
    
}
