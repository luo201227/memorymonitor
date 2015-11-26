package com.joyce.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import com.joyce.ui.MemoryMonitorPanel;

/**
 * 内存监控工具类
 * @author Joyce.Luo
 * @date 2015-11-26 上午10:29:14
 * @version V3.0
 * @since Tomcat6.0,Jdk1.6
 * @copyright Copyright (c) 2015
 */
public class MonitorUtil {
	private static MemoryMonitorPanel panel = null;
	
	public static MemoryMonitorPanel getMemoryMonitorStatus(){
		if (null == panel) {
			panel = new MemoryMonitorPanel();
		}
		return panel;
	}
	
	public static Timer getMonitorTimer(int delay) {
		return new Timer(delay, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getMemoryData(panel.getProgressBar(), panel.getLblstatusinfo());
			}
		});
	}
	
	public static void getMemoryData(JProgressBar bar, JLabel label) {
		MemoryMXBean memorymbean = ManagementFactory.getMemoryMXBean();
		long usedMemory = memorymbean.getHeapMemoryUsage().getUsed();
		long totalMemory = memorymbean.getHeapMemoryUsage().getMax();
		int used = new Long(usedMemory/1024/1024).intValue();
		int total = new Long(totalMemory/1024/1024).intValue();
		bar.setValue(used/total);
		label.setText(used + "M/" + total + "M");
	}
}
