package com.pribas.pribas.api;

import com.pribas.pribas.entity.UserEntity;
import com.pribas.pribas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    @ResponseBody
    public ResponseEntity<String> add(@RequestBody UserEntity userEntity) {
        userService.add(userEntity);
        return ResponseEntity.ok("User Added");
    }

    @PutMapping("/update")
    @ResponseBody
    public ResponseEntity<String> update(@RequestBody UserEntity userEntity) {
        userService.add(userEntity);
        return ResponseEntity.ok("User updated");
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable long id) {
        userService.delete(id);
        return ResponseEntity.ok("User deleted");
    }

    @GetMapping("/get")
    @ResponseBody
    public List<UserEntity> get() {
        return userService.get();
    }
}
