package org.tadalabs.orchestra.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.SQSEvent;
import com.amazonaws.services.lambda.runtime.events.SQSEvent.SQSMessage;;
import org.tadalabs.orchestra.internal.ops.OperationMapper;
import org.tadalabs.orchestra.internal.ops.OperationMapperLoader;
import org.tadalabs.orchestra.internals.entities.OrchestraRequest;
import org.tadalabs.orchestra.internals.entities.OrchestraOutput;
import org.tadalabs.orchestra.internals.entities.OrchestraRequestSourceType;
import org.tadalabs.orchestra.internals.entities.OrchestraCommunication;
import org.tadalabs.orchestra.internals.entities.OrchestraOutputType;

public class SQSDrivenRequestHandler implements RequestHandler<SQSEvent, List<OrchestraOutput>> {

    private OperationMapper mapper;
    private Context context;

    @Override
    public List<OrchestraOutput> handleRequest(final SQSEvent event, Context context) {
        this.context = context;
        try {
            this.mapper = OperationMapper
                    .loadMappings(new OperationMapperLoader()
                            .load("operations.json"), context.getLogger());
        } catch(Exception x) {
            this.mapper = new OperationMapper();
        }
        return event.getRecords()
                .stream()
                .filter(Objects::nonNull)
                .map(this::sqsToOrchestraOutput)
                .collect(Collectors.toList());
    }

    private OrchestraOutput sqsToOrchestraOutput(SQSMessage msg) {
        try {
            OrchestraRequest request = OrchestraRequest
                    .fromJsonString(msg.getBody());
            request.setSourceType(OrchestraRequestSourceType.SQS);
            request.setSourceId(msg.getMessageId());
            return mapper.perform(request);
        } catch (Exception ex) {
            List<OrchestraCommunication> problems = new ArrayList<>();
            problems.add(new OrchestraCommunication("String",
                    msg.toString()));
            problems.add(new OrchestraCommunication("String",
                    ex.toString()));
            OrchestraOutput failure = new OrchestraOutput();
            failure.setType(OrchestraOutputType.FAILURE);
            failure.setOutput(problems);
            return failure;
        }
    }
}
