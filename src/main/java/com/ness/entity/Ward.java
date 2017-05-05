package com.ness.entity;
// Generated May 4, 2017 9:52:50 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Ward generated by hbm2java
 */
@Entity
@Table(name="ward"
    ,catalog="evoting"
)
public class Ward  implements java.io.Serializable {


     private Integer wardId;
     private Union union;
     private String wardName;
     private Set voteCenters = new HashSet(0);
     private Set voterInfos = new HashSet(0);

    public Ward() {
    }

    public Ward(Union union, String wardName, Set voteCenters, Set voterInfos) {
       this.union = union;
       this.wardName = wardName;
       this.voteCenters = voteCenters;
       this.voterInfos = voterInfos;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="ward_id", unique=true, nullable=false)
    public Integer getWardId() {
        return this.wardId;
    }
    
    public void setWardId(Integer wardId) {
        this.wardId = wardId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="union_id")
    public Union getUnion() {
        return this.union;
    }
    
    public void setUnion(Union union) {
        this.union = union;
    }

    
    @Column(name="ward_name", length=45)
    public String getWardName() {
        return this.wardName;
    }
    
    public void setWardName(String wardName) {
        this.wardName = wardName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ward")
    public Set getVoteCenters() {
        return this.voteCenters;
    }
    
    public void setVoteCenters(Set voteCenters) {
        this.voteCenters = voteCenters;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="ward")
    public Set getVoterInfos() {
        return this.voterInfos;
    }
    
    public void setVoterInfos(Set voterInfos) {
        this.voterInfos = voterInfos;
    }




}


