package com.allianzCase.project.insuranceOffer.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.allianzCase.project.insuranceOffer.Entities.Offer;
import com.allianzCase.project.insuranceOffer.Enum.OfferCategory;
import com.allianzCase.project.insuranceOffer.Enum.OfferStatus;
import com.allianzCase.project.insuranceOffer.Stats.OfferStatusStats;
import com.allianzCase.project.insuranceOffer.repository.OfferRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OfferService {

	@Autowired
	private OfferRepository offerRepository;

	@Transactional
	public String createOffer(Offer offer) {
		try {
			offer.setId(null == offerRepository.findMaxId() ? 0 : offerRepository.findMaxId() + 1);
			if(!OfferCategory.checkCategory(offer.getCategory())) {
				return "Kampanya kategori değeri doğru girilmemiştir. TSS, OSS, HAYAT_SIGORTASI,DIGER kategorilerinden birini giriniz!";
			}

			if (offer.getCategory().equals(OfferCategory.HAYAT_SIGORTASI.name())) {
				offer.setStatus(OfferStatus.AKTIF.name());
			} else {
				offer.setStatus(OfferStatus.ONAY_BEKLIYOR.name());
			}
			if (!offerRepository.existsByHeaderAndDetailAndCategory(offer.getHeader(), offer.getDetail(),
					offer.getCategory())) {
				offer.setIs_mukerrer(0);
			} else {
				offer.setIs_mukerrer(1);
				offerRepository.save(offer);
				return "Kampanya veritabanında mevcut.";
			}

			offerRepository.save(offer);
			return "Kampanya başarıyla oluşturuldu.";

		} catch (Exception e) {
			throw e;
		}
	}

	public List<Offer> readOffer() {
		return offerRepository.findAll();
	}

	@Transactional
	public String approveOffer(int id) {

		{
			try {
				Offer offer = offerRepository.findById(id).get();
				if (offer.getIs_mukerrer() == 1) {
					return "Bu kampanya mükerrer olduğu için statüsü değiştirilemez.";
				}
				offer.setStatus(OfferStatus.AKTIF.name());
				offerRepository.save(offer);
				return "Kampanya onaylandı.";
			} catch (Exception e) {
				throw e;
			}
		}

	}

	@Transactional
	public String deactiveOffer(int id) {

		{
			try {
				Offer offer = offerRepository.findById(id).get();
				if (offer.getIs_mukerrer() == 1) {
					return "Bu kampanya mükerrer olduğu için statüsü değiştirilemez.";
				}
				offer.setStatus(OfferStatus.DEAKTIF.name());
				offerRepository.save(offer);
				return "Kampanya inaktif hale getirildi.";
			} catch (Exception e) {
				throw e;
			}
		}

	}

	@Transactional
	public String deleteOffer(int id) {

		try {
			offerRepository.deleteById(id);
			return "Student record deleted successfully.";
		} catch (Exception e) {
			throw e;
		}

	}

	@Transactional
	public List<OfferStatusStats> getStatusStats() {
		List<OfferStatusStats> offerStatusStats = offerRepository.findOfferStatusStats();
		return offerStatusStats;
	}
	/*
	 * @Transactional public long countStatus() { return
	 * offerRepository.countByStatus(); }
	 */
	

}
