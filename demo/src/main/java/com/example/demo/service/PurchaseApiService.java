package com.example.demo.service;

import com.example.demo.converter.PurchaseEntityConverter;
import com.example.demo.model.PurchaseEntity;
import com.example.demo.repository.PurchaseRepository;
import com.example.demo.request.InfoRQ;
import com.example.demo.response.StationResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Service
public class PurchaseApiService {

    private final static String URL = "https://api.datos.gob.mx/v1/precio.gasolina.publico";

    private PurchaseRepository buyRepository;
    private RestTemplate stationRestTemplate;
    private PurchaseEntityConverter converter;

    @Autowired
    public PurchaseApiService(final PurchaseRepository buyRepository, @Qualifier("stationRestTemplate") final RestTemplate stationRestTemplate, final PurchaseEntityConverter converter){
        this.buyRepository = buyRepository;
        this.stationRestTemplate = stationRestTemplate;
        this.converter = converter;
    }


    public PurchaseEntity buyGas(final InfoRQ infoRq) {

        var url = String.format(URL + "?_id=%s", infoRq.getGasStation());
        try {
            var station = stationRestTemplate.exchange(url, HttpMethod.GET, HttpEntity.EMPTY, StationResponse.class);
            var buyEntity = converter.convert(infoRq, station.getBody().getResults().get(0));
            return buyRepository.save(buyEntity);
        } catch (HttpServerErrorException e) {
            log.error(e.getMessage());
            throw  new IllegalArgumentException("Gas Station not found");
        }
    }

    public List<PurchaseEntity> findAll() {
        return buyRepository.findAll();
    }
}
