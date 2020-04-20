package com.example.covid19.service.impl;

import com.example.covid19.service.Covid19RiskService;
import com.example.covid19.service.RiskLevel;

public class DummyCovid19RiskService implements Covid19RiskService {
    @Override
    public RiskLevel getRiskLevel(double lng, double ltd) {
        return RiskLevel.HIGH;
    }
}
