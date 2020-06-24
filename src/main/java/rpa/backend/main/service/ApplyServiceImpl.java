package rpa.backend.main.service;

import org.springframework.stereotype.Service;
import rpa.backend.main.dto.ApplyDTO;
import rpa.backend.main.entity.Apply;
import rpa.backend.main.entity.User;
import rpa.backend.main.repository.ApplyRepository;
import rpa.backend.main.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ApplyServiceImpl implements ApplyService {
    private final ApplyRepository applyRepository;
    private final UserRepository userRepository;

    public ApplyServiceImpl(ApplyRepository applyRepository, UserRepository userRepository) {
        this.applyRepository = applyRepository;
        this.userRepository = userRepository;
    }

    @Override
    public boolean apply(int id, String introduce, String study, String experience, String github) {
        Optional<User> userOptional = this.userRepository.findById(id);
        if (userOptional.isEmpty()) return false;
        User user = userOptional.get();
        if (this.applyRepository.findByUser(user).isPresent()) return false;
        this.applyRepository.save(Apply.builder()
                .introduce(introduce)
                .experience(experience)
                .github(github)
                .study(study)
                .user(user)
                .build());
        return true;
    }

    @Override
    public List<ApplyDTO> getList() {
        List<Apply> applyList = this.applyRepository.findAll();
        List<ApplyDTO> applyDTOList = new ArrayList<>();
        for (Apply apply : applyList) {
            User user = apply.getUser();
            applyDTOList.add(ApplyDTO.builder()
                    .id(apply.getId())
                    .userName(user.getName())
                    .build());
        }
        return applyDTOList;
    }

    @Override
    public ApplyDTO getDetail(int id) {
        Optional<Apply> applyOptional = this.applyRepository.findById(id);
        if (applyOptional.isPresent()) {
            Apply apply = applyOptional.get();
            return ApplyDTO.builder()
                    .id(id)
                    .introduce(apply.getIntroduce())
                    .study(apply.getStudy())
                    .github(apply.getGithub())
                    .experience(apply.getExperience())
                    .build();
        }
        return ApplyDTO.builder().build();
    }
}
