package com.hwan.ecoandrichtest.controller;

import com.hwan.ecoandrichtest.domain.dto.ApiResponse;
import com.hwan.ecoandrichtest.service.ApiService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Tag(name = "API Fetching", description = "DataFetching API.")
@RestController
@AllArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping(value = "/api/data", produces = MediaType.APPLICATION_JSON_VALUE)
    public ApiResponse getApiData(
            @RequestParam(name = "pageNo", defaultValue = "1") int pageNo,
            @RequestParam(name = "numOfRows", defaultValue = "10") int numOfRows) {
        return apiService.fetchDataFromApi(pageNo, numOfRows);
    }
}
