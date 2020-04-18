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
    List<Issue> issues = new ArrayList<>();

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public List<Issue> add(Issue issue, Comparator<Issue> comparator ) {
        repository.add(issue);
        return (List<Issue>) issue;
        Arrays.sort(issue, comparator);
    }

    private Object filterBy(Predicate<Issue> predicate) {
        String search = "search";
        for (Issue issues : repository.getAll()) {
            if (matches(issues, search)) {
          return issues;
            }
        }
        return predicate.test(issue);
    }

    private boolean matches(Issue issues, String search) {
        return issue.equals(search);
    }

    public Object filterByAuthor(String author, Comparator<Issue> comparator){
        return filterBy((Issue issue) -> issue.getAuthor().equals(author));
        Arrays.sort(issue, comparator);
    }

    public Object filterByLabel(Set<Label> labels, Comparator<Issue> comparator){
        return filterBy((Issue issue) -> issue.getLabels().equals(labels));
        Arrays.sort(issue, comparator);
    }

    public Object filterByMilestone(String milestone, Comparator<Issue> comparator){
        return filterBy((Issue issue) -> issue.getMilestone().equals(milestone));
        Arrays.sort(issue, comparator);
    }

    public Object filterByAssignee(String userAssignee, Comparator<Issue> comparator){
        return filterBy((Issue issue) -> issue.getUserAssignee().equals(userAssignee));
        Arrays.sort(issue, comparator);
    }

    public Object filterByHeading(String heading, Comparator<Issue> comparator){
        return filterBy((Issue issue) -> issue.getHeading().equals(heading));
        Arrays.sort(issue, comparator);
    }

    public Object filterByTime(String timeOfCreation, Comparator<Issue> comparator){
        return filterBy((Issue issue) -> issue.getTimeOfCreation().equals(timeOfCreation));
        Arrays.sort(issue, comparator);
    }

    public Object getIsOpened(boolean isOpened) {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : issues) {
            if (issue.isOpened()) {
                return issue;
            }
        }
        return true;
    }

    public Object getIsClosed(boolean isOpened, Comparator<Issue> comparator) {
        List<Issue> issues = new ArrayList<>();
        for (Issue issue : issues) {
            if (!issue.isOpened()) {
                return issue;
            }
        }
        return true;
        Arrays.sort(issue, comparator);
    }
}
