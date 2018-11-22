package parseXML;

public class Recepient {
    String email;
    String text;
    int id;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "parseXML.Recepient{" +
                "email='" + email + '\'' +
                ", text='" + text + '\'' +
                ", id=" + id +
                '}';
    }
}
