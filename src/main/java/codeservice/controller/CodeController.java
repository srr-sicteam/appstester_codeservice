package codeservice.controller;

import codeservice.model.CodeRequest;
import codeservice.service.CodeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CodeController {

    private final CodeService codeService;

    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @PostMapping("/merge")
    public ResponseEntity<String> merge(@RequestBody CodeRequest codeRequest) {
        try {
            String mergedCode = codeService.mergeCode(codeRequest.getSolution(), codeRequest.getTemplate());
            String tmpPath = codeService.writeToFile(mergedCode);
            return ResponseEntity.ok(tmpPath);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error merging code: " + e.getMessage());
        }
    }
}

