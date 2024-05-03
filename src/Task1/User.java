package Task1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private String login;
    private String password;
    private String confirmPassword;

    public User(String login, String password, String confirmPassword) {
        this.login = login;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "User login= " + login + ", password= " + password + ", confirmPassword= " + confirmPassword;
    }

    public void checkingForLogin() {
        try {
            if (login.length() > 20) {
                throw new WrongLoginException();
            }
        } catch (WrongLoginException e) {
            System.out.println("login должен быть меньше 20 символов " + e);;
        }
        try {
            Pattern p = Pattern.compile("\\s");
            Matcher m = p.matcher(login);
            while (m.find()){
                throw new WrongLoginException();
            }
        }catch (WrongLoginException e){
            System.out.println("login не должен содержать пробелы " + e);
        }
    }

    public void checkingForPassword() {
        try {
            if (password.length() > 20) {
                throw new WrongPasswordException();
            }
        } catch (WrongPasswordException e) {
            System.out.println("password должен быть меньше 20 символов " + e);
        }
        try {
            Pattern p1 = Pattern.compile("\\s");
            Matcher m1 = p1.matcher(password);
            while (m1.find()) {
                throw new WrongPasswordException();
            }
        }catch (WrongPasswordException e){
            System.out.println("password не должен содержать пробелы " + e);
        }
        try {
            int count = 0;
            Pattern p2 = Pattern.compile("\\d");
            Matcher m2 = p2.matcher(password);
            while (m2.find()){
                count++;
            }
            if(count == 0){
                throw new WrongPasswordException();
            }
        }catch (WrongPasswordException e){
            System.out.println("password должен содержать хотя бы одну цифру " + e);
        }
        try {
            if(!password.equals(confirmPassword)){
                throw new WrongPasswordException();
            }
        }catch (WrongPasswordException e){
            System.out.println("password и comfirmPasssword должны быть ровны " + e);
        }

    }
}
