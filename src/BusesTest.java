import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BusesTest {
    Bus bus1,bus2,bus3;
    Buses buses1, buses2;

    @BeforeTest
    public void setup(){
        buses1 = new Buses(15,"New Avenue 29",12);
        buses2 = new Buses();
        bus1 = new BusBuilder().build(Marks.Mercedes,43,"FE3242GR");
        bus2 = new BusBuilder().build(Marks.Toyota,31,"FE3242GR");
        bus3 = new BusBuilder().build(Marks.Volvo,78,"FE3242GR");
        buses1.addBus(bus1);
        buses1.addBus(bus2);
        buses2.addBus(bus2);
        buses2.addBus(bus3);
    }
    @DataProvider
    public Object[][] providerIsEnoughtBuses(){
        return new Object[][]{ {buses1,71,true}, {buses1,89,false}, {buses2,102,true} };
    }

    @Test(dataProvider = "providerIsEnoughtBuses")
    public void testIsEnoughtBuses(Buses buses, int people, boolean result){
        assertEquals(buses.isEnoughtBuses(people),result);
    }

    @DataProvider
    public Object[][] providerGetLocation(){
        return new Object[][]{ {buses1,"New Avenue 29"}, {buses2,"Main Str. 32"} };
    }
    @Test(dataProvider = "providerGetLocation")
    public void testGetLocation(Buses buses, String location) {
        assertEquals(buses.getLocation(),location);
    }

}