package main.Serializers;

import com.thoughtworks.xstream.XStream;
import main.Bus;
import main.Serializers.Serializing;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;


public class SerializeBusXml implements Serializing<Bus> {

    @Override
    public void serializingObj(Bus obj, File out) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(obj.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(obj, out);
    }

    @Override
    public Object deserializingObj(File in) throws IOException, JAXBException {
        JAXBContext context = JAXBContext.newInstance(Bus.class);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        return unmarshaller.unmarshal(in);
    }
}