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
    Issue issue = new Issue();

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
                List<Issue> tmp = new ArrayList<>(result.size() + 1);
                tmp.set(tmp.size() - 1, issue);
                result = tmp;
                return result;
            }
        }
        return null;
    }

    public List<Issue> filterByAuthor(String author, Comparator<Issue> comparator) {
        final List<Issue> issueList = filterBy((Issue issue) -> issue.getAuthor().equals(author));
        issueList.sort(comparator);

        return issueList;
    }

    public List<Issue> filterByLabel(Set<Label> labels, Comparator<Issue> comparator) {
        final List<Issue> issueList = filterBy((Issue issue) -> issue.getLabels().equals(labels));
        issueList.sort(comparator);
        return issueList;
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
                List<Issue> tmp = new ArrayList<>(result.size() + 1);
                tmp.set(tmp.size() - 1, issue);
                result = tmp;
                return result;
            }
        }
        return null;
    }

    public List<Issue> getIsClosed(boolean isOpened) {
        List<Issue> result = new ArrayList<>(0);
        for (Issue issue : repository.getAll()) {
            if (!issue.isOpened()) {
                List<Issue> tmp = new ArrayList<>(result.size() + 1);
                tmp.set(tmp.size() - 1, issue);
                result = tmp;
                return result;
            }
        }
        return null;
    }
}
