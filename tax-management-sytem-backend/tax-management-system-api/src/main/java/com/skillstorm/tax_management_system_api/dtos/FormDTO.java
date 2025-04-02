package com.skillstorm.tax_management_system_api.dtos;

import java.sql.Blob;

import com.skillstorm.tax_management_system_api.models.Tax_Return;

public record FormDTO(int form_id, String form_name, String form_type, Blob form, Tax_Return tax_return) {

}
