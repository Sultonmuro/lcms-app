package com.example.lcmsapp.service;

import com.example.lcmsapp.dto.ApiResponse;
import com.example.lcmsapp.dto.GroupDto;
import com.example.lcmsapp.entity.Course;
import com.example.lcmsapp.entity.Fillial;
import com.example.lcmsapp.entity.Group;
import com.example.lcmsapp.exception.ResourceNotFoundException;
import com.example.lcmsapp.repository.CourseRepository;
import com.example.lcmsapp.repository.FillialRepository;
import com.example.lcmsapp.repository.GroupRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final FillialRepository fillialRepository;
    private final CourseRepository courseRepository;
    public ApiResponse add(GroupDto groupDto) {
        Fillial fillial = fillialRepository.findById(groupDto.getFilialId()).orElseThrow();
        Course course = courseRepository.findById(groupDto.getCourseId()).orElseThrow();
        Group group = new Group();
        group.setCourse(course);
        group.setFilial(fillial);
        if(groupRepository.existsByNameAndFilial_IdAndCourse_Id(groupDto.getName(),groupDto.getFilialId(),groupDto.getCourseId()))
            throw  new RuntimeException("Bunday nomli guruh mavjud!");
        group.setName(group.getName());
        Group save = groupRepository.save(group);

        return ApiResponse.builder().data(save).message("SAved").success(true).build();

    }

    public ApiResponse<Group> getOne(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Group", "id", id));
return new ApiResponse<>(group,"Mana",true);

    }
}
