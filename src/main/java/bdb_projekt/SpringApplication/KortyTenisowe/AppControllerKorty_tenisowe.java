package bdb_projekt.SpringApplication.KortyTenisowe;

import bdb_projekt.SpringApplication.Adresy.Adresy;
import bdb_projekt.SpringApplication.Adresy.Adresy_DAO;
import bdb_projekt.SpringApplication.Aktywnosci.Aktywnosci;
import bdb_projekt.SpringApplication.Aktywnosci.Aktywnosci_DAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class AppControllerKorty_tenisowe {

    @Autowired
    private Korty_tenisowe_DAO dao;
    @Autowired
    private Adresy_DAO daoa;
    @Autowired
    private Aktywnosci_DAO daoak;

    class KortyAdresy{
        private Korty_tenisowe kortTenisowe;
        private Adresy adresy;

        public Korty_tenisowe getKortyTenisowe(){
            return kortTenisowe;
        }

        public void setKortyTenisowe(Korty_tenisowe kortyTenisowe){
            this.kortTenisowe = kortyTenisowe;
        }

        public Adresy getAdresy(){
            return adresy;
        }

        public void setAdresy(){
            this.adresy = adresy;
        }

        public KortyAdresy(Korty_tenisowe kortyTenisowe, Adresy adresy){
            this.kortTenisowe = kortyTenisowe;
            this.adresy = adresy;
        }

        @Override
        public String toString() {
            return "KortyAdresy{" +
                    "kortyTenisowe=" + kortTenisowe +
                    ", adresy=" + adresy +
                    '}';
        }
    }

    @RequestMapping("/korty")
    public String viewHomePage2(Model model){
        List<Korty_tenisowe> listKortyTenisowe = dao.list();
        List<Adresy> listAdresy = daoa.list();
        List<KortyAdresy> listKortyAdresy = new ArrayList<>();
        for (Korty_tenisowe lista1 : listKortyTenisowe){
            for (Adresy lista2 : listAdresy){
                if (lista1.getId_adresu() == lista2.getId_adresu()){
                    listKortyAdresy.add(new KortyAdresy(lista1, lista2));
                }
            }
        }
        model.addAttribute("listKortyAdresy", listKortyAdresy);
        return "korty";
    }

    @RequestMapping("/userKorty")
    public String viewHomePage(Model model){
        List<Korty_tenisowe> listKortyTenisowe = dao.list();
        List<Adresy> listAdresy = daoa.list();
        List<KortyAdresy> listKortyAdresy = new ArrayList<>();
        for (Korty_tenisowe lista1 : listKortyTenisowe){
            for (Adresy lista2 : listAdresy){
                if (lista1.getId_adresu() == lista2.getId_adresu()){
                    listKortyAdresy.add(new KortyAdresy(lista1, lista2));
                }
            }
        }
        model.addAttribute("listKortyAdresy", listKortyAdresy);
        return "user/userKorty";
    }

    @RequestMapping("/adminKorty")
    public String viewHomePage1(Model model){
        List<Korty_tenisowe> listKortyTenisowe = dao.list();
        List<Adresy> listAdresy = daoa.list();
        List<KortyAdresy> listKortyAdresy = new ArrayList<>();
        for (Korty_tenisowe lista1 : listKortyTenisowe){
            for (Adresy lista2 : listAdresy){
                if (lista1.getId_adresu() == lista2.getId_adresu()){
                    listKortyAdresy.add(new KortyAdresy(lista1, lista2));
                }
            }
        }
        model.addAttribute("listKortyAdresy", listKortyAdresy);
        return "admin/adminKorty";
    }

    @RequestMapping("/new_korty_tenisowe")
    public String showNewForm(Model model){
        Korty_tenisowe kortyTenisowe = new Korty_tenisowe();
        model.addAttribute("korty_tenisowe", kortyTenisowe);

        return "admin/korty_new_form";
    }

    @RequestMapping(value = "/save_korty_tenisowe", method = RequestMethod.POST)
    public String save(@ModelAttribute("korty_tenisowe") Korty_tenisowe korty_tenisowe) {
        dao.save(korty_tenisowe);

        return "redirect:/adminKorty";
    }

    @RequestMapping("/edit_kort/{id_kortu}")
    public ModelAndView showEditForm(@PathVariable(name = "id_kortu")int id_kortu){
        ModelAndView mav = new ModelAndView("admin/korty_edit_form");
        Korty_tenisowe korty_tenisowe = dao.get(id_kortu);
        mav.addObject("korty_tenisowe", korty_tenisowe);

        return mav;
    }

    @RequestMapping(value = "/update_korty", method = RequestMethod.POST)
    public String update(@ModelAttribute("korty_tenisowe") Korty_tenisowe korty_tenisowe) {
        dao.update(korty_tenisowe);

        return "redirect:/adminKorty";
    }

    @RequestMapping("/delete_kort/{id_kortu}")
    public String delete(@PathVariable(name = "id_kortu") int id_kortu) {
        dao.delete(id_kortu);


        return "redirect:/adminKorty";
    }

}
