package ru.netology.issueRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import ru.netology.domain.Issue;

import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUDRepositoryTest {
    IssueRepository repository = new IssueRepository();
    private List<Issue> issues = new ArrayList<>();
    private Issue first = new Issue(1, "", Set.of(), "", true, "", "", new Date());
    private Issue second = new Issue(2, "", Set.of(), "", true, "", "", new Date());
    private Issue third = new Issue(3, "", Set.of(), "", false, "", "", new Date());
    private Issue fourth = new Issue(4, "", Set.of(), "", false, "", "", new Date());

    @BeforeEach
    public void setRepository() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
    }


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
        int id = 2;
        repository.getById(id);
        assertTrue(repository.openById(id));
    }

    @Test
    void shouldNotOpenIfNotExist() {
        int id = 5;
        repository.getById(id);
        assertThrows(RuntimeException.class, () -> repository.openById(id));
    }

    @Test
    void shouldCloseIfExist() {
        int id = 3;
        repository.getById(id);
        assertTrue(repository.closeById(id));
    }

    @Test
    void shouldNotCloseIfNotExist() {
        int id = 5;
        repository.getById(id);
        assertThrows(RuntimeException.class, () -> repository.closeById(id));
    }
}
