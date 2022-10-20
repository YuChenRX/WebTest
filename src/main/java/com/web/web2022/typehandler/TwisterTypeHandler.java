package com.web.web2022.typehandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.web.web2022.model.domain.Twister;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.sql.*;
import java.util.LinkedHashMap;
import java.util.List;

@MappedJdbcTypes(JdbcType.CLOB)
@MappedTypes({LinkedHashMap.class})
@Component
public class TwisterTypeHandler extends BaseTypeHandler<LinkedHashMap<String, List<Twister>>> {
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(
        PreparedStatement preparedStatement,
        int i,
        LinkedHashMap<String, List<Twister>> stringListMap,
        JdbcType jdbcType
    ) throws SQLException {
        String s = mapToJson(stringListMap);
        StringReader reader = new StringReader(s);
        preparedStatement.setCharacterStream(i, reader, s.length());
    }

    @Override
    public LinkedHashMap<String, List<Twister>> getNullableResult(
        ResultSet resultSet,
        String s
    ) throws SQLException {
        String value = "";
        Clob clob = resultSet.getClob(s);
        if (clob != null) {
            int size = (int) clob.length();
            value = clob.getSubString(1L, size);
        }

        return jsonToMap(value);
    }

    @Override
    public LinkedHashMap<String, List<Twister>> getNullableResult(
        ResultSet resultSet,
        int i
    ) throws SQLException {
        String value = "";
        Clob clob = resultSet.getClob(i);
        if (clob != null) {
            int size = (int) clob.length();
            value = clob.getSubString(1L, size);
        }

        return jsonToMap(value);
    }

    @Override
    public LinkedHashMap<String, List<Twister>> getNullableResult(
        CallableStatement callableStatement, int i
    ) throws SQLException {
        String value = "";
        Clob clob = callableStatement.getClob(i);
        if (clob != null) {
            int size = (int) clob.length();
            value = clob.getSubString(1L, size);
        }

        return jsonToMap(value);
    }

    private LinkedHashMap<String, List<Twister>> jsonToMap(String from) {
        try {
            return objectMapper.readValue(from, LinkedHashMap.class);
        } catch (JsonProcessingException e) {
            throw new Error();
        }
    }

    private String mapToJson(LinkedHashMap<String, List<Twister>> from) {
        try {
            return objectMapper.writeValueAsString(from);
        } catch (JsonProcessingException e) {
            throw new Error();
        }
    }
}
