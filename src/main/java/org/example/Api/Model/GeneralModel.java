package org.example.Api.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.example.Api.Creator.Builder;


import java.util.ArrayList;
import java.util.List;

public class GeneralModel {
    private Inn description = new Inn();
    private String doc_id = "";
    private String doc_status = "";
    private String doc_type = "";
    private String owner_inn = "";
    private String participant_inn = "";
    private String producer_inn = "";

    private boolean importRequest;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String production_date;
    private String production_type;
    private List<Products> products = new ArrayList<>();
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String reg_date = "2020-11-01";

    private String req_number = "";

    public Inn getDescription(){
        return description;
    }

    public void setDescription(Inn description){
        this.description = description;
    }
    public String getDoc_id() {
        return doc_id;
    }
    public String getDoc_status() {
        return doc_status;
    }

    public String getDoc_type() {
        return doc_type;
    }
    public String getOwner_inn() {
        return owner_inn;
    }

    public String getReq_number() {
        return req_number;
    }
    public boolean getImportRequest() {
        return importRequest;
    }
    public void setOwner_inn(String owner_inn) {
        this.owner_inn = owner_inn;
    }

    public void setImportRequest(boolean importRequest) {
        this.importRequest = importRequest;
    }

    public String getParticipant_inn() {
        return participant_inn;
    }

    public void setParticipant_inn(String participant_inn) {
        this.participant_inn = participant_inn;
    }

    public String getProducer_inn() {
        return producer_inn;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }
    public void setDoc_status(String doc_status) {
        this.doc_status = doc_status;
    }
    public void setDoc_type(String doc_type) {
        this.doc_type = doc_type;
    }
    public void setProducer_inn(String producer_inn) {
        this.producer_inn = producer_inn;
    }
    public void setReq_number(String req_number) {
        this.req_number = req_number;
    }
    @JsonFormat(pattern = "yyyy-MM-dd")
    public String getProduction_date() {
        return production_date;
    }

    public void setProduction_date(String production_date) {
        this.production_date = production_date;
    }

    public String getProduction_type() {
        return production_type;
    }

    public void setProduction_type(String production_type) {
        this.production_type = production_type;
    }

    public List<Products> getProducts() {
        return products;
    }

    public void setProducts(List<Products> products) {
        this.products = products;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }


    public GeneralModel(Builder b) {
        this.owner_inn = b.owner_inn;
        this.participant_inn = b.participant_inn;
        this.production_date = "2020-01-2023";
        this.production_type = b.production_type;
        this.products = b.products;
        this.reg_date = "2020-01-2023";
    }
}