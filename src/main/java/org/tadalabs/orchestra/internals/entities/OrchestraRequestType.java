package org.tadalabs.orchestra.internals.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrchestraRequestType {
    @JsonProperty("lambda")
    LAMBDA,
    @JsonProperty("fargate")
    FARGATE
}
