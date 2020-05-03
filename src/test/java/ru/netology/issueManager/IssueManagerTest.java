package ru.netology.issueManager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Issue;
import ru.netology.issueRepository.IssueRepository;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class IssueManagerTest {
    IssueRepository repository = new IssueRepository();
    IssueManager manager = new IssueManager(repository);
    private List<Issue> issues = new ArrayList<>();
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
        manager.filterByAuthor("Juliette de Rancourt", Comparator.comparing(Issue::getAuthor));
    }

    @Test
    void filterByLabel() {
    }

    @Test
    void filterByAssignee() {
        manager.filterByAssignee("Stefan Bechtold", Comparator.comparing(Issue::getUserAssignee));
    }

    @Test
    void getIsOpened() {
        manager.getIsOpened();
    }

    @Test
    void getIsClosed() {
        manager.getIsClosed();
    }
}
