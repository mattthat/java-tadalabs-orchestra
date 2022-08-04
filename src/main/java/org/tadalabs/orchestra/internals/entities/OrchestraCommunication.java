package org.tadalabs.orchestra.internals.entities;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class OrchestraCommunication {

    @JsonProperty("type")
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @JsonProperty("message")
    private Object message;

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }


    @JsonCreator
    public OrchestraCommunication() {
    }

    public OrchestraCommunication(String type, Object message) {
        this.type = type;
        this.message = message;
    }

}
