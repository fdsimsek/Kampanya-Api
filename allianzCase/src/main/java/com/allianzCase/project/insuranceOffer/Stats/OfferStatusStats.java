package com.allianzCase.project.insuranceOffer.Stats;

public class OfferStatusStats {
	private String status;
	private Long count;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public OfferStatusStats(String status, Long count) {
		super();
		this.status = status;
		this.count = count;
	}
	
}
