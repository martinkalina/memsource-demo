package cz.mkalina.memsourcedemo.service;

import cz.mkalina.memsourcedemo.client.MemsourceClient;
import cz.mkalina.memsourcedemo.dto.ProjectResponse;
import cz.mkalina.memsourcedemo.persistence.UserCredentials;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectsService {

    private final MemsourceClient client;

    private final UserCredentialsService credentialsService;

    public List<ProjectResponse> listProjects() {

        if (!client.isAuthenticated()) {
            UserCredentials userCredentials = credentialsService.load();
            client.authenticate(userCredentials.getName(), userCredentials.getPassword());
        }

        return client.listProjects().getContent();
    }

}
