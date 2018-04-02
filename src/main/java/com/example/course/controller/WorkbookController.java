package com.example.course.controller;

import com.example.course.dto.WorkbookDTO;
import com.example.course.models.workbook.Workbook;
import com.example.course.service.WorkbookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
public class WorkbookController {

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
