package com.skillstorm.tax_management_system_api.dtos;

import com.skillstorm.tax_management_system_api.models.Employment_Sector;
import com.skillstorm.tax_management_system_api.models.Tax_Return;

public record TaxpayerDTO(String first_name, String middle_name, String last_name,
		String social_security_number, String address, String date_of_birth, String bank_account_number,
		String bank_routing_number, Employment_Sector employment_sector, Tax_Return tax_return) {

}
