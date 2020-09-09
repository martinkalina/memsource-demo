package cz.mkalina.memsourcedemo.rest;

import cz.mkalina.memsourcedemo.dto.ProjectResponse;
import cz.mkalina.memsourcedemo.service.ProjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ProjectsService projectsService;

    @GetMapping("api/projects")
    public List<ProjectResponse> listProjects(){
        return projectsService.listProjects();
    }


}
