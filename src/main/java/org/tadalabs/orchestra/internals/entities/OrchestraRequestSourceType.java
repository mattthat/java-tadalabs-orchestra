package org.tadalabs.orchestra.internals.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum OrchestraRequestSourceType {
    @JsonProperty("sqs")
    SQS
}
