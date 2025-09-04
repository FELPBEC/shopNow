package MODEL;

public class Client {
    private String name;
    private String id;
    private String email;
    public Client(String name, String id, String email) {
        this.name = name;
        this.id = id;
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void showClientInformation(){
        System.out.println("Client Information"+"\n"+"Name: "+ name + "\n"+ "Email: "+ email + "\n"+ "Id:"+ id);
    }
    
}
