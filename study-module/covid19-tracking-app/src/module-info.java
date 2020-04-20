import com.example.covid19.service.Covid19RiskService;

module com.example.covid19.tracking.app {
    requires com.example.covid19.tracking;
    uses Covid19RiskService;
}