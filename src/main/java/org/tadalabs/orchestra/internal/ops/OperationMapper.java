package org.tadalabs.orchestra.internal.ops;

import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.json.JSONObject;
import org.tadalabs.orchestra.internals.entities.OrchestraOutput;
import org.tadalabs.orchestra.internals.entities.OrchestraRequest;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OperationMapper {

    final Map<String, Function> operationMap;

    public OperationMapper(final Map<String, Function> operationMap) {
        this.operationMap = operationMap;
    }

    public OperationMapper() {
        this.operationMap = new HashMap<>();
    }

    public void put(String name, Function code) {
        if (!operationMap.containsKey(name))
            operationMap.put(name, code);
    }

    public void remove(String name) {
        if (operationMap.containsKey(name))
            operationMap.remove(name);
    }

    public OrchestraOutput perform(OrchestraRequest request) throws Exception {
        Function code = operationMap.get(request.getOperation());
        if (null != code) {
            return (OrchestraOutput) code.apply(request);
        } else {
            throw new Exception("UNKNOWN OPERATION");
        }
    }

    private static void loadMapping(OperationMapper mapper, String key,
                                    String className) throws Exception {
            Class<?> c = Class.forName(className);
            Constructor<?> cons = c.getConstructor();
            Function object = (Function) cons.newInstance();
            mapper.put(key, object);
    }

    public static OperationMapper loadMappings(JSONObject json,
                                               Logger logger) throws Exception {
        OperationMapper mapper = new OperationMapper();
        for(String name : json.keySet()) {
            String className = (String) json.get(name);
            if (null != logger) logger.log(Level.INFO, String.format(
                    "Mapping Operation | Name: %s, Class: %s\r\n", name, className));
            loadMapping(mapper, name, className);
        }
        return mapper;
    }

    public static OperationMapper loadMappings(JSONObject json,
                                               LambdaLogger logger) throws Exception {
        OperationMapper mapper = new OperationMapper();
        for(String name : json.keySet()) {
            String className = (String) json.get(name);
            if (null != logger) logger.log(String.format("Mapping Operation | Name: %s, Class: %s\r\n",
                    name, className));
            loadMapping(mapper, name, className);
        }
        return mapper;
    }
}
