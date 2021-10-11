package com.pribas.pribas;

import com.pribas.pribas.entity.MomentEntity;
import com.pribas.pribas.entity.TagEntity;
import com.pribas.pribas.entity.TimelineEntity;
import com.pribas.pribas.entity.UserEntity;
import com.pribas.pribas.repository.MomentEntityRepository;
import com.pribas.pribas.repository.TagEntityRepository;
import com.pribas.pribas.repository.TimelineEntityRepository;
import com.pribas.pribas.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    TimelineEntityRepository timelineEntityRepository;

    @Autowired
    TagEntityRepository tagEntityRepository;

    @Autowired
    UserEntityRepository userEntityRepository;

    @Autowired
    MomentEntityRepository momentEntityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        DateFormat dateHourFormat = new SimpleDateFormat("dd-MM-yy HH:mm");
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");

        UserEntity userEntity = new UserEntity();
        userEntity.setUserName("rahmanisaygin");
        userEntity.setEmail("rahmanisaygin@gmail.com");
        userEntity.setPassword("password");
        userEntityRepository.save(userEntity);

        TimelineEntity timelineEntity = new TimelineEntity();
        timelineEntity.setTitle("pribas gmbh history timeline");
        timelineEntity.setDescription("keeps important moments of pribas history");
        timelineEntity.setUserId(userEntity);
        timelineEntity.setCreationDate(dateFormat.parse("09-09-2021"));

        TagEntity tagEntity = new TagEntity();
        tagEntity.setName("business");
        TagEntity tagEntity1 = new TagEntity();
        tagEntity1.setName("work");
        TagEntity tagEntity2 = new TagEntity();
        tagEntity2.setName("pribas");

        List<TagEntity> tags = new ArrayList<>();
        tags.add(tagEntity);
        tags.add(tagEntity1);
        tags.add(tagEntity2);
        timelineEntity.setTags(tags);

        timelineEntityRepository.save(timelineEntity);

        List<MomentEntity> momentEntityList = new ArrayList<>();
        MomentEntity momentEntity = new MomentEntity();
        momentEntity.setTitle("company establishment");
        momentEntity.setDescription("pribas gmbh established in Frankfurt to provide IT solutions for airline industry");
        momentEntity.setMomentDate(dateHourFormat.parse("09-09-1990 14:00"));
        momentEntity.setCreationDate(dateFormat.parse("09-09-2021"));
        momentEntity.setTimelineId(timelineEntity.getId());

        MomentEntity momentEntity2 = new MomentEntity();
        momentEntity2.setTitle("proprietary b2b distribution");
        momentEntity2.setDescription("started proprietary b2b distribution");
        momentEntity2.setMomentDate(dateHourFormat.parse("01-06-1995 14:00"));
        momentEntity2.setCreationDate(dateFormat.parse("09-09-2021"));
        momentEntity2.setTimelineId(timelineEntity.getId());

        MomentEntity momentEntity3 = new MomentEntity();
        momentEntity3.setTitle("b2b booking UIs");
        momentEntity3.setDescription("first implementation of b2b booking UIs");
        momentEntity3.setMomentDate(dateHourFormat.parse("01-06-2000 14:00"));
        momentEntity3.setCreationDate(dateFormat.parse("09-09-2021"));
        momentEntity3.setTimelineId(timelineEntity.getId());

        momentEntityList.add(momentEntity);
        momentEntityList.add(momentEntity2);
        momentEntityList.add(momentEntity3);

        timelineEntity.setMoments(momentEntityList);
        timelineEntityRepository.save(timelineEntity);
    }
}
