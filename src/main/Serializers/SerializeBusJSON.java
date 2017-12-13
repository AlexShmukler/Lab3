package main.Serializers;


import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import main.Bus;

import java.io.*;

public class SerializeBusJSON implements Serializing<Bus>{
    @Override
    public void serializingObj(Bus obj, File out) throws IOException{
  
        Gson gson = new Gson();
        String string = gson.toJson(obj);
        try (FileWriter fileWriter = new FileWriter(out)) {
            fileWriter.write(string);
        } catch (IOException ex) {
        }

    }

    @Override
    public Bus deserializingObj(File in) throws IOException {
        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(in));
            Bus  bus = gson.fromJson(new FileReader(in.toString()), Bus.class);
            return bus;
        } catch (FileNotFoundException ex) {
        }
        return null;
    }
}
