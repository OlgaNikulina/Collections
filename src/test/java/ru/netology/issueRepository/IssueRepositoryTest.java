package ru.netology.issueRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUDRepositoryTest {
    IssueRepository repository = new IssueRepository();
    private List<Issue> issues = new ArrayList<>();


    @Nested
    public class Empty {

    }

    @Nested
    public class SingleIssue {

    }

    @Nested
    public class MultipleIssues {

    }

    @Test
    void shouldAddIssue() {
        repository.add(new Issue());
    }

    @Test
    void shouldAddTwoIssues() {
        repository.addAll(List.of(new Issue(), new Issue()));
    }

    @Test
    void shouldRemove() {
        repository.remove(new Issue());
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll(List.of(new Issue()));
    }

    @Test
    void shouldOpenIfExist() {
        int id = 5;
        repository.openById(id);
    }

    @Test
    void shouldNotOpenIfNotExist() {
        int id = 1005;
        repository.openById(id);
    }

    @Test
    void shouldCloseIfExist() {
        int id = 5;
        repository.closeById(id);
    }

    @Test
    void shouldNotCloseIfNotExist() {
        int id = 1005;
        repository.closeById(id);
    }
}
