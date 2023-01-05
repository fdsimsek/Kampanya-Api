package com.allianzCase.project.insuranceOffer;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.allianzCase.project.insuranceOffer.Entities.Offer;
import com.allianzCase.project.insuranceOffer.repository.OfferRepository;

@SpringBootTest
class InsuranceOfferApplicationTests {

	@Autowired
	OfferRepository offerRepository;
	
	@Test
	public void testCreate() {
		Offer o = new Offer();
		o.setId(222);
		o.setHeader("Deneme kampanya başlıgı");
		o.setDetail("deneme kampanya icin iceriktir. İcerik karakter kisiti vardır.");
		o.setCategory("tss");
		offerRepository.save(o);
		assertNotNull(offerRepository.findById(222).get());
	}
	
	@Test
	public void testSingleOffer() {
		Offer o = offerRepository.findById(222).get();
		System.out.println(o.getCategory());
		assertEquals("tss", o.getCategory());
	}
	
}
