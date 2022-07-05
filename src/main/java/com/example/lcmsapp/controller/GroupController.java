package com.example.lcmsapp.controller;

import com.example.lcmsapp.dto.ApiResponse;
import com.example.lcmsapp.dto.GroupDto;
import com.example.lcmsapp.entity.Group;
import com.example.lcmsapp.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/group")
@RequiredArgsConstructor
public class GroupController {
  private final GroupService groupService;

  @PostMapping
  public ResponseEntity<?> save(@Valid @RequestBody GroupDto groupDto){
  ApiResponse apiResponse =  groupService.add(groupDto);
return ResponseEntity.status(apiResponse.isSuccess() ? 201 : 409).body(apiResponse);
  }
  @GetMapping("/{id}")
  public ResponseEntity<?> getOne(@PathVariable Long id){
    ApiResponse<Group> one = groupService.getOne(id);
    return ResponseEntity.ok(one);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<?> delete(@PathVariable Long id){
    ApiResponse delete = groupService.delete(id);

    return  ResponseEntity.status(delete.isSuccess() ? 200:404).body(delete);
  }
@PutMapping("/{id}")
  public ResponseEntity<?> update(@PathVariable Long id,@Valid @RequestBody GroupDto groupDto){
  ApiResponse update = groupService.update(id, groupDto);
  return ResponseEntity.status(update.isSuccess() ?202 : 404).body(update);
}
@GetMapping
  public ResponseEntity<?> findAll(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "") String search, @RequestParam(value = "filial", defaultValue = "") String filialName, @RequestParam(value = "course", defaultValue = "") String courseName ){
  ApiResponse<?> all = groupService.findAll(page, size, search, filialName, courseName);
  return ResponseEntity.ok(all);
}
}
