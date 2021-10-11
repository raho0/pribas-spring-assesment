package com.pribas.pribas.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "moment")
public class MomentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long timelineId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "moment_date")
    @JsonFormat(locale = "tr", timezone = "GMT+3", pattern = "dd-MM-yyyy HH:mm")
    private Date momentDate;

    @Column(name = "creation_date")
    @JsonFormat(locale = "tr", timezone = "GMT+3", pattern = "dd-MM-yyyy")
    private Date creationDate;

}
