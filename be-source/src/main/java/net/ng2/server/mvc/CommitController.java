package net.ng2.server.mvc;

import net.ng2.server.dto.CommitDTO;
import net.ng2.server.service.BaseCommitService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


@RestController
@CrossOrigin
@RequestMapping(value = "/api/commit")
public class CommitController {

    final static Logger LOG = LoggerFactory.getLogger(CommitController.class);

    @Inject
    BaseCommitService commitService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<CommitDTO>> findAllCommit(Pageable pageable, HttpServletRequest req) {
        Page<CommitDTO> page = commitService.findCommits(pageable);
        return new ResponseEntity<>(page, HttpStatus.OK);
    }
}


