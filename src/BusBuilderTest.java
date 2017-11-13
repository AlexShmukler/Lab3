import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BusBuilderTest {

    @DataProvider
    public Object[][] testBuildProvider(){
        return new Object[][]{ {Marks.Toyota, 201, "DF3234FE"}, {Marks.Toyota, 201, "DF3234FE32d"}, {Marks.Toyota, 0, "DF3234FE"} };
    }

    @Test(dataProvider = "testBuildProvider", expectedExceptions = IllegalArgumentException.class)
    public void testBuild(Marks mark, int capacity, String number){
        Bus a = new BusBuilder().build(mark,capacity,number);
    }
}