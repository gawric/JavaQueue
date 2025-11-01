package org.example.Api.Model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RequestModel{

    private GeneralModel data;
    private boolean isExit;
    public RequestModel(GeneralModel data){

        this.data = data;
    }

    public String getJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            return "";
        }

    }
    public RequestModel(boolean isExit){
        this.isExit = isExit;
    }

    public boolean isExit(){
        return isExit;
    }

    public String getName(){
        return data.getOwner_inn();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
