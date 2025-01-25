package it.unibo.monoopoly.utils.api;

import java.io.InputStream;
import java.util.List;

/**
 * Represent a tool to translate a Json file in a collection of a given Java object.
 * 
 * @param <T> the class of the elements that the json file will be converted to
 */
public interface JsonConverter<T> {

    /**
     * Convert a json file in a list of type T.
     * @param fileJson the path of the file to convert
     * @return the converted list.
     */
    List<T> jsonToList(InputStream fileJson);

}
