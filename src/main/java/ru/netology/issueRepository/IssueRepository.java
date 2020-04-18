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

    public boolean openIssue(Issue issue ){
        return issue.isOpened();
    }
}
