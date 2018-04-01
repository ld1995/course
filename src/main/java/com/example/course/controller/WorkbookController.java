package com.example.course.controller;

import com.example.course.dto.WorkbookDTO;
import com.example.course.models.workbook.Workbook;
import com.example.course.repository.WorkbookRepository;
import com.example.course.service.WorkbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
public class WorkbookController {

    @Autowired
    private WorkbookRepository workbookRepository;

    @Autowired
    private WorkbookService workbookService;

    @RequestMapping(value = "/api/public/workbook", method = RequestMethod.GET, produces = "application/json")
    public List<WorkbookDTO> getAllWorkbook() {
        return workbookService.getAllWorkbookDTO();
    }

    @RequestMapping(value = "/api/private/workbook", method = RequestMethod.POST, produces = "application/json")
    public void addWorkbook(@RequestBody Workbook workbook) {
        workbookService.addWorkbook(workbook);
    }
}
