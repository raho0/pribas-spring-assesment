package com.pribas.pribas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@Table(name = "timeline")
public class TimelineEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "creationDate")
    @JsonFormat(locale = "tr", timezone = "GMT+3", pattern = "dd-MM-yyyy")
    private Date creationDate;

    @ManyToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity userId;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    List<TagEntity> tags;

    @OneToMany(targetEntity = MomentEntity.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "timelineId", referencedColumnName = "id", updatable = false)
    private List<MomentEntity> moments;

}
