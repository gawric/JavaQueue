package org.example.Api.Model;


import com.fasterxml.jackson.annotation.JsonFormat;

public class Products {
    private String certificate_documnet;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String certificate_documnet_date;
    private String certificate_document_number;
    private String owner_inn;
    private String producer_inn;
    @JsonFormat(pattern = "yyyy-MM-dd")
    private String pruduction_date;
    private String tnved_code;
    private String uit_code;
    private String uitu_code;

    // Getters and Setters

    public String getCertificate_documnet() {
        return certificate_documnet;
    }

    public void setCertificate_documnet(String certificate_documnet) {
        this.certificate_documnet = certificate_documnet;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public String getCertificate_documnet_date() {
        return certificate_documnet_date;
    }

    public void setCertificate_documnet_date(String certificate_documnet_date) {
        this.certificate_documnet_date = certificate_documnet_date;
    }

    public String getCertificate_document_number() {
        return certificate_document_number;
    }

    public void setCertificate_document_number(String certificate_document_number) {
        this.certificate_document_number = certificate_document_number;
    }

    public String getOwner_inn() {
        return owner_inn;
    }

    public void setOwner_inn(String owner_inn) {
        this.owner_inn = owner_inn;
    }

    public String getProducer_inn() {
        return producer_inn;
    }

    public void setProducer_inn(String producer_inn) {
        this.producer_inn = producer_inn;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public String getPruduction_date() {
        return pruduction_date;
    }

    public void setPruduction_date(String pruduction_date) {
        this.pruduction_date = pruduction_date;
    }

    public String getTnved_code() {
        return tnved_code;
    }

    public void setTnved_code(String tnved_code) {
        this.tnved_code = tnved_code;
    }

    public String getUit_code() {
        return uit_code;
    }

    public void setUit_code(String uit_code) {
        this.uit_code = uit_code;
    }

    public String getUitu_code() {
        return uitu_code;
    }

    public void setUitu_code(String uitu_code) {
        this.uitu_code = uitu_code;
    }
}