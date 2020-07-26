package com.feiyu.observer.v9;

import java.awt.Button;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
/**
 * Java本身怎么运用观察者模式
 * @author feiyu
 *
 */
public class TestFrame extends Frame {
	public void launch() {
		Button b = new Button("press me");//事件源对象
		b.addActionListener(new MyActionListener());//鼠标点击
		b.addActionListener(new MyActionListener2());
		this.add(b);
		this.pack();
		
		this.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		this.setLocation(400, 400);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new TestFrame().launch();
	}
	
	private class MyActionListener implements ActionListener { //MyActionListener监听类（观察者），ActionListener接口（Observer）

		public void actionPerformed(ActionEvent e) {//ActionEvent事件类
			((Button)e.getSource()).setLabel("press me again!");
			System.out.println("button pressed!");
		}
		
	}
	
	private class MyActionListener2 implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			System.out.println("button pressed 2!");
		}
		
	}
}
