package com.pribas.pribas.dto.converter;

import com.pribas.pribas.dto.TimelineDTO;
import com.pribas.pribas.entity.TimelineEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TimelineEntityToDTO {
    public static List<TimelineDTO> of(List<TimelineEntity> timelineEntities) {
        List<TimelineDTO> dtoList = new ArrayList<>();
        for (TimelineEntity  timelineEntity: timelineEntities) {
            TimelineDTO timelineDTO = new TimelineDTO();
            timelineDTO.setTitle(timelineEntity.getTitle());
            timelineDTO.setDescription(timelineEntity.getDescription());
            timelineDTO.setCreation_date(timelineEntity.getCreationDate());
            timelineDTO.setUser_id(timelineEntity.getUserId().getId());
            timelineDTO.setTags(timelineEntity.getTags().stream().map(TagEntityToDTO::of).collect(Collectors.toList()));
            timelineDTO.setMoments(MomentEntityToDTO.of(timelineEntity.getMoments()));
            dtoList.add(timelineDTO);
        }
        return dtoList;
    }
}
