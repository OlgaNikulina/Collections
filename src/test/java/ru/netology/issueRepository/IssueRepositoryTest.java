package ru.netology.issueRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;
import ru.netology.domain.Issue;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUDRepositoryTest {
    IssueRepository repository = new IssueRepository();
    private List<Issue> issues = new ArrayList<>();
    private Issue first = new Issue(1, "", Set.of(), "", true, "", "", new Date());
    private Issue second = new Issue(2, "", Set.of(), "", true, "", "", new Date());
    private Issue third = new Issue(3, "", Set.of(), "", false, "", "", new Date());

    @BeforeEach
    public void setRepository(){
        repository.add(first);
        repository.add(second);
        repository.add(third);
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
        Issue issue = new Issue();
        int id = 2;
        repository.openById(id);
        repository.getById(id);
        assertTrue(true);
    }

    @Test
    void shouldNotOpenIfNotExist() {
        Issue issue = new Issue();
        int id = 4;
        repository.openById(id);
        repository.getById(id);
        assertThrows(RuntimeException.class, () -> repository.getById(id));
    }

    @Test
    void shouldCloseIfExist() {
        Issue issue = new Issue();
        int id = 2;
        repository.closeById(id);
        repository.getById(id);
        assertTrue(true);
    }

    @Test
    void shouldNotCloseIfNotExist() {
        Issue issue = new Issue();
        int id = 4;
        repository.closeById(id);
        repository.getById(id);
        assertThrows(RuntimeException.class, () -> repository.getById(id));

    }
}
