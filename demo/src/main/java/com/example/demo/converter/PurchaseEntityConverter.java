package com.example.demo.converter;

import com.example.demo.model.PurchaseEntity;
import com.example.demo.request.InfoRQ;
import com.example.demo.response.StationResult;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class PurchaseEntityConverter {

    public PurchaseEntity convert(final InfoRQ infoRq, final StationResult station){
        var buyEntity = new PurchaseEntity();
        BeanUtils.copyProperties(infoRq, buyEntity);
        if(infoRq.getGasType().equals("magna")){
            buyEntity.setPrice(station.getRegular());
        } else {
            buyEntity.setPrice(station.getPremium());
        }
        return buyEntity;
    }

}
