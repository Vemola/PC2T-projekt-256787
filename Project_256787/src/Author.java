
public class Author {
    public Author() {
        super();
        // TODO Auto-generated constructor stub
    }
    private String name;
    private String birthYear;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthYear() {
        return birthYear;
    }
    public void setBirthYear(String birthYear) {
        this.birthYear = birthYear;
    }
    @Override
    public String toString() {
        return "Author [name=" + name + ", birthYear=" + birthYear + ", getName()=" + getName() + ", getBirthYear()="
                + getBirthYear() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
                + super.toString() + "]";
    }

    // Constructors, getters, setters, and toString() methods
}
