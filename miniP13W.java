package miniP13W;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.*;

class Monster {
	int x, y, hp;
	Image img;

	public Monster() {}

	public Monster(int x, int y, int hp) {
		super();
		this.x = x;
		this.y = y;
		this.hp = hp;
		ImageIcon icon = new ImageIcon("C:\\Users\\82107\\Pictures\\monster.jpg");
		img = icon.getImage();
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, x, y, 50, 50, null);
	}
}

public class miniP13W extends JFrame implements MouseListener{
	JPanel p1;	// �׸��� ���콺 �̺�Ʈ ó���� ���� �г�
	Image img;
	Timer timer;
	
	int x, y;	// ������ ��ġ ��ǥ
	int idx;	// ���͸� Ŭ�� �� ���� �� ����� �ε��� ��ȣ
	int sum;	// ����
	double time = 20;	// ���ѽð�
	ArrayList<Monster> Mlist = new ArrayList<>();

	public miniP13W() {
		setTitle("���� ��� ����");
		setSize(800, 400);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		for (int i = 0; i < 10; i++) { // arraylist�� monster ��ü ����
			x = (int) (Math.random() * 700);
			y = (int) (Math.random() * 200);
			Mlist.add(new Monster(x, y, 100));
		}
		p1 = new Draw_Panel();
		p1.addMouseListener(this);
		add(p1);
		setVisible(true);
		timer = new Timer(2000, new ActionListener() {	// 1s = 1000ms
			public void update() {
				if(time == 0) {
					System.out.println("���� ����: "+ sum);
					System.exit(1);
				}
				time = time-2.5;
				for (int i = 0; i < Mlist.size(); i++) { // arraylist�� monster ��ü ����
					x = (int) (Math.random() * 700);
					y = (int) (Math.random() * 200);
					Mlist.get(i).x = x; Mlist.get(i).y = y;
				}
			}
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				update();
				repaint();
			}
			
		});
		timer.start();
	}

	class Draw_Panel extends JPanel {
		protected void paintComponent(Graphics g) {
			{
				super.paintComponents(g);
				for (Monster m : Mlist) {
					m.draw(g);
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(Mlist.size()==0) {
			System.out.println("���� ����: "+ sum);
			System.exit(1);
		}
		
		for(int i=0;i<Mlist.size();i++) {	// �浹 ����
			if(e.getX()>=Mlist.get(i).x && e.getX() <=Mlist.get(i).x+50 &&
					e.getY()>=Mlist.get(i).y && e.getY() <=Mlist.get(i).y+55) {
				Mlist.remove(i);			// �浹�� �ε��� ����
				sum++;
				System.out.println("����: "+ sum);
				repaint();
			}
		}
	}
	

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	public static void main(String[] args) {
		miniP13W f = new miniP13W();
	}
}