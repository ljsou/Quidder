/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.master.thesis.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "resource_types")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ResourceTypes.findAll", query = "SELECT r FROM ResourceTypes r"),
    @NamedQuery(name = "ResourceTypes.findByIdResourceType", query = "SELECT r FROM ResourceTypes r WHERE r.idResourceType = :idResourceType"),
    @NamedQuery(name = "ResourceTypes.findByResourceTypeName", query = "SELECT r FROM ResourceTypes r WHERE r.resourceTypeName = :resourceTypeName")})
public class ResourceTypes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_resource_type")
    private Integer idResourceType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "resource_type_name")
    private String resourceTypeName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "resourceType")
    private List<Resources> resourcesList;

    public ResourceTypes() {
    }

    public ResourceTypes(Integer idResourceType) {
        this.idResourceType = idResourceType;
    }

    public ResourceTypes(Integer idResourceType, String resourceTypeName) {
        this.idResourceType = idResourceType;
        this.resourceTypeName = resourceTypeName;
    }

    public Integer getIdResourceType() {
        return idResourceType;
    }

    public void setIdResourceType(Integer idResourceType) {
        this.idResourceType = idResourceType;
    }

    public String getResourceTypeName() {
        return resourceTypeName;
    }

    public void setResourceTypeName(String resourceTypeName) {
        this.resourceTypeName = resourceTypeName;
    }

    @XmlTransient
    public List<Resources> getResourcesList() {
        return resourcesList;
    }

    public void setResourcesList(List<Resources> resourcesList) {
        this.resourcesList = resourcesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idResourceType != null ? idResourceType.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourceTypes)) {
            return false;
        }
        ResourceTypes other = (ResourceTypes) object;
        if ((this.idResourceType == null && other.idResourceType != null) || (this.idResourceType != null && !this.idResourceType.equals(other.idResourceType))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.ResourceTypes[ idResourceType=" + idResourceType + " ]";
    }
    
}
