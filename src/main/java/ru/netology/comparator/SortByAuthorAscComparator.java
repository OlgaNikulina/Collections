package ru.netology.comparator;

import ru.netology.domain.Issue;

import java.util.Comparator;

public class SortByAuthorAscComparator implements Comparator<Issue> {
    @Override
    public int compare(Issue t1, Issue t2) {
        return t1.getAuthor().compareTo(t2.getAuthor());
    }
}
