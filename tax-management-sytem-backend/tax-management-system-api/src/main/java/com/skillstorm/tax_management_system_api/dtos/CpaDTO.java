package com.skillstorm.tax_management_system_api.dtos;

import java.util.List;

import com.skillstorm.tax_management_system_api.models.Tax_Return;

public record CpaDTO(String first_name, String last_name, String email, String username, String password,
		String role, List<Tax_Return> tax_return) {

}
