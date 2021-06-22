package pl.coderslab.charity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.coderslab.charity.model.Donation;
import pl.coderslab.charity.model.Institution;
import pl.coderslab.charity.repository.CategoryRepository;
import pl.coderslab.charity.repository.DonationRepository;
import pl.coderslab.charity.repository.InstitutionRepository;
import pl.coderslab.charity.service.InstitutionService;

import java.util.List;
@Controller
@RequestMapping("index")
public class InstitutionController {

    final InstitutionService institutionService;

    final InstitutionRepository institutionRepository;
    public InstitutionController (InstitutionService institutionService, InstitutionRepository institutionRepository){
        this.institutionService = institutionService;
        this.institutionRepository = institutionRepository;

    }

    /*@GetMapping("/views/index.jsp")
    public String viewAllInstitutions(Model model) {
        List<Institution> institutionList = institutionService.listAllInstitutions();
        model.addAttribute("institutionList", institutionList);
        return "views/index.jsp";
    }

    @GetMapping("/index")
    public int getNumberOfInstitutions(Model model) {

        int institutionsNumber = institutionRepository.numberOfInstitutions();
        model.addAttribute("institutionsNumber", institutionsNumber);


        return institutionsNumber;
    }*/
}
