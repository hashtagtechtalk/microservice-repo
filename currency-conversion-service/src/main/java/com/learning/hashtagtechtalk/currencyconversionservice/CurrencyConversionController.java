package com.learning.hashtagtechtalk.currencyconversionservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;

@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyConversionProxy currencyConversionProxy;
    @Autowired
    private Environment environment;
    public static final String LOCAL_SERVER_PORT = "local.server.port";

    @GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveConvertedValue(@PathVariable String from, @PathVariable String to,@PathVariable String quantity){
        HashMap<String, String> urivariables = new HashMap<>();
        urivariables.put("from",from);
        urivariables.put("to",to);
        ResponseEntity<CurrencyConversion> response=new RestTemplate().getForEntity("http://localhost:8001/currency-exchange/from/USD/to/INR",CurrencyConversion.class,urivariables);
        CurrencyConversion currencyConversion = response.getBody();
        System.out.println(currencyConversion.getEnvironment());
        return new CurrencyConversion(currencyConversion.getId(), from,to,BigDecimal.ONE,currencyConversion.getQuantity(),currencyConversion.getConversionMultiple(),environment.getProperty("local.server.port"));
    }
    @GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversion retrieveConvertedValueUsingFeign(@PathVariable String from, @PathVariable String to,@PathVariable String quantity){
      CurrencyConversion currencyConversion =currencyConversionProxy.retrieveExchangeValue(from, to);
        System.out.println(currencyConversion.getEnvironment());
        return new CurrencyConversion(currencyConversion.getId(), from,to,BigDecimal.ONE,currencyConversion.getQuantity(),currencyConversion.getConversionMultiple(),environment.getProperty("local.server.port"));
    }
}
