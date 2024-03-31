import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tail here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Tail extends Actor
{
    /**
     * Act - do whatever the Tail wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int r, g, b ,player;
    public int count = 0;
    public int countLength = 0;
    static int blueLength = 1;
    static int greenLength = 1;
    public Tail(int r,int g,int b)
    {
        this.r = r;
        this.g = g;
        this.b = b;
        getImage().setColor(new Color(r,g,b));
        getImage().fillRect(0,0,40,40);
    }
    public void act()
    {
        countLength = 1;
        follow();
        if(player == 0 && countLength % blueLength == 0){
            getWorld().removeObject(this);
            blueLength++;
        }
        if(player == 4 && countLength % greenLength == 0){
            getWorld().removeObject(this);
            greenLength++;
        }
    }
    public void follow()
    {
        count++;
        if(count > 30)
        getWorld().removeObject(this);
    }
}
