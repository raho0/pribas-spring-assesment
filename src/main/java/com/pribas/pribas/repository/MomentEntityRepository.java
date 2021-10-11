package com.pribas.pribas.repository;

import com.pribas.pribas.entity.MomentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MomentEntityRepository extends JpaRepository<MomentEntity, Long> {
    List<MomentEntity> findAllByMomentDate(Date momentDate);
    List<MomentEntity> findAllByMomentDateBetween(Date momentDateStart, Date momentDateEnd);
    List<MomentEntity> findAllByMomentDateAfter(Date momentDateStart);
    List<MomentEntity> findAllByMomentDateBefore(Date momentDateEnd);
}
