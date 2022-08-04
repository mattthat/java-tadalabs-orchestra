package org.tadalabs.orchestra.internal.ops.counter;

import org.tadalabs.orchestra.internals.entities.*;

import java.util.ArrayList;
import java.util.function.Function;

public class InputCounterFunction implements Function<OrchestraRequest, OrchestraOutput> {

    @Override
    public OrchestraOutput apply(OrchestraRequest orchestraRequest) {
        ArrayList<OrchestraCommunication> messages = new ArrayList<>();
        messages.add(new OrchestraCommunication("Integer",
                (int)orchestraRequest.getInput().get(0).getMessage() + 1));
        OrchestraOutput output = new OrchestraOutput();
        orchestraRequest.setState(OrchestraRequestState.SUCCEEDED);
        output.setRequest(orchestraRequest);
        output.setOutput(messages);
        output.setType(OrchestraOutputType.SUCCESS);
        return output;
    }

}