import processing.core.*;

public class App extends PApplet{
    Ellipse hero;
    PVector position; 
    PVector velocity;
    PVector acceleration;
    boolean isJumping;
    float jumpPower = 12;
    public static void main(String[] args)  {
        PApplet.main("App");
    }

    public void setup(){
        hero = new Ellipse(this, 1000, height-25, 50, 50);
        position = new PVector(1000, height-25);
        velocity = new PVector(0, 0);
        acceleration = new PVector(0,0.2f);
    }

    public void settings(){
        size(2000, 1200);
    }

    public void draw(){
        background(200);
        update();
        
        hero.setX(position.x);
        hero.setY(position.y);

        hero.display();
        
        System.out.println(velocity);
    }

    public void update(){
        if(isJumping){
            velocity.y = -jumpPower;
            isJumping = false;
        }

        velocity.add(acceleration);
        position.add(velocity);
      
        if(position.y >= height - hero.getHeight()/2){
            position.y = height - hero.getHeight()/2;
            velocity.y = 0;
        }
}

    public void keyPressed(){
        if(key == ' ' && hero.getY() >= height - hero.getHeight()/2){
            System.out.println("jump!");
            isJumping = true;
        }
    }
}
