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
public class ResourcesGoalsUsersPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resource")
    private int idResource;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_goal")
    private int idGoal;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;

    public ResourcesGoalsUsersPK() {
    }

    public ResourcesGoalsUsersPK(int idResource, int idGoal, int idUser) {
        this.idResource = idResource;
        this.idGoal = idGoal;
        this.idUser = idUser;
    }

    public int getIdResource() {
        return idResource;
    }

    public void setIdResource(int idResource) {
        this.idResource = idResource;
    }

    public int getIdGoal() {
        return idGoal;
    }

    public void setIdGoal(int idGoal) {
        this.idGoal = idGoal;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idResource;
        hash += (int) idGoal;
        hash += (int) idUser;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourcesGoalsUsersPK)) {
            return false;
        }
        ResourcesGoalsUsersPK other = (ResourcesGoalsUsersPK) object;
        if (this.idResource != other.idResource) {
            return false;
        }
        if (this.idGoal != other.idGoal) {
            return false;
        }
        if (this.idUser != other.idUser) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.ResourcesGoalsUsersPK[ idResource=" + idResource + ", idGoal=" + idGoal + ", idUser=" + idUser + " ]";
    }
    
}
