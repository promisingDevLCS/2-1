package tictactoe;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class java11W extends JFrame implements ActionListener {
	private JButton buttons[][];
	private String labels[] = {" ", " ", " ", " ", " ", " ", " ", " ", " "};
	private char turn ='X';
	
	public java11W() {
		setTitle("Tic Tac Toe");
		setSize(400, 400);
		buttons = new JButton[3][3];
			
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 3));
		int index= 0;
		
		for(int i=0; i<3; i++) {
			for(int k=0; k<3; k++) {
				// 각각의 인덱스 마다 객체를 생성
				buttons[i][k] = new JButton(labels[index]);
				// 이벤트 처리를 이 클래스 안에서 해결
				buttons[i][k].addActionListener(this); 
				panel.add(buttons[i][k]);
				index++;
			}
		}
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println(buttons[0][0].getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(e.getSource()==buttons[i][j] && buttons[i][j].getText().
						equals(" ")== true) {
					
					if( turn == 'X') {
						buttons[i][j].setText("X");
						turn = 'O';
					}
					else {
						buttons[i][j].setText("O");
						turn = 'X';
					}
				}
			}
		}
		for(int i=0; i<3; i++) {
			// 가로줄 확인
			if(buttons[i][0].getText().equals(buttons[i][1].getText()) &&
					buttons[i][0].getText().equals(buttons[i][2].getText())) {
				if(buttons[i][0].getText().equals(" ")== true)
					continue;
				System.out.println(buttons[i][0].getText()+"가 이겼습니다!");
				//System.exit(1);
			}
			// 세로줄 확인
			else if(buttons[0][i].getText().equals(buttons[1][i].getText()) &&
					buttons[0][i].getText().equals(buttons[2][i].getText())) {
				if(buttons[0][i].getText().equals(" ")== true)
					continue;
				System.out.println(buttons[0][i].getText()+"가 이겼습니다!");
			}
		}
		// 대각선 확인
		if(buttons[0][0].getText().equals(buttons[1][1].getText()) &&
				buttons[0][0].getText().equals(buttons[2][2].getText())) {
			if(buttons[0][0].getText().equals(" ")== true) {
				
			}
			else {
				System.out.println(buttons[0][0].getText()+"가 이겼습니다!");	
			}
		}
		if(buttons[0][2].getText().equals(buttons[1][1].getText()) &&
				buttons[0][2].getText().equals(buttons[2][0].getText())) {
			if(buttons[0][2].getText().equals(" ")== true) {
				
			}
			else {
				System.out.println(buttons[0][2].getText()+"가 이겼습니다!");	
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java11W f  = new java11W();	
	}

}
