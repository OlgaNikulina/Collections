package ru.netology.issueManager;

import ru.netology.comparator.SortByAuthorAscComparator;
import ru.netology.domain.Issue;
import ru.netology.issueRepository.IssueRepository;

import java.awt.*;
import java.util.*;
import java.util.List;
import java.util.function.Predicate;

public class IssueManager {
    private IssueRepository repository;

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public void add(Issue issue) {
        repository.add(issue);
    }

    private List<Issue> filterBy(Predicate<Issue> predicate) {
        List<Issue> result = new ArrayList<>(0);
        for (Issue issue : repository.getAll()) {
            if (predicate.test(issue)) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> filterByAuthor(String author, Comparator<Issue> comparator) {
        final List<Issue> issueList = filterBy((Issue issue) -> issue.getAuthor().equals(author));
        issueList.sort(comparator);
        return issueList;
    }

    public List<Issue> filterByLabel(Set<Label> labels) {
        return filterBy((Issue issue) -> issue.getLabels().containsAll(labels));
    }

    public List<Issue> filterByAssignee(String userAssignee, Comparator<Issue> comparator) {
        final List<Issue> issueList = filterBy((Issue issue) -> issue.getUserAssignee().equals(userAssignee));
        issueList.sort(comparator);
        return issueList;
    }

    public List<Issue> getIsOpened() {
        List<Issue> result = new ArrayList<>(0);
        for (Issue issue : repository.getAll()) {
            if (issue.isOpened()) {
                result.add(issue);
            }
        }
        return result;
    }

    public List<Issue> getIsClosed() {
        List<Issue> result = new ArrayList<>(0);
        for (Issue issue : repository.getAll()) {
            if (!issue.isOpened()) {
                result.add(issue);
            }
        }
        return result;
    }
}
