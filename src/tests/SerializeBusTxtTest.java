package tests;

import main.Serializers.SerializeBusTxt;
import main.Serializers.SerializeBusXml;
import main.Serializers.Serializing;
import org.testng.annotations.DataProvider;
import main.*;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Writer;

import static org.testng.AssertJUnit.assertEquals;

public class SerializeBusTxtTest {
    Bus bus = new Bus(Marks.LAZ,12,"12FEFS32");
    File a = new File("C:\\Users\\Alex\\Desktop\\java\\Serialize\\src\\tests\\Bus.txt");
    SerializeBusTxt temp = new SerializeBusTxt();
    @DataProvider
    public Object[][] txtBusProvider() throws IOException {
        temp.serializingObj(bus,a);
        return new Object[][]{{new SerializeBusTxt()}};
    }

    @Test(dataProvider = "txtBusProvider")
    public void txtBusTestDeserialize(SerializeBusTxt bustxt) throws IOException, ClassNotFoundException {
        assertEquals(bustxt.deserializingObj(a), bus);
    }
}
