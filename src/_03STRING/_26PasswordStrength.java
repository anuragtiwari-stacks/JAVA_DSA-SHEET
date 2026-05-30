package _03STRING;
//3941-Password Strength

public class _26PasswordStrength
{
    public static void main(String[] args)
    {
        String password = "Aa1!Bb2@";

        int ans = passwordStrength(password);

        System.out.println("Password Strength = " + ans);
    }

    public static int passwordStrength(String password)
    {
        boolean[] lower = new boolean[26];
        boolean[] upper = new boolean[26];
        boolean[] digit = new boolean[10];

        boolean exclamation = false;
        boolean at = false;
        boolean hash = false;
        boolean dollar = false;

        int strength = 0;

        for (char ch : password.toCharArray())
        {
            if (ch >= 'a' && ch <= 'z')
            {
                if (lower[ch - 'a'] == false)
                {
                    lower[ch - 'a'] = true;
                    strength = strength + 1;
                }
            }
            else if (ch >= 'A' && ch <= 'Z')
            {
                if (upper[ch - 'A'] == false)
                {
                    upper[ch - 'A'] = true;
                    strength = strength + 2;
                }
            }
            else if (ch >= '0' && ch <= '9')
            {
                if (digit[ch - '0'] == false)
                {
                    digit[ch - '0'] = true;
                    strength += 3;
                }
            }
            else if (ch == '!')
            {
                if (exclamation == false)
                {
                    exclamation = true;
                    strength = strength + 5;
                }
            }
            else if (ch == '@')
            {
                if (at == false)
                {
                    at = true;
                    strength = strength + 5;
                }
            }
            else if (ch == '#')
            {
                if (hash == false)
                {
                    hash = true;
                    strength = strength + 5;
                }
            }
            else if (ch == '$')
            {
                if (dollar == false)
                {
                    dollar = true;
                    strength = strength + 5;
                }
            }
        }

        return strength;
    }
}