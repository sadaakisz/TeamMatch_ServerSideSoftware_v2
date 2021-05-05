package com.teammatch.service;

import com.teammatch.exception.ResourceNotFoundException;
import com.teammatch.model.Filter;
import com.teammatch.model.Player;
import com.teammatch.repository.FilterRepository;
import com.teammatch.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FilterServiceImpl implements FilterService{

    @Autowired
    private FilterRepository filterRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public ResponseEntity<?> deleteFilter(Long filterId) {
        Filter filter = filterRepository.findById(filterId)
                .orElseThrow(() -> new ResourceNotFoundException("Filter", "Id", filterId));
        filterRepository.delete(filter);
        return ResponseEntity.ok().build();
    }

    @Override
    public Filter updateFilter(Long filterId, Filter filterRequest) {
        Filter filter = filterRepository.findById(filterId)
                .orElseThrow(() -> new ResourceNotFoundException("Filter", "Id", filterId));
        filter.setGame(filterRequest.getGame());
        filter.setAccountLevel(filterRequest.getAccountLevel());
        filter.setAge(filterRequest.getAge());
        filter.setGameStyle(filterRequest.getGameStyle());
        filter.setRegion(filterRequest.getRegion());
        filter.setRating((filterRequest.getRating()));
        return filterRepository.save(filter);
    }

    @Override
    public Filter createFilter(Filter filter) {
        return filterRepository.save(filter);
    }

    @Override
    public Filter getFilterById(Long filterId) {
        return filterRepository.findById(filterId)
                .orElseThrow(() -> new ResourceNotFoundException("Filter", "Id", filterId));
    }

    @Override
    public Page<Filter> getAllFilters(Pageable pageable) {
        return filterRepository.findAll(pageable);
    }

    @Override
    public Filter createFiltersByPlayerId(Long playerId, Filter filterRequest) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Filter", "Id", playerId));
        Filter filter = new Filter();
        filter.setGame(filterRequest.getGame());
        filter.setAccountLevel(filterRequest.getAccountLevel());
        filter.setAge(filterRequest.getAge());
        filter.setGameStyle(filterRequest.getGameStyle());
        filter.setRegion(filterRequest.getRegion());
        filter.setRating((filterRequest.getRating()));
        player.setFilter(filter);
        return filterRepository.save(filter);
    }

    @Override
    public Filter getFiltersByPlayerId(Long playerId) {
        Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new ResourceNotFoundException("Filter", "Id", playerId));

        return player.getFilter();
    }
}
