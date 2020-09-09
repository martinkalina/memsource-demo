package cz.mkalina.memsourcedemo.client;

import cz.mkalina.memsourcedemo.dto.LoginRequest;
import cz.mkalina.memsourcedemo.dto.LoginResponse;
import cz.mkalina.memsourcedemo.dto.ProjectsResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;


@Component
public class MemsourceClient {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssZ");
    private final RestTemplate restTemplate;

    private MemsourceToken memSourceToken;

    public MemsourceClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void authenticate(String name, String password) {
        var response = restTemplate.postForObject("/auth/login", new LoginRequest(name, password), LoginResponse.class);
        memSourceToken = new MemsourceToken(response.getToken(), ZonedDateTime.parse(response.getExpires(), FORMATTER));
    }

    public boolean isAuthenticated(){
        return memSourceToken != null && memSourceToken.getExpires().isBefore(ZonedDateTime.now());
    }

    public ProjectsResponse listProjects() {
        return restTemplate.getForObject("/projects?token={token}",
                ProjectsResponse.class,
                memSourceToken.getToken());
    }
}
