package com.gcu.business;

import java.util.List;

import com.gcu.model.DonationsModel;

public interface DonationsServiceInterface {

	public List<DonationsModel> getDonations();
	public boolean createDonation(DonationsModel dm);
	public boolean deleteDonation(DonationsModel dm);
	public boolean updateDonation(DonationsModel dm);
}
