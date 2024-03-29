package com.codeup.practiceblog.controllers;

import com.codeup.practiceblog.models.Ad;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.codeup.practiceblog.repositories.AdRepository;

@AllArgsConstructor
@Controller
public class AdController {

//    Ad ad = new Ad("Amazing new product!", "The everything thing will solve all your problems! It will clean your floors, wash your dishes, cook your dinner, and walk your dog!");
//    Ad ad2 = new Ad("Latest flying car", "This new flying car will take off above traffic and save you time on your morning commute! No pilot license required!");
//    Ad ad3 = new Ad("Sunshine in a bottle", "Captured sunlight in a convenient recyclable bottle for all your natural lighting needs!");
//    List<Ad> ads = new ArrayList<>(List.of(ad, ad2, ad3));

    private final AdRepository adDao;

    @GetMapping("/ads")
    public String showAllAds(Model model){
        model.addAttribute("ads", adDao.findAll());
        return "/ads/index";
    }

    @GetMapping("/ads/{id}")
    public String showOneAd(@PathVariable long id, Model model) {
        Ad ad;
        if (adDao.findById(id).isPresent()) {
            ad = adDao.findById(id).get();
        }
        else {
            ad = new Ad("Ad not found", "");
        }
        model.addAttribute(ad);
        return "/ads/show";
    }

    @GetMapping("/ads/create")
    public String showCreateAdForm() {
        return "/ads/create";
    }

    @GetMapping("/ads/search")
    public String findAdByTitle(@RequestParam (name="search") String title, Model model) {
        model.addAttribute("results", adDao.findByTitle(title));
        return "index";
    }

    @PostMapping("/ads/create")
    public String handleAdSubmission(@RequestParam(name="title") String title, @RequestParam(name = "description") String description) {
        adDao.save(new Ad(title, description));
        return "redirect:/ads";
    }
}