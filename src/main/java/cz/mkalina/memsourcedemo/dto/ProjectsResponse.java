package cz.mkalina.memsourcedemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectsResponse {

    private int pageNumber;
    private int numberOfElements;
    private int totalElements;
    private int pageSize;
    private int totalPages;
    private List<ProjectResponse> content;
}
