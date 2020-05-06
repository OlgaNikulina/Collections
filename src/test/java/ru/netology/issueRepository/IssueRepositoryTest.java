package ru.netology.issueRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;

import java.util.*;
import java.util.List;
import java.util.function.BooleanSupplier;

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
        List.of(first, second, third, fourth);
        Issue fifth = new Issue(5, "", Set.of(), "", false, "", "", new Date());
        final boolean actual = repository.add(fifth);
        final List<Issue> expected = List.of(first, second, third, fourth, fifth);
        assertEquals(expected, actual);
    }

    @Test
    void shouldAddTwoIssues() {
        List.of(first, second);
        final boolean actual = repository.addAll(List.of(first, second));
        final List<Issue> expected = List.of(first, second);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemove() {
        List.of(first, second, third, fourth);
        final boolean actual = repository.remove(second);
        final List<Issue> expected = List.of(first, third, fourth);
        assertEquals(expected, actual);
    }

    @Test
    void shouldRemoveAll() {
        List.of(first, second, third, fourth);
        final boolean actual = repository.removeAll(List.of(first));
        final List<Issue> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void shouldOpenIfExist() {
        int id = 2;
        repository.add(second);
        repository.openById(id);
        Issue actual = new Issue(2, "", Set.of(), "", true, "", "", new Date());
        assertEquals(repository.getById(2), actual);
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
        Issue actual = new Issue(3, "", Set.of(), "", false, "", "", new Date());
        assertEquals(repository.getById(3), actual);
    }

    @Test
    void shouldNotCloseIfNotExist() {
        int id = 5;
        repository.getById(id);
        assertThrows(RuntimeException.class, () -> repository.closeById(id));
    }
}
