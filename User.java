public abstract class User {
    protected String username;
    protected String password;
    protected String name;

    public User(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getName() {
        return name;
    }

    // Abstract method untuk menampilkan dashboard sesuai role
    public abstract void displayDashboard();
}
