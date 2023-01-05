package com.allianzCase.project.insuranceOffer.Enum;

public enum OfferCategory {
	TSS,
	OSS,
	HAYAT_SIGORTASI,
	DIGER;
	
	static public boolean checkCategory(String offerCat) {
		OfferCategory[] category = OfferCategory.values();
	       for (OfferCategory cat : category)
	           if (cat.name().equals(offerCat))
	               return true;
	       return false;
	   }
}
