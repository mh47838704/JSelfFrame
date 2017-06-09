package mh;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
/**
 * 背景图片面板（在调用函数中配合，{@JLayeredPane}）
 * @Description TODO
 * @author muhong
 * @time 2017年6月8日 下午5:01:24
 */
public class BackGroundPanel extends JPanel {
	ImageIcon imageIcon;
	public BackGroundPanel(ImageIcon imageIcon)
	{
		this.imageIcon=imageIcon;
		this.setOpaque(true);
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponents(g);
		g.drawImage(imageIcon.getImage(),0,0,this.getWidth(),this.getHeight(),this);
	}
}
