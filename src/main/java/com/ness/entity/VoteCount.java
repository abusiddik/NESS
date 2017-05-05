package com.ness.entity;
// Generated May 4, 2017 9:52:50 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * VoteCount generated by hbm2java
 */
@Entity
@Table(name="vote_count"
    ,catalog="evoting"
)
public class VoteCount  implements java.io.Serializable {


     private Integer voteCountId;
     private Integer candidateId;
     private String totalVote;

    public VoteCount() {
    }

    public VoteCount(Integer candidateId, String totalVote) {
       this.candidateId = candidateId;
       this.totalVote = totalVote;
    }
   
     @Id @GeneratedValue(strategy=IDENTITY)

    
    @Column(name="vote_count_id", unique=true, nullable=false)
    public Integer getVoteCountId() {
        return this.voteCountId;
    }
    
    public void setVoteCountId(Integer voteCountId) {
        this.voteCountId = voteCountId;
    }

    
    @Column(name="candidate_id")
    public Integer getCandidateId() {
        return this.candidateId;
    }
    
    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    
    @Column(name="total_vote", length=45)
    public String getTotalVote() {
        return this.totalVote;
    }
    
    public void setTotalVote(String totalVote) {
        this.totalVote = totalVote;
    }




}


