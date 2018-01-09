package com.demo.jpa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.demo.model.Price;


@Component
public class PriceCommandLineRunner implements CommandLineRunner{
		
	public static Logger log = LoggerFactory.getLogger(PriceCommandLineRunner.class);
	
	@Autowired
	PriceRepository priceRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		
		priceRepository.save(new Price(11111,"10001",20.00));
		priceRepository.save(new Price(22222,"10002",30.00));
	
		for (Price price : priceRepository.findAll()) {
			log.info(price.toString());
		}
	}

}
