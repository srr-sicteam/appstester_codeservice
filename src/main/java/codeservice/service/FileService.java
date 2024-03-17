package codeservice.service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileService {

    public String mergeAllFiles(String solutionFolderPath, String templateFolderPath, String outputFolderPath) {
        try {
            File solutionFolder = new File(solutionFolderPath);
            File templateFolder = new File(templateFolderPath);
            File outputFolder = new File(outputFolderPath);

            if (!outputFolder.exists()) {
                outputFolder.mkdirs();
            }

            File[] solutionFiles = solutionFolder.listFiles();
            File[] templateFiles = templateFolder.listFiles();

            Map<String, String> templateFilePaths = new HashMap<>();
            for (File templateFile : templateFiles) {
                templateFilePaths.put(templateFile.getName(), templateFile.getAbsolutePath());
            }

            for (File solutionFile : solutionFiles) {
                // Check if there is a corresponding file in template
                String templateFilePath = templateFilePaths.get(solutionFile.getName());
                if (templateFilePath != null) {
                    mergeFiles(solutionFile.getAbsolutePath(), templateFilePath, outputFolderPath);
                }
            }

            return outputFolderPath;
        } catch (Exception e) {
            System.err.println("Error merging files: " + e.getMessage());
            return null;
        }
    }

    private void mergeFiles(String solutionFilePath, String templateFilePath, String outputFolderPath) throws IOException {
        // Read contents of solution and template files
        String solutionContent = readFile(solutionFilePath);
        String templateContent = readFile(templateFilePath);

        // Merge solution and template contents
        String mergedContent = merge(solutionContent, templateContent);

        // Write merged content to output file
        String outputFilePath = outputFolderPath + File.separator + new File(solutionFilePath).getName();
        writeToFile(outputFilePath, mergedContent);
    }

    private String readFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        StringBuilder content = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    private void writeToFile(String filePath, String content) throws IOException {
        FileWriter writer = new FileWriter(filePath);
        writer.write(content);
        writer.close();
    }

    private String merge(String solutionContent, String templateContent) {
        // Implement the logic to merge solution and template contents
        // For simplicity, we are just concatenating them
        return solutionContent + templateContent;
    }
}
