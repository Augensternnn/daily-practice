import java.util.List;

public class User {
    private String name;
    private List<String> phoneNumber;
    private String remarks;

    public User(String name, List<String> phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public boolean is(String name){
        return this.name.equals(name);
    }

    public String getName(){
        return name;
    }

    public List<String> getPhoneNumber(){
        return phoneNumber;
    }

}
