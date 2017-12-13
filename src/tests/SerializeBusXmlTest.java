package tests;

import main.*;
import main.Serializers.SerializeBusXml;
import main.Serializers.Serializing;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;


import static org.testng.AssertJUnit.assertEquals;

public class SerializeBusXmlTest {

        Bus bus1 = new Bus(Marks.LAZ, 12, "12FEFS32");
        File a = new File("C:\\Users\\Alex\\Desktop\\java\\Serialize\\src\\tests\\Bus.xml");
        SerializeBusXml temp = new SerializeBusXml();


    @DataProvider
    public Object[][] xmlBusProvider() throws IOException, JAXBException {

        new SerializeBusXml().serializingObj(bus1,a);
        return new Object[][]{{ new SerializeBusXml() }};
    }

    @Test(dataProvider = "xmlBusProvider")
    public void xmlBusTestDeserialize(SerializeBusXml busXml) throws IOException, JAXBException {
        temp.serializingObj(bus1,a);
        assertEquals(busXml.deserializingObj(a), bus1);
    }
}
