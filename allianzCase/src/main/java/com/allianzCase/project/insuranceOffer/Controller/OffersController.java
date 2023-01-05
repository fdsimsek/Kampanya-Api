package com.allianzCase.project.insuranceOffer.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.allianzCase.project.insuranceOffer.Entities.Offer;
import com.allianzCase.project.insuranceOffer.Service.OfferService;
import com.allianzCase.project.insuranceOffer.Stats.OfferStatusStats;

import java.util.List;

import javax.validation.Valid;

@RestController
public class OffersController {

    @Autowired
    private OfferService offerService;

    @RequestMapping(value = "info", method = RequestMethod.GET)
    public String info(){
        return "The application is up...";
    }

    @RequestMapping(value = "createoffer", method = RequestMethod.POST)
    public String createOffer(@Valid @RequestBody Offer offer){
        return offerService.createOffer(offer);
    }

    @RequestMapping(value = "readoffer", method = RequestMethod.GET)
    public List<Offer> readStudents(){
        return offerService.readOffer();
    }

    @RequestMapping(value = "approveoffer/{id}", method = RequestMethod.GET, produces = "application/json")
    public String approveOffer(@PathVariable int id){
        return offerService.approveOffer(id);
    }

    @RequestMapping(value = "deactivateoffer/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deactivateOffer(@PathVariable int id){
        return offerService.deactiveOffer(id);
    }

    @RequestMapping(value = "deleteoffer/{id}", method = RequestMethod.GET, produces = "application/json")
    public String deleteOffer(@PathVariable int id){
        return offerService.deleteOffer(id);
    }
    
    @RequestMapping(value = "/dashboard/classifieds/statistics", method = RequestMethod.GET)
    public List<OfferStatusStats> countEntities() {
		return offerService.getStatusStats();
	}
    
}
