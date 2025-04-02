package com.skillstorm.tax_management_system_api.dtos;

import java.util.List;

import com.skillstorm.tax_management_system_api.models.Cpa;
import com.skillstorm.tax_management_system_api.models.Form;
import com.skillstorm.tax_management_system_api.models.Taxpayer;


public record Tax_ReturnDTO(int tax_return_id, String filing_status, Cpa cpa, List<Taxpayer> taxpayer, List<Form> forms) {

}
