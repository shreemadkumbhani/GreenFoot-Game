import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class player extends Actor
{
    /**
     * Act - do whatever the player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
   
    public int r, g, b, player;
    public int speed = 3;
    public int count = 0;
     
    public player(int player,int r, int g, int b)
    {
        setRotation(270);
        this.r = r;
        this.g = g;
        this.b = b;
        this.player = player;
        getImage().setColor(new Color(r,g,b));
        getImage().fillRect(0,0,40,40);
    }
    public void act()
    {
        count++;
        getWorld().addObject(new Tail(r,g,b), getX(),getY());
        move(speed);
        moveAround();
        eatFood();
        touchboom();
        if (isAtEdge()) 
        {
            if(getX()<720 && getX() > 680)
                setLocation(700-getX(), getY());//right
            if(getY()<520 && getY() > 480)
                setLocation(getX(),500-getY());//bottom
        }
        if (isAtEdge())
        {
            if(getX()>-20 && getX() < 20)
                setLocation(getX()+700, getY());//left
            if(getY()>-20 && getY() < 20)
                setLocation(getX(), getY()+500);
        }
    }
    public void touchboom(){
        if (isTouching(boom.class)&& player == 4){
            removeTouching(boom.class);
            ((MyWorld)getWorld()).greenCounter.subScore();
            
        }
        if (isTouching(boom.class)&& player == 0){
            removeTouching(boom.class);
            ((MyWorld)getWorld()).blueCounter.subScore();
            
        }
    }
    
    public void moveAround()
    {
            if(this.player == 0){
            if(Greenfoot.isKeyDown("right"))
                setRotation(0);
            if(Greenfoot.isKeyDown("left"))
                setRotation(180);
            if(Greenfoot.isKeyDown("up"))
                setRotation(270);
            if(Greenfoot.isKeyDown("down"))
                setRotation(90);
        }
        if(this.player == 4){
            if(Greenfoot.isKeyDown("d"))
                setRotation(0);
            if(Greenfoot.isKeyDown("a"))
                setRotation(180);
            if(Greenfoot.isKeyDown("w"))
                setRotation(270);
            if(Greenfoot.isKeyDown("s"))
                setRotation(90);
        }
    }
    public void eatFood()
    {
        if(isTouching(Food.class) && player == 0)
        {
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.blueCounter.addScore();
        }
        if(isTouching(Food.class) && player == 4)
        {
            MyWorld myWorld = (MyWorld) getWorld();
            myWorld.greenCounter.addScore();
        }
    }
}
