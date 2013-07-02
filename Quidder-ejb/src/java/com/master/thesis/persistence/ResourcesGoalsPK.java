/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Javier
 */
@Embeddable
public class ResourcesGoalsPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resources")
    private int idResources;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_goals")
    private int idGoals;

    public ResourcesGoalsPK() {
    }

    public ResourcesGoalsPK(int idResources, int idGoals) {
        this.idResources = idResources;
        this.idGoals = idGoals;
    }

    public int getIdResources() {
        return idResources;
    }

    public void setIdResources(int idResources) {
        this.idResources = idResources;
    }

    public int getIdGoals() {
        return idGoals;
    }

    public void setIdGoals(int idGoals) {
        this.idGoals = idGoals;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idResources;
        hash += (int) idGoals;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourcesGoalsPK)) {
            return false;
        }
        ResourcesGoalsPK other = (ResourcesGoalsPK) object;
        if (this.idResources != other.idResources) {
            return false;
        }
        if (this.idGoals != other.idGoals) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.ResourcesGoalsPK[ idResources=" + idResources + ", idGoals=" + idGoals + " ]";
    }
    
}
