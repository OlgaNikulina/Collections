package ru.netology.comparator;

import ru.netology.domain.Issue;
import ru.netology.issueManager.IssueManager;

import java.util.Comparator;

public class SortByAssigneeAscComparator implements Comparator<Issue> {
    @Override
    public int compare(Issue t1, Issue t2) {
        return t1.getUserAssignee().compareTo(t2.getUserAssignee());
    }
}
