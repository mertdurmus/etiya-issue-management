package com.etiya.exercise.service;

import com.etiya.exercise.dto.IssueDto;
import com.etiya.exercise.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete (IssueDto issue);

    Boolean delete (Long id);
}
