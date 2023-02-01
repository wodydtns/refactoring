package me.whiteship.refactoring._01_smell_mysterious_name._01_change_method_declaration;

import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;
import org.kohsuke.github.GitHubBuilder;

public class StudyDashboard {

    private Set<String> usernames = new HashSet<>();

    private Set<String> reviews = new HashSet<>();

    // studyReviews -> loadReviews로 변경
    private void loadReviews() throws IOException {
    	/*
    	 * main 메소드 내부에서 loadReviews로 위치 변경 
    	 * loadReviews()의 파라미터 제거 
    	 * */
    	GitHub gitHub = new GitHubBuilder().withOAuthToken("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").build();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        GHIssue issue = repository.getIssue(30);
        List<GHIssueComment> comments = issue.getComments();
        for (GHIssueComment comment : comments) {
            usernames.add(comment.getUserName());
            reviews.add(comment.getBody());
        }
    }

    public Set<String> getUsernames() {
        return usernames;
    }

    public Set<String> getReviews() {
        return reviews;
    }

    public static void main(String[] args) throws IOException {
        StudyDashboard studyDashboard = new StudyDashboard();
        studyDashboard.loadReviews();
        studyDashboard.getUsernames().forEach(System.out::println);
        studyDashboard.getReviews().forEach(System.out::println);
    }
}
