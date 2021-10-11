package com.pribas.pribas.api;

import com.pribas.pribas.dto.MomentDTO;
import com.pribas.pribas.entity.MomentEntity;
import com.pribas.pribas.service.MomentService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/moment")
@RequiredArgsConstructor
public class MomentController {

    private final MomentService momentService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody MomentEntity momentEntity) {
        momentService.add(momentEntity);
        return ResponseEntity.ok("Moment Added");
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody MomentEntity momentEntity) {
        momentService.add(momentEntity);
        return ResponseEntity.ok("Moment updated");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable long id) {
        momentService.delete(id);
        return ResponseEntity.ok("Moment deleted");
    }

    @GetMapping("/get")
    @ResponseBody
    public List<MomentDTO> get(
            @RequestParam(name = "momentDate", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") Date momentDate,
            @RequestParam(name = "momentDateStart", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") Date momentDateStart,
            @RequestParam(name = "momentDateEnd", required = false) @DateTimeFormat(pattern = "dd-MM-yyyy HH:mm") Date momentDateEnd) {

        return momentService.get(momentDate, momentDateStart, momentDateEnd);
    }
}
