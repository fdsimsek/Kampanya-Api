package com.allianzCase.project.insuranceOffer.repository;

import com.allianzCase.project.insuranceOffer.Entities.Offer;
import com.allianzCase.project.insuranceOffer.Stats.OfferStatusStats;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface OfferRepository extends JpaRepository<Offer, Integer> {
	
    public boolean existsByHeaderAndDetailAndCategory(String header, String detail, String category);
    
    public List<Offer> findByHeaderAndDetailAndCategory(String header, String detail, String category);
	
	 @Query("select max(s.id) from Offer s")
	public Integer findMaxId();
	 
	 @Query("select new com.allianzCase.project.insuranceOffer.Stats.OfferStatusStats(s.status, COUNT(s)) from Offer s group by s.status")
	 public List<OfferStatusStats> findOfferStatusStats();
}
