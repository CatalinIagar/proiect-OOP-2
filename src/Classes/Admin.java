package Classes;

public class Admin {
    private static char[] password = "1".toCharArray();

    public static boolean checkPassword(char[] pass){
        if (password.length != pass.length)
            return false;
        for (int i = 0; i < password.length; i++)
            if (password[i] != pass[i])
                return false;
        return true;
    }

}
