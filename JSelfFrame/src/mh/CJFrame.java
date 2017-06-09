package mh;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 * 自定义格式的窗口
 *
 * @Description:TODO
 * @author: muhong
 * @time: 2017年6月7日 上午11:59:56
 */
public class CJFrame extends JFrame {

	private int screenWidth;
	private int screenHeight;

	// frame窗口的主面板
	private JPanel mainPanel = new JPanel();
	// 背景图片
	ImageIcon backGroundImg;
	// frame窗口的内容面板
	private JPanel contentPanel;
	// frame窗口的标题栏面板
	private JPanel titleBarPanel;

	public CJFrame() {
		// TODO Auto-generated constructor stub
		// 获取PC屏幕尺寸
		this.setBackground(Color.BLACK);
		// 清除自带的标题栏
		this.setUndecorated(true);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		screenWidth = screenSize.width;
		screenHeight = screenSize.height;

		// 初始化frame的位置
		this.initLocation(screenWidth, screenHeight);
		this.initBackgroundPanel();
	}

	public void initBackgroundPanel() {
		backGroundImg = new ImageIcon(CommonUtil.getFullPath("\\img\\timg.png"));// 随便找一张图就可以看到效果。
		int imgWidth = backGroundImg.getIconWidth();
		int imgHeight = backGroundImg.getIconHeight();

		JPanel backImg = new BackGroundPanel(backGroundImg);
		backImg.setBounds(0, 0, imgWidth, imgHeight);

		mainPanel.setLayout(new BorderLayout());
		mainPanel.setOpaque(false);
		mainPanel.setBounds(0, 0, imgWidth, imgHeight);

		this.getContentPane().add(mainPanel);
		this.getContentPane().add(backImg);
	}

	/**
	 * 设置标题栏面板
	 *
	 * @param titleBarPanel
	 */
	public void setTitleBar(JPanel titleBarPanel) {
		this.titleBarPanel = titleBarPanel;
		this.mainPanel.add(titleBarPanel, BorderLayout.NORTH);
	}

	/**
	 * 设置内容面板
	 *
	 * @param contentPanel
	 */
	public void setMyContentPanel(JPanel contentPanel) {
		this.contentPanel = contentPanel;
		this.mainPanel.add(contentPanel, BorderLayout.CENTER);
	}

	/**
	 * 根据屏幕的size和面板的size初始化面板位置为屏幕中央位置
	 *
	 * @param screenWidth
	 * @param screenHeight
	 */
	private void initLocation(int screenWidth, int screenHeight) {
		int locationX = (screenWidth / 2) - (this.getWidth() / 2);
		int locationY = (screenHeight / 2) - (this.getHeight() / 2);
		this.setLocation(locationX, locationY);
	}

	@Override
	public void setSize(int width, int height) {
		// TODO Auto-generated method stub
		super.setSize(width, height);
		// 改变大小的时候重新初始化位置
		this.initLocation(this.screenWidth, this.screenHeight);
	}

}
