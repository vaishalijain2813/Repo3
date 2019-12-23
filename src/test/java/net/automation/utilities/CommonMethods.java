package net.automation.utilities;

public class CommonMethods
{
    public static int getRandomDoubleBetweenRange(int min, int max)
    {
        int x = (int) ((Math.random()*((max-min)+1))+min);
        return x;
    }
}
