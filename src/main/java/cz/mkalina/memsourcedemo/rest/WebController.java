package cz.mkalina.memsourcedemo.rest;

import cz.mkalina.memsourcedemo.dto.ConfigurationRequest;
import cz.mkalina.memsourcedemo.service.UserCredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final UserCredentialsService userCredentialsService;

    @PostMapping("/submit")
    public String configure(@ModelAttribute ConfigurationRequest configurationRequest, Model model){

        userCredentialsService.store(configurationRequest.getUserName(), configurationRequest.getPassword());

        return "projects";
    }


}
