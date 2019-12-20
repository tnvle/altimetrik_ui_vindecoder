package com.example.demoaltiui.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-vindecoder", url = "http://localhost:8080")
public interface VinDecodeService {

    @GetMapping("/vindecoder/{vin}")
    ResponseEntity<?> vinDecode(@PathVariable(name="vin") String vin);
}
