package org.example.Api.Creator;


import org.example.Api.Model.GeneralModel;
import org.example.Api.Model.Products;

import java.util.List;

public class Builder{

    public String doc_id;
    public String doc_status;
    public String doc_type;
    public String owner_inn;
    public String participant_inn;

    public String producer_inn;
    public String production_date;
    public String production_type;
    public List<Products> products;
    public String reg_date = "";
    public String reg_number;
    public String tnved_code;
    public String certificate_document;
    public String certificate_document_date;
    public String certificate_document_number;
    public String uitu_code;

    public Builder() {}
    //required to fill out
    public Builder Doc(String participantInn , String doc_id , String doc_status, String doc_type){
        this.doc_id = doc_id;
        this.doc_status = doc_status;
        this.doc_type = doc_type;
        return this;
    }
    //required to fill out
    public Builder Owner(String owner_inn , String participant_inn , String producer_inn){
        this.owner_inn = owner_inn;
        this.participant_inn = participant_inn;
        this.producer_inn = producer_inn;
        return this;
    }
    //required to fill out
    public Builder Products(String producer_inn , String production_date , String production_type , List<Products> products){
        this.producer_inn = producer_inn;
        this.production_date = "2020-01-2023";
        this.production_type = production_type;
        this.products = products;
        return this;
    }

    //required to fill out
    public Builder DataProduct(String owner_inn , String producer_inn , String production_date , String tnved_code){
        this.owner_inn = owner_inn;
        this.producer_inn = producer_inn;
        this.production_date = "2020-01-2023";
        this.tnved_code = tnved_code;
        return this;
    }

    //Not required
    public Builder  OtherParametrs(String certificate_document ,
                                   String certificate_document_date,
                                   String certificate_document_number ,
                                   String uitu_code){

        this.certificate_document = certificate_document;
        this.certificate_document_date = certificate_document_date;
        this.certificate_document_number = certificate_document_number;
        this.uitu_code = uitu_code;
        return this;
    }

    public GeneralModel build() {
        return new GeneralModel(this);
    }

    @Override
    public String toString() {
        return "GeneralModel{" +
                "description=" + producer_inn +
                ", doc_id='" + doc_id +
                ", doc_status='" + doc_status +
                ", doc_type='" + doc_type +
                ", owner_inn=" + owner_inn +
                ", producer_inn='" + producer_inn +
                ", production__date='" + production_date +
                ", production_type='" + production_type +
                ", products=" + products +
                ", reg_date='" + reg_date +
                ", reg_number='";
    }

}
