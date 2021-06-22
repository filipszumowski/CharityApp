package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;

@Controller
public class HomeController {

    final CategoryRepository categoryRepository;
    final DonationRepository donationRepository;
    final InstitutionRepository institutionRepository;
    final InstitutionService institutionService;

    public HomeController(InstitutionService institutionService, DonationRepository donationRepository, CategoryRepository categoryRepository, InstitutionRepository institutionRepository) {
        this.donationRepository = donationRepository;
        this.categoryRepository = categoryRepository;
        this.institutionRepository = institutionRepository;
        this.institutionService = institutionService;
    }

    @GetMapping("")
    public String viewHomepage(Model model) {
        List<Institution> institutionList = institutionService.listAllInstitutions();
        model.addAttribute("institutionList", institutionList);
        Integer institutionsNumber = institutionRepository.numberOfInstitutions();
        model.addAttribute("institutionsNumber", institutionsNumber == null ? 0 : institutionsNumber);
        Integer allQuantity = donationRepository.sumQuantity();
        model.addAttribute("allQuantity", allQuantity == null ? 0 : allQuantity);
        return "/index";
    }

   /* @GetMapping("/index")
    public int getNumberOfInstitutions(Model model) {

        int institutionsNumber = institutionRepository.numberOfInstitutions();
        model.addAttribute("institutionsNumber", institutionsNumber);


        return institutionsNumber;
    }*/
}
