package ru.netology.issueManager;

import ru.netology.domain.Issues;
import ru.netology.issueRepository.IssueRepository;

import java.util.Arrays;
import java.util.function.Predicate;

public class IssueManager {
    private IssueRepository repository = new IssueRepository();
    private IssueManager manager = new IssueManager(repository);

    public IssueManager(IssueRepository repository) {
        this.repository = repository;
    }

    public Issues[] filterBy(String author, Predicate<Issues> predicate) {
        Issues[] result = new Issues[0];

        for (Issues issues : repository.getAll()) {
            if (matches(issues, author)) {
                Issues[] tmp = new Issues[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = issues;
                result = tmp;
            }
        }
        Arrays.sort(author);
        return result;
    }

    private boolean matches(Issues issues, String search) {
        if (issues.getAuthor().equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
