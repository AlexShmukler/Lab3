
public class Bus {
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
}
