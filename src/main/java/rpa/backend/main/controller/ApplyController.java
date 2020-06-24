package rpa.backend.main.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rpa.backend.main.service.ApplyService;

@RestController
public class ApplyController {
    private final ApplyService applyService;

    public ApplyController(ApplyService applyService) {
        this.applyService = applyService;
    }

    @PostMapping("/apply")
    //"/apply"으로 접속해 유저의 서류 지원 절차를 진행
    public boolean apply(@RequestParam("id") int id, @RequestParam("introduce") String introduce, @RequestParam("study") String study, @RequestParam("experience") String experience, @RequestParam("github") String github) {
        return this.applyService.apply(id, introduce, study, experience, github);
    }
}
