package com.example.sem4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/rockband")
public class BandController {
    private final BandRepository bandRepository;

    @Autowired
    public BandController(BandRepository bandRepository) {
        this.bandRepository = bandRepository;
    }

    @GetMapping("/bands")
    public String getAllBands(Model model){
        model.addAttribute("Группы", bandRepository.findAll());
        return "index";
    }

    @PostMapping("/add")
    public String addBand (@Valid RockBand rockBand, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            return "index";
        }
        bandRepository.save(rockBand);
        return "add-bands";
    }

    @GetMapping("/find/{id}")
    public String findById(@PathVariable("id") Long id, Model model){
        RockBand rockBand = bandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Некорректный id: "+ id));
        model.addAttribute("rockband", rockBand);
        return "band";
    }

    @PostMapping("/update/{id}")
    public String updateBand(@PathVariable("id") Long id, @Valid RockBand rockBand, BindingResult result, Model model){
        if(result.hasErrors()){
            rockBand.setId(id);
            return "update-band";
        }
        bandRepository.save(rockBand);
        model.addAttribute("bands", bandRepository.findAll());
        return "index";
    }

    @DeleteMapping("/delete/{id}")
    public void deleteBand(@PathVariable("id") Long id, Model model){
        RockBand rockBand = bandRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Некорректный id: "+ id));
        bandRepository.delete(rockBand);
    }
}
