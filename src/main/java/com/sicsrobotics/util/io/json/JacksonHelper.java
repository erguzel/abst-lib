package com.sicsrobotics.util.io.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.*;
import com.sicsrobotics.util.exeption.SicsException;

/**
 * Jackson parsing
 */
public class JacksonHelper {
    /**
     * Object mapper
     */
    private static final ObjectMapper myObjectMapper =
            new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

    /**
     * read json to a generic class
     *
     * @param clazz class to read
     * @param <T>   class type
     * @return object with json data
     * @throws JsonProcessingException
     */
    public static <T> T fromJson(String jsonSource, Class<T> clazz) throws SicsException {
        JsonNode node = null;
        T result = null;
        try {
            node = myObjectMapper.readTree(jsonSource);
            result = myObjectMapper.treeToValue(node, clazz);
        } catch (Throwable e) {
            SicsException.Handle("Json object converting failed",false,false,true,e);
        }
        return result;
    }

    /**
     * Stringifies object to json
     *
     * @param obj
     * @param pretty
     * @return
     * @throws SicsException
     */
    public static String stringify(Object obj, boolean pretty) throws SicsException {
        JsonNode node = null;
        try {
            node = myObjectMapper.valueToTree(obj);
        } catch (Throwable ex) {
            SicsException.Handle("Json object stringify failed",false,false,true,ex);
        }
        return generateJson(node, pretty);
    }

    /**
     * generates json from given object
     *
     * @param o      obj to create json
     * @param pretty true if indent
     * @return json string
     * @throws JsonProcessingException
     */
    private static String generateJson(Object o, boolean pretty) throws SicsException {
        ObjectWriter ow = null;
        String result = null;
        try {
            ow = myObjectMapper.writer();
            if (pretty) {
                ow = ow.with(SerializationFeature.INDENT_OUTPUT);
            }
            result = ow.writeValueAsString(o);
        } catch (Throwable e) {
            SicsException.Handle("generateJson method failed",false,false,true,e);
        }
        return result;
    }
}
