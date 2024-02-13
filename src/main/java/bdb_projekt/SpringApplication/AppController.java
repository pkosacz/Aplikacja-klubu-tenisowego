package bdb_projekt.SpringApplication;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;

@Configuration
public class AppController implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");
        registry.addViewController("/register").setViewName("register");
        registry.addViewController("/korty").setViewName("korty");
        registry.addViewController("/userKorty").setViewName("user/userKorty");
        registry.addViewController("/aktywnosci").setViewName("aktywnosci");
        registry.addViewController("/aktywnosciKortu").setViewName("user/aktywnosciKortu");
        registry.addViewController("/new_korty_tenisowe").setViewName("admin/korty_new_form");
        registry.addViewController("/edit_korty_tenisowe").setViewName("admin/korty_edit_form");
        registry.addViewController("/adminKorty").setViewName("admin/adminKorty");
        registry.addViewController("/adminAktywnosci").setViewName("admin/adminAktywnosci");
        registry.addViewController("/new_aktywnosci").setViewName("admin/aktywnosci_new_form");
        registry.addViewController("/edit_aktywnosci").setViewName("admin/aktywnosci_edit_form");
        registry.addViewController("/userIndex").setViewName("user/userIndex");
        registry.addViewController("/adminIndex").setViewName("admin/adminIndex");
    }

    @Controller
    public class DashboardController {

        @RequestMapping("/main")
        public String defaultAfterLogin(HttpServletRequest request) {
            if (request.isUserInRole("ADMIN")) {
                return "redirect:/main_admin";
            } else if (request.isUserInRole("USER")) {
                return "redirect:/main_user";
            } else {
                return "redirect:/index";
            }
        }

    }

    @Controller
    public class RegistrationController {

        @RequestMapping(value = {"/register"}, method = RequestMethod.GET)
        public String showRegistrationPage(Model model) {

            return "register";
        }


    }
}
