package codeservice.service;

import javax.security.auth.login.Configuration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CodeService {

    public String mergeCode(String solution, String template) {
        // todo
        // mergeFiles of lines from solution and lines from template
        return solution + template;
    }

    public List<String> mergeFiles(List<String> solutionLines, List<String> templateLines) {
        // A set to store unique lines from the merged file
        Set<String> mergedLines = new HashSet<>();
        // riting lines from template, then from solution
        mergedLines.addAll(templateLines);
        for (String solutionLine : solutionLines) {
            if (!mergedLines.contains(solutionLine)) {
                mergedLines.add(solutionLine);
            }
        }

        List<String> mergedList = new ArrayList<>(mergedLines);
        return mergedList;
    }

    public void preprocessCodeAndParameters(String solution, String template, Configuration.Parameters parameters) {
        // todo
    }

    public String writeToFile(String mergedCode) {
        // todo
        return "/tmp/merged_code.java";
    }
}
