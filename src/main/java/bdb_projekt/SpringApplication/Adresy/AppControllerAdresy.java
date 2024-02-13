package bdb_projekt.SpringApplication.Adresy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppControllerAdresy {

    @Autowired
    private Adresy_DAO dao;

    @RequestMapping({"/", "/index"})
    public String viewHomePage(Model model){
        List<Adresy> listAdresy = dao.list();
        model.addAttribute("listAdresy", listAdresy);
        return "index";
    }

    @RequestMapping("/new_adresy")
    public String showNewForm(Model model) {
        Adresy adresy = new Adresy();
        model.addAttribute("adresy", adresy);

        return "new_form";
    }

    @RequestMapping(value = "/save_adresy", method = RequestMethod.POST)
    public String save(@ModelAttribute("adresy") Adresy adresy) {
        System.out.println(adresy);
        dao.save(adresy);

        return "redirect:/";
    }

    @RequestMapping("/edit/{id_adresu}")
    public ModelAndView showEditForm(@PathVariable(name = "id_adresu") int id_adresu) {
        ModelAndView mav = new ModelAndView("edit_form");
        Adresy adresy = dao.get(id_adresu);
        mav.addObject("adresy", adresy);

        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(@ModelAttribute("adresy") Adresy adresy) {
        dao.update(adresy);
        System.out.println(adresy);

        return "redirect:/";
    }

    @RequestMapping("/delete/{id_adresu}")
    public String delete(@PathVariable(name = "id_adresu")int id_adresu) {
        dao.delete(id_adresu);

        return "redirect:/";
    }
}
