import com.google.gson.Gson;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.Serializable;
import java.io.*;

public class Bus implements Serializable{
    private Marks mark;
    private int capacity;
    private String number;

    public Bus(Marks mark, int capacity, String number) {
        this.mark = mark;
        this.capacity = capacity;
        this.number = number;
    }

    public int busesNeeded(int people) {
        if (people <= 1) throw new IllegalArgumentException("Wrong amount of people");
        int result = (int)people / this.capacity;
        if (result * this.capacity < people)
            result++;
        return result;
    }

    public boolean isEnoughtSpace(int people){
        return this.capacity >= people;
    }

    public void writeObjectToFile(Bus object) throws IOException {
        FileOutputStream fos = new FileOutputStream("temp.out");
        ObjectOutputStream serial = new ObjectOutputStream(fos);
        serial.writeObject(object);
    }
     public Bus readObjectFromFile() throws IOException, ClassNotFoundException {
         FileInputStream fis = new FileInputStream("temp.out");
         ObjectInputStream oin = new ObjectInputStream(fis);
         Bus result = (Bus) oin.readObject();
         return result;
     }

    public void writeToXML(Bus bus){

    }

    public void writeToJSON() {
        JSONArray data = new JSONArray();
        data.add(this.mark);
        data.add(this.capacity);
        data.add(this.number);

        JSONObject obj = new JSONObject();
        obj.put("name", "abcd");
        obj.put("age", new Integer(100));
        JSONArray list = new JSONArray();
        list.add("msg 1");
        list.add("msg 2");
        list.add("msg 3");
        obj.put("messages", list);
        try {
            FileWriter file = new FileWriter("c:\\test.json");
            file.write(obj.toString());
            file.flush();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print(obj);


       /* JSONArray company = new JSONArray();
        company.add("Compnay: eBay");
        company.add("Compnay: Paypal");
        company.add("Compnay: Google");
        obj.put("Company List", company);

        // try-with-resources statement based on post comment below :)
        try (FileWriter file = new FileWriter("file.txt")) {
            file.write(obj.toJSONString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/
    }
        @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || this.getClass() != obj.getClass())
            return false;
        Bus temp = (Bus) obj;
        return ((this.capacity == temp.capacity) || (this.mark == temp.mark) || (this.number == temp.number));
    }

    @Override
    public int hashCode() {
        int result = mark.hashCode();
        result = 31 * result + capacity;
        result = 31 * result + number.hashCode();
        return result;
    }

    public Marks getMark() {
        return mark;
    }

    public int getCapacity() {
        return capacity;
    }

    public String getNumber() {
        return number;
    }

    public void setMark(Marks mark) {
        this.mark = mark;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Bus bus = new Bus(Marks.LAZ,13,"23FEDS32");
    }
}
