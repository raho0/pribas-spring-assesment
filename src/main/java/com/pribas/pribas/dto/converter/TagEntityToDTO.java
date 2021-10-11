package com.pribas.pribas.dto.converter;

import com.pribas.pribas.entity.TagEntity;
import org.springframework.stereotype.Component;

@Component
public class TagEntityToDTO {
    public static String of(TagEntity tagEntity) {
        return tagEntity.getName();
    }
}
