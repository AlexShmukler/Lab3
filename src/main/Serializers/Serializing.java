package main.Serializers;
import com.fasterxml.jackson.databind.JsonMappingException;

import javax.xml.bind.JAXBException;
import java.io.*;

public interface Serializing<T> {

    void serializingObj(T obj, File out) throws IOException, JAXBException;

    Object deserializingObj(File in) throws IOException, ClassNotFoundException, JAXBException;

}