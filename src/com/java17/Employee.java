package src.com.java17;

public record Employee(int id, String name)  {

    public String display() {
        return id + " - " + name;
    }

    public static void main(String[] args) {
        Employee e = new Employee(1, "John");

        System.out.println(e.display());
    }
}
