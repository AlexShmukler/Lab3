package tests;

import main.Bus;
import main.Marks;
import main.Serializers.SerializeBusJSON;
import main.Serializers.SerializeBusTxt;
import main.Serializers.Serializing;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import static org.testng.AssertJUnit.assertEquals;


public class SerializeBusJSONTest {
    Bus bus = new Bus(Marks.LAZ,12,"12FEFS32");
    File a = new File("C:\\Users\\Alex\\Desktop\\java\\Serialize\\src\\tests\\Bus.json");
    SerializeBusJSON temp = new SerializeBusJSON();
    @DataProvider
    public Object[][] jsonBusProvider() throws IOException {
        temp.serializingObj(bus,a);
        return new Object[][]{{new SerializeBusJSON()}};
    }

    @Test(dataProvider = "jsonBusProvider")
    public void jsonBusTestDeserialize(SerializeBusJSON busJson) throws IOException, ClassNotFoundException {
        assertEquals(busJson.deserializingObj(a), bus);
    }
}
