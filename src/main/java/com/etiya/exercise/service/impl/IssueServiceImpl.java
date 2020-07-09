package com.etiya.exercise.service.impl;

import com.etiya.exercise.dto.IssueDto;
import com.etiya.exercise.entity.Issue;
import com.etiya.exercise.repository.IssueRepository;
import com.etiya.exercise.service.IssueService;
import com.etiya.exercise.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    //setter injection
    //@Autowired
    //private IssueRepository issueRepository;


    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {

        Issue issueDb = modelMapper.map(issue, Issue.class);
        issueDb =  issueRepository.save(issueDb);
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        Issue issueDb =  issueRepository.getOne(id);
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
    Page<Issue> data = issueRepository.findAll(pageable);
    TPage page = new TPage<IssueDto>();
    IssueDto[] dtos = modelMapper.map(data.getContent(),IssueDto[].class);
    page.setStat(data, Arrays.asList(dtos));
    return page;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }

    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return true;
    }
}
