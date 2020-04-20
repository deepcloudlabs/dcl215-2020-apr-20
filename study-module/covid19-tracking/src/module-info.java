import com.example.covid19.service.Covid19RiskService;
import com.example.covid19.service.impl.DummyCovid19RiskService;

module com.example.covid19.tracking {
    exports com.example.covid19.service ;
    provides Covid19RiskService with DummyCovid19RiskService;
}