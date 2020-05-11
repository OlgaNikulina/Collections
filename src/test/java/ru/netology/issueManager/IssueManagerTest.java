package ru.netology.issueManager;

import jdk.jfr.Label;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AssertionsKt;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.issueRepository.IssueRepository;

import java.awt.*;
import java.util.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);
    private Issue first = new Issue(1, "Benedict Ritter", Set.of(), "Issue with no milestone", true, "Stefan Bechtold", "Improve documentation about @Execution and @ResourceLock", new Date());
    private Issue second = new Issue(2, "Juliette de Rancourt", Set.of(), "General backlog", true, "Stefan Bechtold", "Provide a less generic argument converter", new Date());
    private Issue third = new Issue(3, "Juliette de Rancourt", Set.of(), "5.x Backlog", false, "Juliette de Rancourt", "Support file system resources in @CsvFileSource", new Date());
    private Issue fourth = new Issue(4, "George Moraitis", Set.of(), "Issue with no milestone", false, "David Saff", "ParameterizedTest with varargs", new Date());

    @BeforeEach
    void setUp() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(fourth);
    }

    @Test
    void filterByAuthor() {
        List.of(first, second, third, fourth);
        final List<Issue> actual = manager.filterByAuthor("Juliette de Rancourt", Comparator.comparing(Issue::getAuthor));
        final List<Issue> expected = List.of(second, third);
        assertEquals(expected, actual);
    }

    @Test
    void filterByLabel() {
        List.of(first, second, third);
        final List<Issue> actual = manager.filterByLabel(Set.of());
        final List<Issue> expected = List.of();
        assertEquals(expected, actual);
    }

    @Test
    void filterByAssignee() {
        List.of(first, second, third, fourth);
        final List<Issue> actual = manager.filterByAssignee("Stefan Bechtold", Comparator.comparing(Issue::getUserAssignee));
        final List<Issue> expected = List.of(first, second);
        assertEquals(expected, actual);
    }

    @Test
    void getIsOpened() {
        List.of(first, second, third, fourth);
        final List<Issue> actual = manager.getIsOpened();
        final List<Issue> expected = List.of(first, second);
        assertEquals(expected, actual);
    }

    @Test
    void getIsClosed() {
        List.of(first, second, third, fourth);
        final List<Issue> actual = manager.getIsClosed();
        final List<Issue> expected = List.of(third, fourth);
        assertEquals(expected, actual);
    }
}
