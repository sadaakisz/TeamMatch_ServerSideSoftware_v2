package com.teammatch.service;

import com.teammatch.model.Filter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface FilterService {
    ResponseEntity<?> deleteFilter(Long filterId);
    Filter updateFilter(Long filterId, Filter filterRequest);
    Filter createFilter(Filter filter);
    Filter getFilterById(Long filterId);
    Page<Filter> getAllFilters(Pageable pageable);
    Filter createFiltersByPlayerId(Long playerId, Filter filterRequest);
    Filter getFiltersByPlayerId(Long playerId);
}
