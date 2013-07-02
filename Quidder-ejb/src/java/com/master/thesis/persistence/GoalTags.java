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
@Table(name = "goal_tags")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GoalTags.findAll", query = "SELECT g FROM GoalTags g"),
    @NamedQuery(name = "GoalTags.findByIdGoalTag", query = "SELECT g FROM GoalTags g WHERE g.idGoalTag = :idGoalTag"),
    @NamedQuery(name = "GoalTags.findByTagName", query = "SELECT g FROM GoalTags g WHERE g.tagName = :tagName")})
public class GoalTags implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_goal_tag")
    private Integer idGoalTag;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "tag_name")
    private String tagName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goalTags")
    private List<ResourcesGoals> resourcesGoalsList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "goalTags")
    private List<ResourcesGoalsUsers> resourcesGoalsUsersList;

    public GoalTags() {
    }

    public GoalTags(Integer idGoalTag) {
        this.idGoalTag = idGoalTag;
    }

    public GoalTags(Integer idGoalTag, String tagName) {
        this.idGoalTag = idGoalTag;
        this.tagName = tagName;
    }

    public Integer getIdGoalTag() {
        return idGoalTag;
    }

    public void setIdGoalTag(Integer idGoalTag) {
        this.idGoalTag = idGoalTag;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    @XmlTransient
    public List<ResourcesGoals> getResourcesGoalsList() {
        return resourcesGoalsList;
    }

    public void setResourcesGoalsList(List<ResourcesGoals> resourcesGoalsList) {
        this.resourcesGoalsList = resourcesGoalsList;
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
        hash += (idGoalTag != null ? idGoalTag.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GoalTags)) {
            return false;
        }
        GoalTags other = (GoalTags) object;
        if ((this.idGoalTag == null && other.idGoalTag != null) || (this.idGoalTag != null && !this.idGoalTag.equals(other.idGoalTag))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.master.thesis.persistence.GoalTags[ idGoalTag=" + idGoalTag + " ]";
    }
    
}
