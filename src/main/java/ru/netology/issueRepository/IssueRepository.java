package ru.netology.issueRepository;

import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {

    private List<Issue> issues = new ArrayList<>();

    public List<Issue> getAll() {
        return issues;
    }

    public Issue getById(int id) {
        for (Issue issue : issues) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        return null;
    }

    public boolean add(Issue issue) {
        return issues.add(issue);
    }

    public boolean remove(Issue item) {
        return issues.remove(item);
    }

    public boolean addAll(Collection<? extends Issue> items) {
        return this.issues.addAll(items);
    }

    public boolean removeAll(Collection<? extends Issue> items) {
        return this.issues.removeAll(items);
    }

    public boolean openById(int id) {
        final Issue issue = getById(id);
        if (issue == null) {
            throw new RuntimeException("Element with id: " + id + " not found");
        }
        issue.setOpened(true);
        return true;
    }

    public boolean closeById(int id) {
        final Issue issue = getById(id);
        if (getById(id) == null) {
            throw new RuntimeException("Element with id: " + id + " not found");
        }
        issue.setOpened(false);
        return true;
    }
}
