package com.joyce.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import com.joyce.util.MonitorUtil;

/**
 * 测试入口
 * @author Joyce.Luo
 * @date 2015-11-26 上午10:56:16
 * @version V3.0
 * @since Tomcat6.0,Jdk1.6
 * @copyright Copyright (c) 2015
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = -6426769124864168381L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		MemoryMonitorPanel monitorPanel = MonitorUtil.getMemoryMonitorStatus();
		contentPane.add(monitorPanel);
		Timer monitorTimer = MonitorUtil.getMonitorTimer(3000);
		monitorTimer.start();
	}

}
