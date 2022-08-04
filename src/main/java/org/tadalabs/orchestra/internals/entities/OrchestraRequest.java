package org.tadalabs.orchestra.internals.entities;

import com.amazonaws.util.json.Jackson;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class OrchestraRequest {

    @JsonProperty("type")
    private OrchestraRequestType type;

    public OrchestraRequestType getType() {
        return type;
    }

    public void setType(OrchestraRequestType type) {
        this.type = type;
    }


    @JsonProperty("operation")
    private String operation;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }


    @JsonProperty("state")
    private OrchestraRequestState state;

    public OrchestraRequestState getState() {
        return state;
    }

    public void setState(OrchestraRequestState state) {
        this.state = state;
    }


    @JsonProperty("sourceType")
    private OrchestraRequestSourceType sourceType;

    public OrchestraRequestSourceType getSourceType() {
        return sourceType;
    }

    public void setSourceType(OrchestraRequestSourceType sourceType) {
        this.sourceType = sourceType;
    }


    @JsonProperty("sourceId")
    private String sourceId;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }





    @JsonProperty("input")
    private List<OrchestraCommunication> input = new ArrayList<>();

    public List<OrchestraCommunication> getInput() {
        return input;
    }

    public void setInput(List<OrchestraCommunication> input) {
        this.input = input;
    }


    @JsonCreator
    public OrchestraRequest() {
    }

    public String toJsonString() {
        return Jackson.toJsonString(this);
    }

    public static OrchestraRequest fromJsonString(String json) {
        return Jackson.fromJsonString(json, OrchestraRequest.class);
    }
}
