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
 * Union generated by hbm2java
 */
@Entity
@Table(name="union"
    ,catalog="evoting"
)
public class Union  implements java.io.Serializable {


     private Integer unionId;
     private Upazilla upazilla;
     private String unionName;
     private Set wards = new HashSet(0);

    public Union() {
    }

    public Union(Upazilla upazilla, String unionName, Set wards) {
       this.upazilla = upazilla;
       this.unionName = unionName;
       this.wards = wards;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="union_id", unique=true, nullable=false)
    public Integer getUnionId() {
        return this.unionId;
    }
    
    public void setUnionId(Integer unionId) {
        this.unionId = unionId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="upazilla_id")
    public Upazilla getUpazilla() {
        return this.upazilla;
    }
    
    public void setUpazilla(Upazilla upazilla) {
        this.upazilla = upazilla;
    }

    
    @Column(name="union_name", length=45)
    public String getUnionName() {
        return this.unionName;
    }
    
    public void setUnionName(String unionName) {
        this.unionName = unionName;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="union")
    public Set getWards() {
        return this.wards;
    }
    
    public void setWards(Set wards) {
        this.wards = wards;
    }




}

