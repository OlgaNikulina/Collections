package ru.netology.issueRepository;

import ru.netology.domain.Issues;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IssueRepository {

    private List<Issues> issues = new ArrayList<>();

    public List<Issues> getAll() {
        return issues;
    }

    public Issues getById(int id) {
        for (Issues issue : issues) {
            if (issue.getId() == id) {
                return issue;
            }
        }
        return null;
    }

    public boolean add(Issues issue) {
        return issues.add(issue);
    }

    public boolean remove(Issues item) {
        return issues.remove(item);
    }

    public boolean addAll(Collection<? extends Issues> items) {
        return this.issues.addAll(items);
    }

    public boolean removeAll(Collection<? extends Issues> items) {
        return this.issues.removeAll(items);
    }
}
