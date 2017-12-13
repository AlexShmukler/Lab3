package main.Serializers;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.sun.xml.internal.ws.developer.SerializationFeature;
import main.*;
import main.Serializers.Serializing;

import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.*;

public class SerializeBusTxt implements Serializing<Bus> {
    @Override
    public void serializingObj(Bus obj, File out) throws IOException {
   
        FileOutputStream fout = new FileOutputStream(out);
        ObjectOutputStream oout = new ObjectOutputStream(fout);
        oout.writeObject(obj);
        oout.flush();
        oout.close();
    }

    @Override
    public Object deserializingObj(File in) throws IOException, ClassNotFoundException {
      
        FileInputStream fin = new FileInputStream(in);
        ObjectInputStream ois = new ObjectInputStream(fin);
        Bus bus = (Bus) ois.readObject();
        return bus;

    }
}