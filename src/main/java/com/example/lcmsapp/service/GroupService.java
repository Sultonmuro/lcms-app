package com.example.lcmsapp.service;

import com.example.lcmsapp.dto.ApiResponse;
import com.example.lcmsapp.dto.GroupDto;
import com.example.lcmsapp.dto.ResGroupDto;
import com.example.lcmsapp.entity.Course;
import com.example.lcmsapp.entity.Fillial;
import com.example.lcmsapp.entity.Group;
import com.example.lcmsapp.exception.ResourceNotFoundException;
import com.example.lcmsapp.repository.CourseRepository;
import com.example.lcmsapp.repository.FillialRepository;
import com.example.lcmsapp.repository.GroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.stream.Collectors;

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

    public ApiResponse delete(Long id) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Group", "id", id));
        groupRepository.delete(group);

        if(!groupRepository.existsById(id)) return  new ApiResponse("BUnday idli guruh yo'q!",false);
        return ApiResponse.builder().success(true).message("deleted").build();
    }

    public ApiResponse update(Long id, GroupDto groupDto) {
        Group group = groupRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("group", "id", id));
        Fillial filial = fillialRepository.findById(groupDto.getFilialId()).orElseThrow(() -> new ResourceNotFoundException("filial", "id", groupDto.getFilialId()));
        Course course = courseRepository.findById(groupDto.getCourseId()).orElseThrow(() -> new ResourceNotFoundException("course", "id", groupDto.getCourseId()));

        group.setName(groupDto.getName());
        group.setCourse(course);
        group.setFilial(filial);
        Group save = groupRepository.save(group);
        return ApiResponse.builder().success(true).message("Edited!").data(save).build();
    }


    public ApiResponse<?> findAll(int page, int size, String search, String filialName, String courseName) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Group> data = null;

        //findAll 1-variant
        if (search.equals("") && filialName.equals("") && courseName.equals("")) {
            data = groupRepository.findAll(pageable);
        }
//        //page va size 2-pageable
//        else if (search.equals("") && filialName.equals("") && courseName.equals("")) {
//            //Pageable
//            data = groupRepository.findAll(pageable);
//        }
        //search 3-variant
//        else if (filialName.equals("") && courseName.equals("")) {
//            data = groupRepository.findAllByNameContainingIgnoreCase(search, pageable);
//        }
//        //filialName 4-variant
//        else if (search.equals("") && courseName.equals("")) {
//            data = groupRepository.findAllByFilial_NameContainingIgnoreCase(filialName, pageable);
//        }
//        //coruseName 5-variant
//        else if (search.equals("") && filialName.equals("")) {
//            data = groupRepository.findAllByCourse_NameContainingIgnoreCase(courseName, pageable);
//        }
        else {
            data = groupRepository.findAllByFilial_NameContainingIgnoreCaseAndCourse_NameContainingIgnoreCaseAndNameContainingIgnoreCase(filialName, courseName, search, pageable);
        }
        return ApiResponse.builder().data(toDTOPage(data)).message("OK").success(true).build();
    }
    //mapToDTO Group -> GroupDTO
    public ResGroupDto toDTO (Group group) {
        return ResGroupDto.builder()
                .name(group.getName())
                .courseName(group.getCourse().getName())
                .fillialName(group.getFilial().getName())
                .build();
    }

    //mapTODTOList -> toDTOPAGE
    public Page<ResGroupDto> toDTOPage(Page<Group> groups) {
        List<ResGroupDto> collect = groups.stream().map(this::toDTO).collect(Collectors.toList());
        return new PageImpl<>(collect);
    }
    }

