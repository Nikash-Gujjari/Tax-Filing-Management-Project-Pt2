export class Taxpayer {
    taxpayer_id: number;
    first_name: string;
    middle_name: string;
    last_name: string;
    social_security_number: string;
    address: string;
    date_of_birth: string;
    bank_account_number: string;
    bank_routing_number: string;

    constructor(taxpayer_id: number, first_name: string, middle_name: string, last_name: string, social_security_number: string,      address: string, date_of_birth: string,
    bank_account_number: string, bank_routing_number: string) {
        this.taxpayer_id = taxpayer_id;
        this.first_name = first_name;
        this.middle_name = middle_name;
        this.last_name = last_name;
        this.social_security_number = social_security_number;
        this.address = address;
        this.date_of_birth = date_of_birth;
        this.bank_account_number = bank_account_number;
        this.bank_routing_number = bank_routing_number;
    }
}