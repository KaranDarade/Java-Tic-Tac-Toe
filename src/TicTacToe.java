import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
public class TicTacToe implements ActionListener
{
	JFrame f = new JFrame();
	JPanel status_panel = new JPanel();
	JPanel Gamekey_panel = new JPanel();
	JLabel status = new JLabel();
	JButton[] buttons = new JButton[9];
	boolean p1_turn;
	Random r = new Random();

	TicTacToe()
	{
		
		f.setLayout(new BorderLayout());
		f.setVisible(true);
		f.setTitle("TIC-TAC-TOE");
		f.setSize(400,400);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		status.setBackground(new Color(0,0,0));
		status.setForeground(new Color(255,255,255));
		status.setHorizontalAlignment(JLabel.CENTER);
		status.setOpaque(true);
		status_panel.setLayout(new BorderLayout());
		Gamekey_panel.setLayout(new GridLayout(3,3));
		Gamekey_panel.setBackground(new Color(0,0,0));
		
		for(int i=0;i<9;i++) 
		{
			buttons[i] = new JButton();
			Gamekey_panel.add(buttons[i]);
			buttons[i].setFont(new Font("TIMES NEW ROMAN",Font.BOLD,90));
			buttons[i].setFocusable(false);
			buttons[i].addActionListener(this);
		}
		
		status_panel.add(status);
		f.add(status_panel,BorderLayout.SOUTH);
		f.add(Gamekey_panel);
		
		firstmove();
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		for(int i=0;i<9;i++) 
		{
			if(e.getSource()==buttons[i])
			{
				if(p1_turn) {
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(0,0,0));
						buttons[i].setText("X");
						p1_turn=false;
						status.setText("O turn");
						conditions();
					}
				}
				else 
				{
					if(buttons[i].getText()=="")
					{
						buttons[i].setForeground(new Color(0,25,255));
						buttons[i].setText("O");
						p1_turn=true;
						status.setText("X turn");
						conditions();
					}
				}
			}			
		}
	}
	
	public void firstmove()
	{
		
		try {
			Thread.sleep(2000);//this time will specify whose turn it is.
			
			for(int i=0;i<9;i++)
			{
			buttons[i].setEnabled(true);
			}
			}
		catch (InterruptedException e) 
		{
			e.printStackTrace();
		}
		//if firstmove is equal to 0 then its player 1 turn
		//else its player 2 turn
		if(r.nextInt(2)==0) 
		{
			p1_turn=true;
			status.setText("X turn");
		}
		else
		{
			p1_turn=false;
			status.setText("O turn");
		}
	}
	public void ifxWins(int a,int b,int c)
	{
		buttons[a].setBackground(Color.GREEN);
		buttons[b].setBackground(Color.GREEN);
		buttons[c].setBackground(Color.GREEN);
		status.setText("X wins");
		for(int i=0;i<9;i++) 
		{
			buttons[i].setVisible(true);
			
			buttons[i].setEnabled(false);
        }
		
	}
	public void ifoWins(int x,int y,int z)
	{
		buttons[x].setBackground(Color.GREEN);
		buttons[y].setBackground(Color.GREEN);
		buttons[z].setBackground(Color.GREEN);
		status.setText("O wins");
		for(int i=0;i<9;i++)
		{
			buttons[i].setVisible(true);
			
			buttons[i].setEnabled(false);
		}
	}	
	public void conditions() 
	{
		// Possibilities for x to win
		if(
				(buttons[0].getText()=="X") &&
				(buttons[1].getText()=="X") &&
				(buttons[2].getText()=="X")
		  )
		{
			ifxWins(0,1,2);
		}
		
		if(
				(buttons[3].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[5].getText()=="X")
		  ) 
		{
			ifxWins(3,4,5);
		}
		
		if(
				(buttons[6].getText()=="X") &&
				(buttons[7].getText()=="X") &&
				(buttons[8].getText()=="X")
		  )
		{
			ifxWins(6,7,8);
		}
		
		if(
				(buttons[0].getText()=="X") &&
				(buttons[3].getText()=="X") &&
				(buttons[6].getText()=="X")
		  ) 
		{
			ifxWins(0,3,6);
		}
		
		if(
				(buttons[1].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[7].getText()=="X")
		  ) 
		{
			ifxWins(1,4,7);
		}
		
		if(
				(buttons[2].getText()=="X") &&
				(buttons[5].getText()=="X") &&
				(buttons[8].getText()=="X")
		  )
		{
			ifxWins(2,5,8);
		}
		
		if(
				(buttons[0].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[8].getText()=="X")
		  )
		{
			ifxWins(0,4,8);
		}
		
		if(
				(buttons[2].getText()=="X") &&
				(buttons[4].getText()=="X") &&
				(buttons[6].getText()=="X")
		  )
		{
			ifxWins(2,4,6);
		}
		
		//Possibilities for o to win
		if(
				(buttons[0].getText()=="O") &&
				(buttons[1].getText()=="O") &&
				(buttons[2].getText()=="O")
		  )
		{
			ifoWins(0,1,2);
		}
		
		if(
				(buttons[3].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[5].getText()=="O")
		  )
		{
			ifoWins(3,4,5);
		}
		
		if(
				(buttons[6].getText()=="O") &&
				(buttons[7].getText()=="O") &&
				(buttons[8].getText()=="O")
		  ) 
		{
			ifoWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[3].getText()=="O") &&
				(buttons[6].getText()=="O")
		  ) 
		{
			ifoWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[7].getText()=="O")
		  ) 
		{
			ifoWins(1,4,7);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[5].getText()=="O") &&
				(buttons[8].getText()=="O")
		  ) 
		{
			ifoWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[8].getText()=="O")
		  ) 
		{
			ifoWins(0,4,8);
		}
		if(
				(buttons[2].getText()=="O") &&
				(buttons[4].getText()=="O") &&
				(buttons[6].getText()=="O")
		  ) 
		{
			ifoWins(2,4,6);
		}
	}
	
}

	
