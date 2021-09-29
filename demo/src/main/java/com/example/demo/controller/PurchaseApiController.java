package com.example.demo.controller;

import com.example.demo.model.PurchaseEntity;
import com.example.demo.response.Response;
import com.example.demo.request.InfoRQ;
import com.example.demo.service.PurchaseApiService;
import com.example.demo.validator.infoRQValidator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
public class PurchaseApiController {

    private final PurchaseApiService buyApiService;
    private final infoRQValidator validator;

    @PostMapping(
            value = "purchases/gas",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    public ResponseEntity<Response> purchaseGas(@Valid @RequestBody final InfoRQ infoRq){
        validator.valid(infoRq);
        var entity = buyApiService.buyGas(infoRq);
        var response = new Response();
        response.setSuccess(true);
        response.setMessage("Informacion correcta");
        return ResponseEntity.ok(response);
    }

    @GetMapping(
            value = "purchases",
            produces = { "application/json" }
    )
    public ResponseEntity<List<PurchaseEntity>> purchases(){
        var purchases = buyApiService.findAll();
        return ResponseEntity.ok(purchases);
    }
}
