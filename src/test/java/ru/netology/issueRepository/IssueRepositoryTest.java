package ru.netology.issueRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.Nested;
import ru.netology.domain.Issue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CRUDRepositoryTest {
    IssueRepository repository = new IssueRepository();

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
        repository.remove(1);
    }

    @Test
    void shouldRemoveAll(){
        repository.removeAll(List.of(Issue()))
    }
}



