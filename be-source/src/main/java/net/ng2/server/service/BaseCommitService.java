package net.ng2.server.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import net.ng2.server.dto.CommitDTO;

public interface BaseCommitService {

    Page<CommitDTO> findCommits(Pageable pageable);

}
