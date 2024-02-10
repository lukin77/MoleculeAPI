package hr.uniri.molapi.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class SimpleJdbcCallFactory {
    private final JdbcTemplate jdbcTemplate;
    private final Map<String, SimpleJdbcCall> cache = new ConcurrentHashMap<>();

    @Autowired
    public SimpleJdbcCallFactory(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public SimpleJdbcCall getSimpleJdbcCall(String functionName) {
        return cache.computeIfAbsent(functionName, k -> createSimpleJdbcCall(functionName));
    }

    private SimpleJdbcCall createSimpleJdbcCall(String functionName) {
        // Configure and return a new SimpleJdbcCall instance
        return new SimpleJdbcCall(jdbcTemplate)
                .withSchemaName("emolecules")
                .withFunctionName(functionName);
    }
}
