package cz.mkalina.memsourcedemo.rest;

import cz.mkalina.memsourcedemo.dto.ConfigurationRequest;
import cz.mkalina.memsourcedemo.service.UserCredentialsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class WebController {

    private final UserCredentialsService userCredentialsService;

    @PostMapping("/submit")
    public ModelAndView configure(@ModelAttribute ConfigurationRequest configurationRequest, Model model) {

        var authenticated = userCredentialsService.store(configurationRequest.getUserName(), configurationRequest.getPassword());
        if (authenticated) {
            return new ModelAndView("projects");
        } else {
            model.addAttribute("error", "Invalid credentials");
            return new ModelAndView("index");
        }
    }


}
