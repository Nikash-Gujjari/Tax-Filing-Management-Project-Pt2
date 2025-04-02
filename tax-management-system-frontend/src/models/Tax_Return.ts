export class Tax_Return {
    tax_return_id : number;
    filing_status: string;

    constructor(tax_return_id: number, filing_status: string) {
        this.tax_return_id = tax_return_id;
        this.filing_status = filing_status;
    }
}