package lab17;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.Color;

public class PixelPainter extends JFrame implements KeyListener{
	
	private Color yellow = Color.YELLOW;
	private Color white = Color.WHITE;
	private Color black = Color.BLACK;
		
	private JPanel[][] pixel = new JPanel[16][16];
	private JPanel[][] paint = new JPanel[16][16];
	private Color[][] color_state = new Color[16][16]; //save the state of the color of the panel
	private JPanel paint_board = new JPanel(new GridLayout(16, 16, 2, 2));
		
	private int row;
	private int col;

	public PixelPainter()
	{
		super("Pixel Painter");
		setSize(400, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		int x = 0;
		int y = 0;
		
		for(x=0; x<16; ++x)
		{
			for(y=0; y<16; ++y)
			{
				pixel[x][y] = new JPanel();
				//initiate JPanel <pixel>
				
				color_state[x][y] = white;
				//set color_state of all pixel as white
				
				pixel[x][y].setBackground(color_state[x][y]); //set background color
				
				paint_board.add(pixel[x][y]); //add JPanel <pixel> to the JPanel <paint_board> which has a GridLayout
			}
		}
		
		row = 0;
		col = 0;
		//start point
		
		pixel[row][col].setBackground(yellow); //start point
		
		add(paint_board);
		
		addKeyListener(this);
		
	}
	
	@Override
	public void keyTyped(KeyEvent ke)
	{
		
	}
	
	@Override
	public void keyPressed(KeyEvent ke)
	{
		int keyCode = ke.getKeyCode();
		
		
		if(keyCode == KeyEvent.VK_SPACE)
		{
			if(color_state[row][col] == white)
			{
				color_state[row][col] = black;
				//if color_state is white when the space key is pressed,
				//change color_state into black
			}else
			{
				color_state[row][col] = white;
				//if color_state is not white when the space key is pressed,
				//change color_state into white
			}
		}
		
		if(keyCode == KeyEvent.VK_UP)
		{
			if(row!=0)
			{
				pixel[row][col].setBackground(color_state[row][col]);
				//change the pixel's color into the saved color_state
				pixel[--row][col].setBackground(yellow);
				//move pixel pointer
			}else
			{
				pixel[row][col].setBackground(white);
			}			
		}else if(keyCode == KeyEvent.VK_DOWN)
		{
			if(row!=15)
			{
				pixel[row][col].setBackground(color_state[row][col]);
				//change the pixel's color into the saved color_state
				pixel[++row][col].setBackground(yellow);
				//move pixel pointer
			}else
			{
				pixel[row][col].setBackground(white);
			}
		}else if(keyCode == KeyEvent.VK_RIGHT)
		{
			if(col!=15)
			{
				pixel[row][col].setBackground(color_state[row][col]);
				//change the pixel's color into the saved color_state
				pixel[row][++col].setBackground(yellow);
				//move pixel pointer
			}else
			{
				pixel[row][col].setBackground(white);
			}
		}else if(keyCode == KeyEvent.VK_LEFT)
		{
			if(col!=0)
			{
				pixel[row][col].setBackground(color_state[row][col]);
				//change the pixel's color into the saved color_state
				pixel[row][--col].setBackground(yellow);
				//move pixel pointer
			}else
			{
				pixel[row][col].setBackground(white);
			}
		}
	}
	
	@Override
	public void keyReleased(KeyEvent ke)
	{
		
	}

}
