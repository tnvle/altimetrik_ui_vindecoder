package com.example.demoaltiui.controller;

import com.example.demoaltiui.model.VINDecoderObj;
import com.example.demoaltiui.service.VinDecodeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HttpsURLConnection;
import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class HomeController {

    @Autowired
    VinDecodeService vinDecodeService;

    @Value("http://localhost:8080/vindecoder/%s")
    private String vinDecodeAPI;

    @GetMapping("/")
    public String home() {
        return "vinhome";
    }

    @PostMapping("/encode")
    public String encode(String vin, Model model){

        ResponseEntity<?> responseEntity = vinDecodeService.vinDecode(vin);
        if(responseEntity.getStatusCode()== HttpStatus.CREATED)
        {
            ObjectMapper mapper = new ObjectMapper();
            VINDecoderObj vinobj = mapper.convertValue(responseEntity.getBody(), VINDecoderObj.class);

            model.addAttribute("vin", vinobj);
        }

        return "result";
    }
}
