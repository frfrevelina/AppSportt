package com.example.appsport.services;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Data
@Scope("singleton")
@Service
public class PageDataService {
    PageDataService(){}

    @Value("${sportsApp.title")
    String siteTitle;
}
