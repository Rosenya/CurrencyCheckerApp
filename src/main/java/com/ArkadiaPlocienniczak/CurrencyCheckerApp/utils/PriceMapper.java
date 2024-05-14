package com.ArkadiaPlocienniczak.CurrencyCheckerApp.utils;

import com.ArkadiaPlocienniczak.CurrencyCheckerApp.config.PriceDTO;
import com.ArkadiaPlocienniczak.CurrencyCheckerApp.model.Price;
import org.springframework.stereotype.Component;

@Component
public class PriceMapper {

    public PriceDTO priceToDTO(Price price){
        PriceDTO priceDTO = new PriceDTO();
        priceDTO.setLastPrice(price.getLastPrice());
        priceDTO.setSymbol(price.getSymbol().getName());
        return priceDTO;
    }
}
