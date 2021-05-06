package com.teammatch.controller;

import com.teammatch.model.Filter;
import com.teammatch.resource.FilterResource;
import com.teammatch.resource.SaveFilterResource;
import com.teammatch.service.FilterService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
@CrossOrigin
@Tag(name = "Filters", description = "Filter API")
public class FilterController {
    @Autowired
    private ModelMapper mapper;

    @Autowired
    private FilterService filterService;

    @GetMapping("/filters")
    public Page<FilterResource> getAllFilters(Pageable pageable) {
        Page<Filter> filterPage = filterService.getAllFilters(pageable);
        List<FilterResource> resources = filterPage.getContent().stream().map(this::convertToResource).collect(Collectors.toList());

        return new PageImpl<>(resources, pageable, resources.size());
    }

    @GetMapping("/filters/{id}")
    public FilterResource getFilterById(@PathVariable(name = "id") Long filterId) {
        return convertToResource(filterService.getFilterById(filterId));
    }

    @PostMapping("/filters")
    public FilterResource createFilter(@Valid @RequestBody SaveFilterResource resource)  {
        Filter filter = convertToEntity(resource);
        return convertToResource(filterService.createFilter(filter));
    }

    @PutMapping("/filters/{id}")
    public FilterResource updateFilter(@PathVariable(name = "id") Long filterId, @Valid @RequestBody SaveFilterResource resource) {
        Filter filter = convertToEntity(resource);
        return convertToResource(filterService.updateFilter(filterId, filter));
    }

    @DeleteMapping("/filters/{id}")
    public ResponseEntity<?> deleteFilter(@PathVariable(name = "id") Long filterId) {
        return filterService.deleteFilter(filterId);
    }

    @PostMapping("/players/{id}/filters")
    public FilterResource createFiltersByPlayerId(@PathVariable(name = "id") Long playerId, @Valid @RequestBody SaveFilterResource resource)  {
        Filter filters = convertToEntity(resource);
        return convertToResource(filterService.createFiltersByPlayerId(playerId, filters));
    }

    @GetMapping("/players/{id}/filters")
    public FilterResource getFiltersByPlayerId(@PathVariable(name = "id") Long playerId)  {
        return convertToResource(filterService.getFiltersByPlayerId(playerId));
    }

    private Filter convertToEntity(SaveFilterResource resource) {
        return mapper.map(resource, Filter.class);
    }

    private FilterResource convertToResource(Filter entity) {
        return mapper.map(entity, FilterResource.class);
    }
}
