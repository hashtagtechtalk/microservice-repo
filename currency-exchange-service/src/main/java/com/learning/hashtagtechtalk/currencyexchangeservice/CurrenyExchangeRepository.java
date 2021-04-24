package com.learning.hashtagtechtalk.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrenyExchangeRepository extends JpaRepository<CurrencyExchange, Long> {

    public CurrencyExchange findByFromAndTo(String from, String to);
}
