package com.park.Park.api;

import com.park.Park.model.Codes;
import com.park.Park.model.Users;
import com.park.Park.service.CodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/api/v1/code")
@RestController
public class CodeController {
    private final CodeService codeService;

    @Autowired
    public CodeController(CodeService codeService) {
        this.codeService = codeService;
    }

    @PostMapping(path = "/{userId}")
    public void generateCode(@NonNull @PathVariable("userId") UUID userId){
        codeService.generateCode(userId);
    }

    @GetMapping(path = "/{userId}")
    public Optional<Codes> getCodeByUserId(@PathVariable("userId")UUID userId){
        return codeService.getCodeByUserId(userId);
    }

    @DeleteMapping(path = "/{userId}")
    public void deleteCodeByUserId(@PathVariable("userId") UUID userId){
        codeService.deleteCode(userId);
    }
}
