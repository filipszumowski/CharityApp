package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.coderslab.charity.model.Category;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;

import javax.validation.Valid;
import java.util.List;

@Controller
public class DonationController {

    final CategoryRepository categoryRepository;
    final DonationRepository donationRepository;
    final InstitutionRepository institutionRepository;

    public DonationController (DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository){
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
    }

    @GetMapping("/showForm")
    public String showNewDonationForm(Model model) {

        List<Category> listCat = categoryRepository.findAll();
        List<Institution> listInst = institutionRepository.findAll();

        model.addAttribute("donation", new Donation());
        model.addAttribute("listCat", listCat);
        model.addAttribute("listInst", listInst);

        return "form";
    }

    @RequestMapping(value = "/saveDonation", method = RequestMethod.POST)
    public String saveRace(@Valid @ModelAttribute("saveDonation") Donation donation,
                           BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "form";
        }

        donationRepository.save(donation);
        return "redirect:index";
    }
   /* @GetMapping("/index")
    public int getAllQuantity(Model model) {

        int allQuantity = donationRepository.sumQuantity();
        model.addAttribute("allQuantity", allQuantity);

        return allQuantity;
    }*/


}
