package com.joyce.ui;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import com.joyce.util.MonitorUtil;

/**
 * 内存监控面板
 * @author Joyce.Luo
 * @date 2015-11-26 上午10:34:21
 * @version V3.0
 * @since Tomcat6.0,Jdk1.6
 * @copyright Copyright (c) 2015
 */
public class MemoryMonitorPanel extends JPanel {

	private static final long serialVersionUID = -3960913613847272592L;
	private JProgressBar progressBar;
	private JLabel lblstatusinfo;

	public JProgressBar getProgressBar() {
		return progressBar;
	}

	public JLabel getLblstatusinfo() {
		return lblstatusinfo;
	}

	public MemoryMonitorPanel() {
		this.setLayout(null);
		
		lblstatusinfo = new JLabel("0M/0M");
		lblstatusinfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblstatusinfo.setBounds(5, 5, 146, 20);
		lblstatusinfo.setForeground(Color.BLUE);
		this.add(lblstatusinfo);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(5, 5, 146, 20);
		this.add(progressBar);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(159, 5, 2, 20);
		this.add(separator);
		
		Icon icon = new ImageIcon(getClass().getResource("/trash.png"));
		JRadioButton btnTrash = new JRadioButton(icon);
		btnTrash.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnTrash.setBounds(162, 5, 23, 20);
		btnTrash.setContentAreaFilled(false);
		btnTrash.setRolloverIcon(icon);
		btnTrash.setSelectedIcon(icon);
		this.add(btnTrash);
		btnTrash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.gc();
				MonitorUtil.getMemoryData(progressBar, lblstatusinfo);
			}
		});
		
		MonitorUtil.getMemoryData(progressBar, lblstatusinfo);
	}
}
