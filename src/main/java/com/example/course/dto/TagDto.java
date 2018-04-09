package com.example.course.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
public class TagDto extends BasePersistenceDto {

    @NotNull
    @Length(max = 20)
    private String name;

    private List<Long> workbookListId = new ArrayList<>();
}
