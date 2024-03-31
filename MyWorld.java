import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    player bluePlayer = new player(0,0,0,255);
    player greenPlayer = new player(4,0,255,0);
    Counter blueCounter = new Counter();
    Counter greenCounter = new Counter();
    int count = 0;
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(700, 500, 1); 
        addObject(bluePlayer,500,400);
        addObject(blueCounter,650,50);
        addObject(greenPlayer,150,400);
        addObject(greenCounter,50,50);
    }
    public void act()
    {
        count++;
        if(count >100){
        addObject(new Food(), Greenfoot.getRandomNumber(getWidth()-1),Greenfoot.getRandomNumber(getHeight() -1));
        addObject(new boom(), Greenfoot.getRandomNumber(getWidth()-1),Greenfoot.getRandomNumber(getHeight() -1));
        count = 0;
        
        if(blueCounter.getScore()>4){
            addObject(new Blue(), getWidth()/2,getHeight()/2);
            Greenfoot.stop();
        }
        if(greenCounter.getScore()>4){
            addObject(new Green(), getWidth()/2,getHeight()/2);
            Greenfoot.stop();
        }
    }
    }
}
