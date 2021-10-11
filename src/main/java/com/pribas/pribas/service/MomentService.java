package com.pribas.pribas.service;

import com.pribas.pribas.dto.MomentDTO;
import com.pribas.pribas.dto.converter.MomentEntityToDTO;
import com.pribas.pribas.entity.MomentEntity;
import com.pribas.pribas.repository.MomentEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MomentService {
    private final MomentEntityRepository momentEntityRepository;

    public void add(MomentEntity moment) {
        momentEntityRepository.save(moment);
    }

    public void delete(Long id) {
        momentEntityRepository.deleteById(id);
    }

    public List<MomentDTO> get(Date momentDate, Date momentDateStart, Date momentDateEnd) {
        if (momentDate != null) {
            List<MomentEntity> momentEntityList = momentEntityRepository.findAllByMomentDate(momentDate);
            return MomentEntityToDTO.of(momentEntityList);
        }
        else if (momentDateStart != null & momentDateEnd != null) {
            List<MomentEntity> momentEntityList = momentEntityRepository.findAllByMomentDateBetween(momentDateStart, momentDateEnd);
            return MomentEntityToDTO.of(momentEntityList);
        }
        else if (momentDateStart != null) {
            List<MomentEntity> momentEntityList = momentEntityRepository.findAllByMomentDateAfter(momentDateStart);
            return MomentEntityToDTO.of(momentEntityList);
        }
        else if (momentDateEnd != null) {
            List<MomentEntity> momentEntityList = momentEntityRepository.findAllByMomentDateBefore(momentDateEnd);
            return MomentEntityToDTO.of(momentEntityList);
        }
        else {
            List<MomentEntity> momentEntityList = momentEntityRepository.findAll();
            return MomentEntityToDTO.of(momentEntityList);
        }
    }
}
