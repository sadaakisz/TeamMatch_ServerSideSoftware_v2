package com.teammatch.UnitTests;

import com.teammatch.exception.ResourceNotFoundException;
import com.teammatch.model.Filter;
import com.teammatch.repository.FilterRepository;
import com.teammatch.service.FilterService;
import com.teammatch.service.FilterServiceImpl;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@ExtendWith(SpringExtension.class)
public class FilterServiceImplIntegrationTest extends TeammatchApplicationTest {

    @Autowired
    private FilterService filterService;

    @MockBean
    private FilterRepository filterRepository;

    @TestConfiguration
    static class FilterServiceImplConfiguration{
        @Bean
        public FilterService filterService(){ return new FilterServiceImpl();}
    }

    @Test
    @DisplayName("When getFilterById but Id Does Not Existis Return player not found for Id with value 1")
    public void whenGetFilterByIdButIdDoesNotExistReturnPlayerNotFound(){
        String response = "Resource %s not found for %s with value %s";
        Filter filter = new Filter();
        filter.setId(1L);
        filter.setGame("Fortnite");
        filter.setAccountLevel(2);
        filter.setAge(15);
        filter.setGameStyle("agro");
        filter.setRegion("Brazil");
        filter.setRating(2);

        Mockito.when(filterRepository.findById(1L)).thenReturn(Optional.empty());
        String expectedMessage = String.format(response, "Filter", "Id", filter.getId());

        Throwable exception = catchThrowable(()-> {
            Filter result = filterService.getFilterById(1L);
        });

        assertThat(exception)
                .isInstanceOf(ResourceNotFoundException.class)
                .hasMessage(expectedMessage);
    }

}
