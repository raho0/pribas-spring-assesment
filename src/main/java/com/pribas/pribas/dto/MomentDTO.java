package com.pribas.pribas.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@RequiredArgsConstructor
public class MomentDTO {
    private String title;
    private String description;
    @JsonFormat(locale = "tr", timezone = "GMT+3", pattern = "dd-MM-yyyy HH:mm")
    private Date moment_date;
    @JsonFormat(locale = "tr", timezone = "GMT+3", pattern = "dd-MM-yyyy")
    private Date creation_date;
}
