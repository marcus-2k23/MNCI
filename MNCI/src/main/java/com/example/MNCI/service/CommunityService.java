package com.example.MNCI.service;

import com.example.MNCI.dto.CommunityDto;
import com.example.MNCI.exceptions.SpringMNCIException;
import com.example.MNCI.mapper.CommunityMapper;
import com.example.MNCI.model.Community;
import com.example.MNCI.repository.CommunityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;


@Service
@AllArgsConstructor
@Slf4j
public class CommunityService {

    private final CommunityRepository communityRepository;
    private final CommunityMapper communityMapper;

    @Transactional
    public CommunityDto save(CommunityDto communityDto){
        Community save = communityRepository.save(communityMapper.mapDtoToCommunity(communityDto));
        communityDto.setId(save.getId());
        return communityDto;
    }

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public List<CommunityDto> getAll() {
            return communityRepository.findAll()
                .stream()
                .map(communityMapper::mapCommunityToDto)
                .collect(toList());
    }

    public CommunityDto getCommunity(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new SpringMNCIException("No community found with ID - " + id));
        return communityMapper.mapCommunityToDto(community);
    }
}
