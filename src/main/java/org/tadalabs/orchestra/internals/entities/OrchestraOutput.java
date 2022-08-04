package org.tadalabs.orchestra.internals.entities;

import com.amazonaws.util.json.Jackson;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class OrchestraOutput {
    @JsonProperty("type")
    private OrchestraOutputType type;

    public OrchestraOutputType getType() {
        return type;
    }
    public void setType(OrchestraOutputType type) {
        this.type = type;
    }

    @JsonProperty("request")
    private OrchestraRequest request;

    public OrchestraRequest getRequest() {
        return request;
    }

    public void setRequest(OrchestraRequest request) {
        this.request = request;
    }

    @JsonProperty("output")
    private List<OrchestraCommunication> output;

    public List<OrchestraCommunication> getOutput() {
        return output;
    }

    public void setOutput(List<OrchestraCommunication> output) {
        this.output = output;
    }

    @JsonCreator
    public OrchestraOutput() {
    }

    @Override
    public String toString() {
        return this.toJsonString();
    }
    public String toJsonString() {
        return Jackson.toJsonPrettyString(this);
    }

    public static OrchestraOutput fromJsonString(String json) {
        return Jackson.fromJsonString(json, OrchestraOutput.class);
    }
}
