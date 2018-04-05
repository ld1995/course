package com.example.course.controller;

import com.example.course.dto.WorkbookDto;
import com.example.course.service.WorkbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController()
public class WorkbookController {

    @Autowired
    private WorkbookService workbookService;

    @GetMapping("/api/public/workbook")
    public List<WorkbookDto> getWorkbookList() {
        return workbookService.getWorkbookList();
    }

    @PostMapping("/api/private/workbook")
    public void addWorkbook(@RequestBody @Valid WorkbookDto workbookDTO) {
        workbookService.createWorkbook(workbookDTO);
    }

    @DeleteMapping("/api/private/workbook/{id}")
    public void deleteWorkbook(@PathVariable Long id) {
        workbookService.deleteWorkbook(id);
    }

    @GetMapping("/api/private/workbook/{id}")
    public WorkbookDto getWorkbook(@PathVariable Long id) {
        return workbookService.getWorkbook(id);
    }

    @PutMapping("/api/private/workbook")
    public void deleteWorkbook(@RequestBody @Valid WorkbookDto workbookDTO) {
        workbookService.updateWorkbook(workbookDTO);
    }

    @PostMapping("/api/private/workbook/user")
    public List<WorkbookDto> getWorkbookListBy(@RequestBody @NotNull String username) {
        System.out.println(username);
        return workbookService.getWorkbookByUsername(username);
    }
}
//@ResponseBody ResponseEntity<String>
