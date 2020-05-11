package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue {
    private int id;
    private String author;
    private Set<Label> labels;
    private String milestone;
    private boolean isOpened;
    private String userAssignee;
    private String heading;
    private Date timeOfCreation;

}

