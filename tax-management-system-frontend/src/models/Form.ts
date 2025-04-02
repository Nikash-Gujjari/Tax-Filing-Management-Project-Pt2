export class Form {
    form_id: number;
    form_name: string;
    form_type: string;
    form: Blob

    constructor(form_id: number, form_name: string, form_type: string, form: Blob) {
        this.form_id = form_id;
        this.form_name = form_name;
        this.form_type = form_type;
        this.form = form;
    }
}