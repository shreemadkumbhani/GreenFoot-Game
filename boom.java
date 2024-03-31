import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class boom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class boom extends Actor
{
    public boom(){
        getImage().scale(40,40);
    }
    /**
     * Act - do whatever the boom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int count = 0;
    public void act()
    {
        count++;
        if(count > 400)
        getWorld().removeObject(this);
        else if (isTouching(player.class))
        getWorld().removeObject(this);
        // Add your action code here.
    }
}
