package cz.mkalina.memsourcedemo;

import cz.mkalina.memsourcedemo.client.MemsourceClient;
import cz.mkalina.memsourcedemo.dto.ProjectResponse;
import cz.mkalina.memsourcedemo.dto.ProjectsResponse;
import cz.mkalina.memsourcedemo.persistence.UserCredentials;
import cz.mkalina.memsourcedemo.persistence.UserCredentialsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MemsourceDemoApplicationTests {


	@Autowired
	private MockMvc mvc;

	@MockBean
	private MemsourceClient memsourceClient;

	@MockBean
	private UserCredentialsRepository userCredentialsRepository;

	@Test
	void test_get_projects() throws Exception {

		when(userCredentialsRepository.findById(eq(Long.valueOf(1))))
				.thenReturn(Optional.of(new UserCredentials("username", "password")));

		when(memsourceClient.isAuthenticated()).thenReturn(true);

		ProjectsResponse projectsResponse = new ProjectsResponse();
		projectsResponse.setContent(List.of(new ProjectResponse("TEST_NAME", "NEW", "cs_cz", List.of("en"))));
		when(memsourceClient.listProjects()).thenReturn(projectsResponse);

		mvc.perform(get("/api/projects?token=TEST_TOKEN"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name", equalTo("TEST_NAME")))
				.andExpect(jsonPath("$[0].status", equalTo("NEW")))
				.andExpect(jsonPath("$[0].sourceLang", equalTo("cs_cz")))
				.andExpect(jsonPath("$[0].targetLangs[0]", equalTo("en")))
		;
	}

}
