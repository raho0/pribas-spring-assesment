package com.pribas.pribas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class TimelineDTO {
    private String title;
    private String description;
    private Long user_id;
    @JsonFormat(locale = "tr", timezone = "GMT+3", pattern = "dd-MM-yyyy")
    private Date creation_date;
    private List<String> tags;
    private List<MomentDTO> moments;

}
