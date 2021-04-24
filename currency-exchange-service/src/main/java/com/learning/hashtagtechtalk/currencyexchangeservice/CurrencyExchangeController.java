package com.learning.hashtagtechtalk.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrenyExchangeRepository currenyExchangeRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchange retrieveExchangevalue(@PathVariable String from, @PathVariable String to){
        CurrencyExchange currencyExchange= currenyExchangeRepository.findByFromAndTo(from,to);
        if(currencyExchange == null)
            throw new RuntimeException("Unable to fetch data");
        currencyExchange.setEnvironment(environment.getProperty(Constant.LOCAL_SERVER_PORT));

        return currencyExchange;
    }

}
