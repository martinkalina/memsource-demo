package cz.mkalina.memsourcedemo.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProjectResponse {
    private final String name;
    private final String status;
    private final String sourceLang;
    private final List<String> targetLangs;
}
