package net.ng2.server.dto;

import java.util.Date;

import org.eclipse.egit.github.core.RepositoryCommit;

public class CommitDTO  {
	
	private String sha;
	private String author;
	private String committer;
	private String commitMessage;
	private Date commitDate;
	private String authorAvatarUrl;
	
	public CommitDTO(RepositoryCommit commit) {
		this.sha = commit.getSha();
		this.author = commit.getAuthor().getLogin();
		this.authorAvatarUrl = commit.getAuthor().getAvatarUrl();
		this.committer = commit.getCommitter().getLogin();
		this.commitMessage = commit.getCommit().getMessage();
		this.commitDate = commit.getCommit().getAuthor().getDate();
	}
	
	public String getCommitMessage() {
		return commitMessage;
	}

	public void setCommitMessage(String commitMessage) {
		this.commitMessage = commitMessage;
	}

	public String getSha() {
		return sha;
	}
	
	public void setSha(String sha) {
		this.sha = sha;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getCommitter() {
		return committer;
	}

	public void setCommitter(String committer) {
		this.committer = committer;
	}

	public Date getCommitDate() {
		return commitDate;
	}

	public void setCommitDate(Date commitDate) {
		this.commitDate = commitDate;
	}

	public String getAuthorAvatarUrl() {
		return authorAvatarUrl;
	}

	public void setAuthorAvatarUrl(String authorAvatarUrl) {
		this.authorAvatarUrl = authorAvatarUrl;
	}
}
