package bdb_projekt.SpringApplication.Aktywnosci;

import bdb_projekt.SpringApplication.Adresy.Adresy;
import bdb_projekt.SpringApplication.Adresy.Adresy_DAO;
import bdb_projekt.SpringApplication.KortyTenisowe.Korty_tenisowe;
import bdb_projekt.SpringApplication.KortyTenisowe.Korty_tenisowe_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AppControllerAktywnosci {

    @Autowired
    private Aktywnosci_DAO dao;
    @Autowired
    private Korty_tenisowe_DAO daok;


    @RequestMapping("/adminAktywnosci")
    public String viewAktywnosci(Model model){
        List<Aktywnosci> listAktywnosci = dao.list();
        model.addAttribute("listAktywnosci", listAktywnosci);
        return "admin/adminAktywnosci";
    }

    @RequestMapping("/aktywnosciKortu/{id_kortu}")
    public String viewAktywnosciKortu(@PathVariable int id_kortu, Model model){
        List<Aktywnosci> listAktywnosciKortu = dao.listAktywnosciKortu(id_kortu);
        model.addAttribute("listAktywnosciKortu", listAktywnosciKortu);
        model.addAttribute("id_kortu", id_kortu);
        return "user/aktywnosciKortu";
    }

    @RequestMapping("/adminAktywnosciKortu/{id_kortu}")
    public String viewAktywnosciKortu1(@PathVariable int id_kortu, Model model){
        List<Aktywnosci> listAktywnosciKortu = dao.listAktywnosciKortu(id_kortu);
        model.addAttribute("listAktywnosciKortu", listAktywnosciKortu);
        model.addAttribute("id_kortu", id_kortu);
        return "admin/adminAktywnosciKortu";
    }

    @RequestMapping("/new_aktywnosci")
    public String showNewForm(Model model){
        List<Korty_tenisowe> listKorty = daok.list();
        Aktywnosci aktywnosci = new Aktywnosci();
        model.addAttribute("aktywnosci", aktywnosci);
        model.addAttribute("listKorty", listKorty);

        System.out.println(listKorty);

        return "admin/aktywnosci_new_form";
    }

    @RequestMapping(value = "/save_aktywnosci", method = RequestMethod.POST)
    public String save(@ModelAttribute("aktywnosci") Aktywnosci aktywnosci){
        dao.save(aktywnosci);

        return "redirect:/adminAktywnosci";
    }

    @RequestMapping("/edit_aktywnosci_kortu/{numer_aktywnosci}")
    public ModelAndView showEditForm(@PathVariable(name = "numer_aktywnosci") int numer_aktywnosci){
        ModelAndView mav = new ModelAndView("admin/aktywnosci_edit_form");
        Aktywnosci aktywnosci = dao.get(numer_aktywnosci);
        List<Korty_tenisowe> listKorty = daok.list();
        mav.addObject("listKorty", listKorty);
        mav.addObject("aktywnosci", aktywnosci);

        return mav;
    }

    @RequestMapping(value = "/update_aktywnosci_kortu", method = RequestMethod.POST)
    public String update(@ModelAttribute("aktywnosci") Aktywnosci aktywnosci){
        dao.update(aktywnosci);

        return "redirect:/adminAktywnosci";
    }

    @RequestMapping("/delete_aktywnosci_kortu/{numer_aktywnosci}")
    public String delete(@PathVariable(name = "numer_aktywnosci") int numer_aktywnosci){
        dao.delete(numer_aktywnosci);

        return "redirect:/adminAktywnosci";
    }

}
