package com.pribas.pribas.dto.converter;

import com.pribas.pribas.dto.MomentDTO;
import com.pribas.pribas.entity.MomentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MomentEntityToDTO {
    public static List<MomentDTO> of(List<MomentEntity> momentEntities){
        List<MomentDTO> dtoList = new ArrayList<>();
        for (MomentEntity momentEntity: momentEntities) {
            MomentDTO momentDTO = new MomentDTO();
            momentDTO.setTitle(momentEntity.getTitle());
            momentDTO.setDescription(momentEntity.getDescription());
            momentDTO.setCreation_date(momentEntity.getCreationDate());
            momentDTO.setMoment_date(momentEntity.getMomentDate());
            dtoList.add(momentDTO);
        }
        return dtoList;
    }
}
