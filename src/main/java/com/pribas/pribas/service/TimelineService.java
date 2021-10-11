package com.pribas.pribas.service;

import com.pribas.pribas.dto.TimelineDTO;
import com.pribas.pribas.dto.converter.TimelineEntityToDTO;
import com.pribas.pribas.entity.TimelineEntity;
import com.pribas.pribas.repository.TimelineEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TimelineService {
    private final TimelineEntityRepository timelineEntityRepository;

    public void add(TimelineEntity timeline) {
        timelineEntityRepository.save(timeline);
    }

    public void delete(long id) {
        timelineEntityRepository.deleteById(id);
    }

    public List<TimelineDTO> get(Date creationDate, Date creationDateStart, Date creationDateEnd) {
        if (creationDate != null) {
            List<TimelineEntity> timelineEntities = timelineEntityRepository.findAllByCreationDate(creationDate);
            return TimelineEntityToDTO.of(timelineEntities);
        }
        else if (creationDateStart != null & creationDateEnd != null) {
            List<TimelineEntity> timelineEntities = timelineEntityRepository.findAllByCreationDateBetween(creationDateStart, creationDateEnd);
            return TimelineEntityToDTO.of(timelineEntities);
        }
        else if (creationDateStart != null) {
            List<TimelineEntity> timelineEntities = timelineEntityRepository.findAllByCreationDateAfter(creationDateStart);
            return TimelineEntityToDTO.of(timelineEntities);
        }
        else if (creationDateEnd != null) {
            List<TimelineEntity> timelineEntities = timelineEntityRepository.findAllByCreationDateBefore(creationDateEnd);
            return TimelineEntityToDTO.of(timelineEntities);
        }
        else {
            List<TimelineEntity> timelineEntities = timelineEntityRepository.findAll();
            return TimelineEntityToDTO.of(timelineEntities);
        }
    }
}
