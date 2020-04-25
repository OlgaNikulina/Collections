package ru.netology.issueManager;

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

    public List<Issue> add(Issue issue, Comparator<Issue> comparator) {
        repository.add(issue);
        Arrays.sort(issue, comparator);
        return (List<Issue>) issue;
    }

    private List<Issue> filterBy(Predicate<Issue> predicate) {
        List<Issue> result = new ArrayList<>(0);
        for (Issue issues : repository.getAll()) {
            if (predicate.test(issue)) {
                List<Issue> tmp = new ArrayList<>(result.size() + 1);
                System.arraycopy(result, 0, tmp, 0, result.size());
                List<Issue> tmp (tmp.size() - 1) = issue;
                result = tmp;
                return result;
            }
        }
        return (List<Issue>) issue;
    }

    public List<Issue> filterByAuthor(String author, Comparator<Issue> comparator) {
        filterBy((Issue issue) -> issue.getAuthor().equals(author));
        Arrays.sort(issue, comparator);
        return (List<Issue>) issue;
    }

    public List<Issue> filterByLabel(Set<Label> labels, Comparator<Issue> comparator) {
        filterBy((Issue issue) -> issue.getLabels().equals(labels));
        Arrays.sort(issue, comparator);
        return (List<Issue>) issue;
    }

    public List<Issue> filterByAssignee(String userAssignee, Comparator<Issue> comparator) {
        filterBy((Issue issue) -> issue.getUserAssignee().equals(userAssignee));
        Arrays.sort(issue, comparator);
        return (List<Issue>) issue;
    }

    public List<Issue> getIsOpened(boolean isOpened) {
        for (Issue issue : repository.getAll()) {
            if (issue.isOpened()) {
                return (List<Issue>) issue;
            }
        }
        return null;
    }

    public List<Issue> getIsClosed(boolean isOpened) {
        for (Issue issue : repository.getAll()) {
            if (!issue.isOpened()) {
                return (List<Issue>) issue;
            }
        }
        return null;
    }
}
