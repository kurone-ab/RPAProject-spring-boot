package rpa.backend.main.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import rpa.backend.main.dto.ApplyDTO;
import rpa.backend.main.service.ApplyService;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    private final ApplyService applyService;

    public AdminController(ApplyService applyService) {
        this.applyService = applyService;
    }

    @GetMapping("/apply/list")
    public List<ApplyDTO> getApplyList() {
        return this.applyService.getList();
    }

    @GetMapping("/apply/detail")
    public ApplyDTO getDetail(@RequestParam("id") int id) {
        return this.applyService.getDetail(id);
    }
}
