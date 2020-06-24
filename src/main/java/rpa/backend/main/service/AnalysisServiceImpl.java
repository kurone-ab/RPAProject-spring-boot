package rpa.backend.main.service;

import org.springframework.stereotype.Service;
import rpa.backend.main.entity.Apply;
import rpa.backend.main.repository.ApplyRepository;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

@Service
public class AnalysisServiceImpl implements AnalysisService {
    private final ApplyRepository applyRepository;

    public AnalysisServiceImpl(ApplyRepository applyRepository) {
        this.applyRepository = applyRepository;
    }

    @Override
    //전체 지원자의 선택한 언어의 GitHub Repository Clone 진행
    public boolean allAnalysis(List<String> languageList) {
        List<Apply> applyList = this.applyRepository.findAll();
        for (Apply apply : applyList) {
            this.executeRobot(apply.getGithub(), apply.getUser().getName(), languageList);
        }
        return true;
    }

    //RPA Robot Console 실행
    private void executeRobot(String github, String name, List<String> languageList) {
        try {
            String[] command = new String[]{"powershell", "C:/Users/tjdwp/AppData/Local/UiPath/app-20.4.1/UiRobot.exe", "-f", "C:/Users/tjdwp/Documents/2020-1/rpa/GitClone/RepositoryAnalysis.xaml", "--input", "\\\"{'githubLink' : '" + github + "', 'languageList' : '" + this.convertArrayToString(languageList) + "'}\\\""};
            ProcessBuilder process = new ProcessBuilder(command);
            Process p = process.start();
            BufferedReader stdOut = new BufferedReader(new InputStreamReader(p.getErrorStream()));
            String result;
            while ((result = stdOut.readLine()) != null) {
                System.out.println(this.renameFolder(result, name));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private String convertArrayToString(List<String> languageList) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        for (String s : languageList) builder.append(this.addSingleQuote(s));
        builder.append("]");
        return builder.toString();
    }

    private String addSingleQuote(String origin) {
        return "\\'" + origin + "\\'";
    }

    private String addDoubleQuote(String origin) {
        return "\\\"" + origin + "\\\"";
    }

    private boolean renameFolder(String pre, String aft) {
        File file = new File(pre);
        return file.renameTo(new File(aft));
    }
}
