package com.joyce.ui;

import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 图片按钮
 * @author Joyce.Luo
 * @date 2015-11-27 上午09:31:41
 * @version V3.0
 * @since Tomcat6.0,Jdk1.6
 * @copyright Copyright (c) 2015
 */
public class ImageButton extends JButton {

	private static final long serialVersionUID = 4548878211203880649L;
	
	public ImageButton(ImageIcon icon){
		this.setSize(icon.getImage().getWidth(null),
				icon.getImage().getHeight(null));
		this.setIcon(icon);
		this.setMargin(new Insets(0,0,0,0));//将边框外的上下左右空间设置为0 
		this.setIconTextGap(0);//将标签中显示的文本和图标之间的间隔量设置为0  
        this.setBorderPainted(false);//不打印边框  
        this.setBorder(null);//除去边框  
        this.setText(null);//除去按钮的默认名称  
        this.setFocusPainted(false);//除去焦点的框  
        this.setContentAreaFilled(false);//除去默认的背景填充
	}
}
