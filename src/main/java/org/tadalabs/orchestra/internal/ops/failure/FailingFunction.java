package org.tadalabs.orchestra.internal.ops.failure;

import org.tadalabs.orchestra.internals.entities.OrchestraOutput;
import org.tadalabs.orchestra.internals.entities.OrchestraRequest;

import java.util.function.Function;

public class FailingFunction implements Function<OrchestraRequest, OrchestraOutput> {
    @Override
    public OrchestraOutput apply(OrchestraRequest orchestraRequest) {
        throw new RuntimeException("This function is meant to fail");
    }
}