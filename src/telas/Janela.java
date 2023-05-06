package telas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.ImageConsumer;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame implements MouseMotionListener, MouseWheelListener, KeyListener {

	private JButton btn1, btn2, btn3, btnSel;
	private int x, y;

	public Janela(int largura, int altura) {
		super("Exemplo JFrame com uso de interfaces");
		setSize(largura, altura);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		x = largura / 4;
		y = altura / 2;

		btn1 = new JButton("Botão 1");
		btn1.setSize(100, 30);
		btn1.setLocation(x, y);
		add(btn1);
		btnSel = btn1;

		btn2 = new JButton("Botão 2");
		btn2.setBounds(x + 200, y, 100, 30);
		add(btn2);

		btn3 = new JButton("Botão 3");
		btn3.setBounds(x + 400, y, 100, 30);
		add(btn3);

		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("mouse enter");
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("mouse exit");
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("clicou botão: " + e.getButton());
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("pressionou");
			}
			
			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("soltou");
			}
		});
		
		addMouseMotionListener(this);
		
		addMouseWheelListener(this);
		
		btn1.addKeyListener(this);
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		System.out.println("Arrastando...");
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		System.out.println("x: " + e.getX() + "  y: " + e.getY());	
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		System.out.println("Scroll rotação: " + e.getWheelRotation());
	}

	@Override
	public void keyTyped(KeyEvent e) {
			
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		int x = btnSel.getX();
		int y = btnSel.getY();
		
		switch (e.getKeyCode()) {
	
		case KeyEvent.VK_UP:
			y -= 5;
			break;
			
		case KeyEvent.VK_DOWN:
			y += 5;
			break;
			
		case KeyEvent.VK_LEFT:
			x -= 5;
			break;
			
		case KeyEvent.VK_RIGHT:
			x += 5;
			break;
		}
		
		if (x < -100)
			x = this.getWidth();
		else if (x > this.getWidth())
			x = -100;
		
		if (y < -30)
			y = this.getHeight();
		else if (y > this.getHeight())
			y = -30;
		
		
		btnSel.setLocation(x, y);
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	


}
