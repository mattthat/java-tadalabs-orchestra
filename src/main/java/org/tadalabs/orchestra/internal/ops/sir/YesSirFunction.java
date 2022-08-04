package org.tadalabs.orchestra.internal.ops.sir;

import org.tadalabs.orchestra.internals.entities.OrchestraOutput;
import org.tadalabs.orchestra.internals.entities.OrchestraOutputType;
import org.tadalabs.orchestra.internals.entities.OrchestraRequest;
import org.tadalabs.orchestra.internals.entities.OrchestraRequestState;

import java.util.function.Function;

public class YesSirFunction implements Function<OrchestraRequest, OrchestraOutput> {
    @Override
    public OrchestraOutput apply(OrchestraRequest orchestraRequest) {
        orchestraRequest.setState(OrchestraRequestState.SUCCEEDED);
        OrchestraOutput output = new OrchestraOutput();
        output.setRequest(orchestraRequest);
        output.setType(OrchestraOutputType.SUCCESS);
        return output;
    }
}
