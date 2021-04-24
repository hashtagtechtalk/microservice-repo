package com.learning.hashtagtechtalk.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//The name of the feign client should be same in the eureka client
//@FeignClient(name = "currency-exchange",url = "localhost:8001")
@FeignClient(name = "currency-exchange-service")
public interface CurrencyConversionProxy {
    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyConversion retrieveExchangeValue(
            @PathVariable String from,
            @PathVariable String to);
}
