package org.tadalabs.orchestra.internals.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrchestraRequestState {
    @JsonProperty("initiating")
    INITIATING,
    @JsonProperty("scheduled")
    SCHEDULED,
    @JsonProperty("running")
    RUNNING,
    @JsonProperty("succeeded")
    SUCCEEDED,
    @JsonProperty("failed")
    FAILED
}
