package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
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
    private String timeOfCreation;

    @Override
    public boolean test(Issue issues) {
        return false;
    }

    @Override
    public Predicate<Issue> and(Predicate<? super Issue> other) {
        return null;
    }

    @Override
    public Predicate<Issue> negate() {
        return null;
    }

    @Override
    public Predicate<Issue> or(Predicate<? super Issue> other) {
        return null;
    }
}
