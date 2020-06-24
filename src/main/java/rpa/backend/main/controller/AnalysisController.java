package rpa.backend.main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rpa.backend.main.service.AnalysisService;

import java.util.List;

@RestController
@RequestMapping("/analysis")
public class AnalysisController {
    private final AnalysisService analysisService;

    public AnalysisController(AnalysisService analysisService) {
        this.analysisService = analysisService;
    }


    @PostMapping("/list")
    public boolean allAnalysis(@RequestParam("languageList") List<String> languageList) {
        System.out.println(languageList);
        return this.analysisService.allAnalysis(languageList);
    }
}
