package mh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * 自定义的标题栏
 * @Description TODO
 * @author muhong
 * @time 2017年6月7日 下午12:17:32
 */
public class SelfDefineBar extends JPanel {

	// 设置标签按钮1
	private JLabel setting;
	// 最小化标签按钮
	private JLabel miniSize;
	// 退出按钮
	private JLabel exit;
	//
	private JFrame fatherFrame;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;

	public SelfDefineBar(JFrame fatherFrame) {
		this.fatherFrame = fatherFrame;
		this.setSize(440, this.getHeight());
		this.setOpaque(false);

		MyMouseAndMouseMotionListener listener = new MyMouseAndMouseMotionListener();
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);

		setBackground(Color.gray);
		setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setOpaque(false);
//		panel.setBackground(Color.WHITE);
		add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));

		setting = new JLabel("");
		setting.setIcon(new ImageIcon(CommonUtil.getFullPath("\\img\\setting_on.png")));
		panel.add(setting, BorderLayout.CENTER);
		setting.setHorizontalAlignment(SwingConstants.CENTER);

		panel_5 = new JPanel();
		panel_5.setOpaque(false);
		panel.add(panel_5, BorderLayout.WEST);


		JPanel panel_1 = new JPanel();
		panel_1.setOpaque(false);
		add(panel_1, BorderLayout.EAST);
		panel_1.setLayout(new GridLayout(0, 4, 0, 0));

		miniSize = new JLabel("");
		miniSize.setIcon(new ImageIcon(CommonUtil.getFullPath("\\img\\min_size.png")));
		panel_1.add(miniSize);

		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_1.add(panel_4);

		exit = new JLabel("");
		exit.setIcon(new ImageIcon(CommonUtil.getFullPath("\\img\\close.png")));
		panel_1.add(exit);

		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_1.add(panel_2);

		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		add(panel_3, BorderLayout.NORTH);

		initLabelEvent();
	}

	private void initLabelEvent(){
		setting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				System.out.println("设置");
			}
		});
		miniSize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				fatherFrame.setExtendedState(JFrame.ICONIFIED);
			}
		});

		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				super.mouseClicked(e);
				fatherFrame.dispose();
			}
		});
	}

	//内部类
	private class MyMouseAndMouseMotionListener extends MouseAdapter{
		private Point pressed = null;
		@Override
		public void mousePressed(MouseEvent event) {
			super.mousePressed(event);
			if(event.getModifiers() == MouseEvent.BUTTON1_MASK){
				int pressedX = event.getX();
				int pressedY = event.getY();
				pressed = event.getPoint();
			}
		}
		@Override
		public void mouseDragged(MouseEvent event) {
			super.mouseDragged(event);
			if(event.getModifiers() == MouseEvent.BUTTON1_MASK){
				if(pressed != null){
					Point dragged = event.getPoint();
					Point location = fatherFrame.getLocation();
					int x = location.x + dragged.x - pressed.x;
					int y = location.y + dragged.y - pressed.y;
					fatherFrame.setLocation(x, y);
				}
			}
		}
	}
}
