package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.function.Predicate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Issues implements Predicate<Issues> {
    private int id;
    private String author;
    private String label;
    private String milestone;

    @Override
    public boolean test(Issues issues) {
        return false;
    }

    @Override
    public Predicate<Issues> and(Predicate<? super Issues> other) {
        return null;
    }

    @Override
    public Predicate<Issues> negate() {
        return null;
    }

    @Override
    public Predicate<Issues> or(Predicate<? super Issues> other) {
        return null;
    }
}
