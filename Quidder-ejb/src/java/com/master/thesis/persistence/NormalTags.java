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
@Table(name = "normal_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NormalTags.findAll", query = "SELECT n FROM NormalTags n"),
    @NamedQuery(name = "NormalTags.findByIdNormalTag", query = "SELECT n FROM NormalTags n WHERE n.idNormalTag = :idNormalTag"),
    @NamedQuery(name = "NormalTags.findByNormalTagName", query = "SELECT n FROM NormalTags n WHERE n.normalTagName = :normalTagName")})
public class NormalTags implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_normal_tag")
    private Integer idNormalTag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "normal_tag_name")
    private String normalTagName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "normalTags")
    private List<ResourcesTags> resourcesTagsList;

    public NormalTags() {
    }

    public NormalTags(Integer idNormalTag) {
        this.idNormalTag = idNormalTag;
    }

    public NormalTags(Integer idNormalTag, String normalTagName) {
        this.idNormalTag = idNormalTag;
        this.normalTagName = normalTagName;
    }

    public Integer getIdNormalTag() {
        return idNormalTag;
    }

    public void setIdNormalTag(Integer idNormalTag) {
        this.idNormalTag = idNormalTag;
    }

    public String getNormalTagName() {
        return normalTagName;
    }

    public void setNormalTagName(String normalTagName) {
        this.normalTagName = normalTagName;
    }

    @XmlTransient
    public List<ResourcesTags> getResourcesTagsList() {
        return resourcesTagsList;
    }

    public void setResourcesTagsList(List<ResourcesTags> resourcesTagsList) {
        this.resourcesTagsList = resourcesTagsList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNormalTag != null ? idNormalTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NormalTags)) {
            return false;
        }
        NormalTags other = (NormalTags) object;
        if ((this.idNormalTag == null && other.idNormalTag != null) || (this.idNormalTag != null && !this.idNormalTag.equals(other.idNormalTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.NormalTags[ idNormalTag=" + idNormalTag + " ]";
    }
    
}
