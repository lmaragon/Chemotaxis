import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Chemotaxis extends PApplet {

 Bacteria one;
 Bacteria two;//declare bacteria variables here   
 Bacteria [] colony;
 Food pie;
 public void setup()   
 {     
 	noCursor();
 	size (400,400); 
 	pie = new Food();
 	one = new Bacteria();
 	two = new Bacteria();
 	background(255);
 	colony = new Bacteria[100];
 	for (int i=0; i<colony.length; i++)
 	{
 		colony[i] = new Bacteria();
 	}
 }   

public void picnic()
{
	fill(255,0,0);
	for(int k=20;k<400;k+=80)
	{
		for (int j=20;j<400;j+=80)
		{
		rect(j, k, 40, 40);
		}
	}
	
}

 public void draw()   
 {    
 	fill(255,255,255,10);
 	rect(0,0,400,400);
 	picnic();
 	pie.show2();
 	one.walk();
 	one.show();//move and show the bacteria   
 	two.walk();
 	two.show();
 	for (int i=0; i<colony.length; i++)
 	{
 		colony[i].walk();
 		colony[i].show();
 	}
 	
 }  
 class Bacteria    
 {     
 	int myX, myY;
 	Bacteria()
 	{
 		myX = PApplet.parseInt(random(400));
 		myY = PApplet.parseInt(random(400));
 	}
 	public void walk()
 	{
 		if (myX < mouseX && dist(myX,myY,mouseX,mouseY)<200)
 		{
 			myX = myX + (int)(Math.random()*4)-1;
 		}
 		if (myX > mouseX && dist(myX,myY,mouseX,mouseY)<200)
 		{
 			myX = myX + (int)(Math.random()*4)-2;
 		}
 		if (myY < mouseY && dist(myX,myY,mouseX,mouseY)<200)
 		{
 			myY = myY = myY + (int)(Math.random()*4)-1;
 		}
 		if (myY > mouseY && dist(myX,myY,mouseX,mouseY)<200)
 		{
 			myY = myY + (int)(Math.random()*4)-2;
 		}
 		else
 		{
 			myX = myX + (int)(Math.random()*3)-1;
 			myY = myY + (int)(Math.random()*3)-1;
 		}
 	}
 	public void show()
 	{
 		fill(0,0,0);
 		ellipse(myX,myY,10,10);
 	}
 }    

 class Food
 {
 	int x, y;
 	Food()
 	{
 		x = mouseX;
 		y = mouseY;
 	}
 	public void show2()
 	{
	 	fill(175,113,17);
	 	ellipse(mouseX, mouseY, 100, 100);
	 	fill(255,145,0);
	 	ellipse(mouseX, mouseY, 75, 75);
 	}
 }

  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Chemotaxis" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
