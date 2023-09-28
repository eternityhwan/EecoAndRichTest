package com.hwan.ecoandrichtest.service;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.hwan.ecoandrichtest.domain.dto.ApiResponse;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiService {

    @Value("${api.url}")
    private String apiUrl;
    @Value("${api.key}")
    private String apiKey;
    private final RestTemplate restTemplate;

    @Autowired
    public ApiService(
            @Value("${api.url}") String apiUrl,
            @Value("${api.key}") String apiKey,
            RestTemplate restTemplate
    ) {
        this.apiUrl = apiUrl;
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }


    public ApiResponse fetchDataFromApi(int pageNo, int numOfRows) {

        String fullUrl = apiUrl +
                "?serviceKey=" + apiKey +
                "&pageNo=" + pageNo +
                "&numOfRows=" + numOfRows;

        // fullUrl을 로그로 출력
        System.out.println("API URL: " + fullUrl);

        // GET 요청 보내기
        ApiResponse response = restTemplate.getForObject(fullUrl, ApiResponse.class);

        // 응답 데이터 반환
        return response;
        }
    }

