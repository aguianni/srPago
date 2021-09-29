package com.example.demo.validator;

import com.example.demo.request.InfoRQ;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class infoRQValidator {

    public void valid(final InfoRQ infoRQ){
        var gasType = infoRQ.getGasType();
        if(gasType != 1 && gasType != 2 ){
            log.error("GasType problem 1 or 2 is allow");
            throw  new IllegalArgumentException("GasType problem 1 or 2 is allow");
        }
        if(infoRQ.getAmount() < 1 ){
            log.error("Amount must be > 1");
            throw  new IllegalArgumentException("Amount must be > 1");
        }
    }
}
