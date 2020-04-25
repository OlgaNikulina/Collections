package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.CDATASection;

import java.awt.*;
import java.util.Date;
import java.util.Set;
import java.util.function.Predicate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issue implements Predicate<Issue> {
    private int id;
    private String author;
    private Set<Label> labels;
    private String milestone;
    private boolean isOpened;
    private String userAssignee;
    private String heading;
    private Date timeOfCreation;

    @Override
    public boolean test(Issue issues) {
        return false;
    }

}
