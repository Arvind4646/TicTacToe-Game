import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class TicTacToe
{
	JFrame fr=new JFrame("Tic Tac Toe");
	JLabel la=new JLabel(new ImageIcon(getClass().getResource("images/t2.jpg")));
	JPanel [] pa=new JPanel[3];
	JLabel msg=new JLabel("First Player Turn...");
	JButton reset=new JButton("RESET");
	JButton []bt=new JButton[9];
	ImageIcon icon1=new ImageIcon(getClass().getResource("images/user1.png"));
	ImageIcon icon2=new ImageIcon(getClass().getResource("images/user2.png"));
	int player=0;
	int c=0;
	int count=0;
	public TicTacToe()
	{
		fr.setSize(600,650);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(3);
		fr.setResizable(false);
		fr.add(la);
		addPanel();
		fr.setVisible(true);
	}
    private void addPanel()
	{
    	la.setLayout(null);
		for(int i=0;i<3;i++)
		{
			pa[i]=new JPanel();
			la.add(pa[i]);
		}
		pa[0].setBounds(40,30,510,40);
		pa[1].setBounds(40,100,510,440);
		pa[2].setBounds(40,560,510,40);
		addlabel();
	}
    private void addlabel()
    {
    	pa[0].setBackground(Color.cyan);
    	pa[0].add(msg);
    	msg.setForeground(Color.blue);
    	msg.setFont(new Font("elephant",0,25));
    	pa[2].setOpaque(false);
    	pa[2].add(reset);
    	reset.setForeground(Color.red);
    	reset.setBackground(Color.white);
    	reset.setEnabled(false);
    	reset.addActionListener(new ResetButton());
    	addButtons();
    }
    private void addButtons()
    {
    	pa[1].setLayout(new GridLayout(3,3));
    	AddImage listener=new AddImage();
    	for(int i=0;i<9;i++)
    	{
    			bt[i]=new JButton();
    			pa[1].add(bt[i]);
    			bt[i].addActionListener(listener);
    			bt[i].setBackground(Color.yellow);
    	}
    }
    class AddImage implements ActionListener
    {
    	public void actionPerformed(ActionEvent e)
    	{
    		JButton bb=(JButton)e.getSource();
    		if(bb.getIcon()!=null ||c==1)
    		{
    			JOptionPane.showMessageDialog(fr,"Wrong Clicked");
    			return;
    		}
    		if(player==0)
    		{
    		bb.setIcon(icon1);
    		msg.setText("Second Player Turn...");
    		player=1;
    		}
    		else if(player==1)
    		{
    		bb.setIcon(icon2);
    		msg.setText("First Player Turn...");
    		player=0;
    		}
    		count++;
    		turns();
    	}
    }
    		public void turns()
    		{
    			if(bt[0].getIcon()==icon1&&bt[1].getIcon()==icon1&&bt[2].getIcon()==icon1)
        		{
        			declareWinner(0,1,2,"first");
        		}
        		if(bt[0].getIcon()==icon2&&bt[1].getIcon()==icon2&&bt[2].getIcon()==icon2)
        		{
        			declareWinner(0,1,2,"Second");
        		}
        		if(bt[3].getIcon()==icon1&&bt[4].getIcon()==icon1&&bt[5].getIcon()==icon1)
        		{
        			declareWinner(3,4,5,"first");
        		}
        		if(bt[3].getIcon()==icon2&&bt[4].getIcon()==icon2&&bt[5].getIcon()==icon2)
        		{
        			declareWinner(3,4,5,"Second");
        		}
        		if(bt[6].getIcon()==icon1&&bt[7].getIcon()==icon1&&bt[8].getIcon()==icon1)
        		{
        			declareWinner(6,7,8,"first");
        		}
        		if(bt[6].getIcon()==icon2&&bt[7].getIcon()==icon2&&bt[8].getIcon()==icon2)
        		{
        			declareWinner(6,7,8,"Second");
        		}
        		if(bt[0].getIcon()==icon1&&bt[3].getIcon()==icon1&&bt[6].getIcon()==icon1)
        		{
        			declareWinner(0,3,6,"first");
        		}
        		if(bt[0].getIcon()==icon2&&bt[3].getIcon()==icon2&&bt[6].getIcon()==icon2)
        		{
        			declareWinner(0,3,6,"Second");
        		}
        		if(bt[1].getIcon()==icon1&&bt[4].getIcon()==icon1&&bt[7].getIcon()==icon1)
        		{
        			declareWinner(1,4,7,"first");
        		}
        		if(bt[1].getIcon()==icon2&&bt[4].getIcon()==icon2&&bt[7].getIcon()==icon2)
        		{
        			declareWinner(1,4,7,"Second");
        		}
        		if(bt[2].getIcon()==icon1&&bt[5].getIcon()==icon1&&bt[8].getIcon()==icon1)
        		{
        			declareWinner(2,5,8,"first");
        		}
        		if(bt[2].getIcon()==icon2&&bt[5].getIcon()==icon2&&bt[8].getIcon()==icon2)
        		{
        			declareWinner(2,5,8,"Second");
        		}
        		if(bt[0].getIcon()==icon1&&bt[4].getIcon()==icon1&&bt[8].getIcon()==icon1)
        		{
        			declareWinner(0,4,8,"first");
        		}
        		if(bt[0].getIcon()==icon2&&bt[4].getIcon()==icon2&&bt[8].getIcon()==icon2)
        		{
        			declareWinner(0,4,8,"Second");
        		}
        		if(bt[2].getIcon()==icon1&&bt[4].getIcon()==icon1&&bt[6].getIcon()==icon1)
        		{
        			declareWinner(2,4,6,"first");
        		}
        		if(bt[2].getIcon()==icon2&&bt[4].getIcon()==icon2&&bt[6].getIcon()==icon2)
        		{
        			declareWinner(2,4,6,"Second");
        		}
        		if(c==1)
        		{
        			return;
        		}
        		else if(count==9)
        		{
        			msg.setText("Match Draw");
        			JOptionPane.showMessageDialog(fr,"No One Wins");
        			reset.setEnabled(true);
        		}
    		}
    private void declareWinner(int i,int j,int k,String p)
    {
    	bt[i].setBackground(Color.green);
    	bt[j].setBackground(Color.green);
    	bt[k].setBackground(Color.green);
    	c=1;
    	JOptionPane.showMessageDialog(fr,p +"Player Wins");
    	reset.setEnabled(true);
    }
    class ResetButton implements ActionListener
    {
		public void actionPerformed(ActionEvent e)
		{
			for(int i=0;i<9;i++)
	    	{
	    		bt[i].setIcon(null);
	    		bt[i].setBackground(Color.yellow);
	    	}
		  msg.setText("First Player Turn...");
		  reset.setEnabled(false);
		  c=0;
		  player=0;
		  count=0;
		}
    }
  public static void main(String[] args)
  {
	new TicTacToe();
  }
}
