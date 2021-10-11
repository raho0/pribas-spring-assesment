package com.pribas.pribas.repository;

import com.pribas.pribas.entity.TimelineEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TimelineEntityRepository extends JpaRepository<TimelineEntity, Long> {

    List<TimelineEntity> findAllByCreationDate(Date creationDate);
    List<TimelineEntity> findAllByCreationDateBetween(Date creationDateStart, Date creationDateEnd);
    List<TimelineEntity> findAllByCreationDateAfter(Date creationDateStart);
    List<TimelineEntity> findAllByCreationDateBefore(Date creationDateEnd);

}
