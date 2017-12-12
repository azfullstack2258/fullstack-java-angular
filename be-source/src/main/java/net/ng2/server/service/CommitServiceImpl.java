package net.ng2.server.service;

import net.ng2.server.dto.CommitDTO;
import net.ng2.server.mapper.CommitMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.PageIterator;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.RepositoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class CommitServiceImpl implements BaseCommitService {

    final static Logger LOG = LoggerFactory.getLogger(CommitServiceImpl.class);

    CommitMapper commitMapper = new CommitMapper();

    @Override
    public Page<CommitDTO> findCommits(Pageable pageable) {
    		GitHubClient client = new GitHubClient();
    		client.setCredentials("futureweb2020", "jogelbel&59");
    	
    		List<CommitDTO> last25Commits = new ArrayList<CommitDTO>();
	    	try {
	    		RepositoryService repoService = new RepositoryService(client);
	    		Repository repository = repoService.getRepository("angular", "angular");
	    		CommitService commitService = new CommitService(client);
	    		PageIterator<RepositoryCommit> pages = commitService.pageCommits(repository, 25);
	    		if (pages.hasNext()) {
		    		last25Commits = pages
		    				.next()
		    				.stream()
		    				.map(commit -> commitMapper.toDTO(commit))
		    				.collect(Collectors.toList());
	    		}
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    	}
    		
    		return new PageImpl<CommitDTO>(last25Commits);
    }
}
