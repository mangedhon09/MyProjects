package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_ACTOR")
@Data
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Actor {
@Id
@SequenceGenerator(name="gen1",sequenceName="ACTOR_SEQ",initialValue=1000,allocationSize=1)
@GeneratedValue(generator="gen1",strategy=GenerationType.SEQUENCE)
private Integer aid;
@NonNull
@Column(length=30)
private String aname;
@NonNull
@Column(length=30)
private String addrs;
@NonNull
private Double fee;
@NonNull
@Column(length=30)
private String category;
//METADATA COLUMNS
@CreationTimestamp
@Column(updatable=false)
private LocalDateTime createDate;//time stamp feature

@UpdateTimestamp
@Column(insertable=false)
private LocalDateTime updateDate;
@Version
private Integer updateCount;//versioning feature
@Column(length=20 ,updatable=false)
private String createdBy;
@Column(length=20 ,insertable=false)
 private String updatedBy;
 
}
