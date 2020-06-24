package rpa.backend.main.service;

import rpa.backend.main.dto.ApplyDTO;

import java.util.List;

public interface ApplyService {
    boolean apply(int id, String introduce, String study, String experience, String github);

    List<ApplyDTO> getList();

    ApplyDTO getDetail(int id);
}
