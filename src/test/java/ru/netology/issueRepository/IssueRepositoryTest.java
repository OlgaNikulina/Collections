package ru.netology.issueRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.Date;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class IssueRepositoryTest {
    IssueRepository repository = new IssueRepository();
    private Issue first = new Issue(1, "", Set.of(), "", true, "", "", new Date());
    private Issue second = new Issue(2, "", Set.of(), "", false, "", "", new Date());
    private Issue third = new Issue(3, "", Set.of(), "", true, "", "", new Date());
    private Issue fourth = new Issue(4, "", Set.of(), "", false, "", "", new Date());

    @BeforeEach
    public void setRepository() {
        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.add(fourth);
    }

    @Test
    void shouldAddIssue() {
        Issue fifth = new Issue(5, "", Set.of(), "", false, "", "", new Date());
        repository.add(fifth);
        assertEquals(List.of(first, second, third, fourth, fifth), repository.getAll());
    }

    @Test
    void shouldAddTwoIssues() {
        Issue fifth = new Issue();
        Issue sixth = new Issue();
        repository.addAll(List.of(fifth, sixth));
        assertEquals(List.of(first, second, third, fourth, fifth, sixth), repository.getAll());
    }

    @Test
    void shouldRemove() {
        repository.remove(second);
        assertNull(repository.getById(2));
    }

    @Test
    void shouldRemoveAll() {
        repository.removeAll(List.of(first, second, third, fourth));
        assertEquals(List.of(), repository.getAll());
    }

    @Test
    void shouldOpenIfExist() {
        int id = 2;
        repository.add(second);
        repository.openById(id);
        boolean expected = repository.getById(2).isOpened();
        assertTrue(expected);
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
        repository.add(third);
        repository.closeById(id);
        repository.getById(3);
        boolean expected = repository.getById(3).isOpened();
        assertFalse(expected);
    }

    @Test
    void shouldNotCloseIfNotExist() {
        int id = 5;
        repository.getById(id);
        assertThrows(RuntimeException.class, () -> repository.closeById(id));
    }
}
