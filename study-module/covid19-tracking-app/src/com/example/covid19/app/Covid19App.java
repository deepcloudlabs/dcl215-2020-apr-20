package com.example.covid19.app;

import com.example.covid19.service.Covid19RiskService;

import java.util.ServiceLoader;

public class Covid19App {
    public static void main(String[] args) {
        Covid19RiskService srvCovid19RiskService =
                ServiceLoader.load(Covid19RiskService.class)
                             .findFirst()
                             .get();
        System.out.println(srvCovid19RiskService.getRiskLevel(42.,36.));
    }
}
