package me.whiteship.refactoring._02_duplicated_code._06_pull_up_method;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class ReviewerDashboard extends Dashboard {

    public void printReviewers() throws IOException {
        // Get github issue to check homework
        Set<String> reviewers = new HashSet<>();
        GitHub gitHub = new GitHubBuilder().withOAuthToken("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").build();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);

        // Get reviewers
        issue.getComments().forEach(c -> reviewers.add(c.getUserName()));

        // Print reviewers
        reviewers.forEach(System.out::println);
    }

}
