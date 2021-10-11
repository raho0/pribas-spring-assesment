package com.pribas.pribas.api;

import com.pribas.pribas.dto.TimelineDTO;
import com.pribas.pribas.entity.TimelineEntity;
import com.pribas.pribas.service.TimelineService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/timeline")
@RequiredArgsConstructor
public class TimelineController {

    private final TimelineService timelineService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody TimelineEntity timeline) {
        timelineService.add(timeline);
        return ResponseEntity.ok("Timeline Created");
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody TimelineEntity timeline) {
        timelineService.add(timeline);
        return ResponseEntity.ok("Timeline updated");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @Transactional
    public ResponseEntity<String> delete(@PathVariable long id) {
        timelineService.delete(id);
        return ResponseEntity.ok("Timeline deleted");
    }

    @GetMapping("/get")
    @ResponseBody
    public List<TimelineDTO> get(
            @RequestParam(name = "creationDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date creationDate,
            @RequestParam(name = "creationDateStart", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date creationDateStart,
            @RequestParam(name = "creationDateEnd", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy") Date creationDateEnd) {

        return timelineService.get(creationDate, creationDateStart, creationDateEnd);
    }
}
