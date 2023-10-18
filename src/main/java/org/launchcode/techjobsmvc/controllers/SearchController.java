package org.launchcode.techjobsmvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.launchcode.techjobsmvc.models.Job;
import java.util.ArrayList;
import org.launchcode.techjobsmvc.models.JobData;

@Controller
@RequestMapping("search")
public class SearchController {

    @GetMapping(value = "")
    public String search(Model model) {
        model.addAttribute("columns", ListController.columnChoices);
        return "search";
    }

    @PostMapping(value = "results")
    public String displaySearchResults(Model model,
                                       @RequestParam String searchType,
                                       @RequestParam String searchTerm) {

        ArrayList<Job> jobs;

        if (searchTerm.toLowerCase().equals("all") || searchTerm.isEmpty()) {
            jobs = JobData.findAll();
        } else {
            String searchTermLower = searchTerm.toLowerCase();
            jobs = JobData.findByColumnAndValue(searchType, searchTermLower);
        } //should convert search term to lower

        model.addAttribute("jobs", jobs);
        model.addAttribute("columns", ListController.columnChoices);
        //model.addAttribute("tableChoices", JobData.findAllTableChoices());
        //model.addAttribute("searchType", searchType);
        model.addAttribute("title",
                "Jobs With " + ListController.columnChoices.get(searchType) + ": " + searchTerm);

        return "search";
    }
}