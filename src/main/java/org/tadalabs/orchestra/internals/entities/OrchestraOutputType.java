package org.tadalabs.orchestra.internals.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrchestraOutputType {
    @JsonProperty("success")
    SUCCESS,
    @JsonProperty("failure")
    FAILURE
}
