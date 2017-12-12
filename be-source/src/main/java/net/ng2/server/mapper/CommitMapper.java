package net.ng2.server.mapper;

import org.eclipse.egit.github.core.RepositoryCommit;

import net.ng2.server.dto.CommitDTO;

public class CommitMapper {

    public CommitDTO toDTO(RepositoryCommit commit) {
    		return new CommitDTO(commit);
    }

}
