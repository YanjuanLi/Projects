package userinterface.ElderRole;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

class DataReceiver extends JPanel {
    private List<Integer> values;                      // 保存接收到的数据的容器.
    private static final int MAX_VALUE = 200;          // 接收到的数据的最大值.
    private static final int MAX_COUNT_OF_VALUES = 50; // 最多保存数据的个数.
    private static float count=0;
    private static float heartRate=0;
    private static boolean controller=true;

    public DataReceiver(float heartrate) {
        values = Collections.synchronizedList(new ArrayList<Integer>());
        //this.heartRate=heartrate;
        this.heartRate=heartrate;
        this.controller=controller;
        // 使用一个线程模拟产生数据.
        Thread t=new Thread(new Runnable() {
            @Override
            public void run() {
                float heartRate2=60;
                Random rand = new Random();
                float f=(float) 0.1666666666666666;

                try {
                    while (true) {
                    	if(count>=1000){
                    		addValue(50);
                    		addValue(150);
                    		count=0;
                    	}else{
                    		addValue(100);
                    	}
                        count=count+(f*heartRate2);
                        System.out.println(f);
                        
                        repaint();
                        Thread.sleep(10);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        int h = getHeight();
        int xDelta = w / MAX_COUNT_OF_VALUES;
        int length = values.size();

        for (int i = 0; i < length - 1; ++i) {
            g2d.drawLine(xDelta * (MAX_COUNT_OF_VALUES - length + i), normalizeValueForYAxis(values.get(i), h),
                    xDelta * (MAX_COUNT_OF_VALUES - length + i + 1), normalizeValueForYAxis(values.get(i + 1), h));
        }
    }

    /**
     * 接收到的数据放入内存.
     * @param value
     */
    private void addValue(int value) {
        // 循环的使用一个接收数据的空间.
        // 最好是实现一个循环数组，而不是偷懒的使用ArrayList.
        if (values.size() > MAX_COUNT_OF_VALUES) {
            values.remove(0);
        }

        values.add(value);
    }

    /**
     * 规一化y轴方向的值. 使得value在y轴的值为[0, height]之间.
     *
     * @param value
     * @param height
     * @return
     */
    private int normalizeValueForYAxis(int value, int height) {
        return (int) ((double) height / MAX_VALUE * value);
    }

    private static void createGuiAndShow() {
        JFrame  frame = new JFrame("ECG");
        frame.getContentPane().add(new DataReceiver(heartRate));

        // Set frame's close operation and location in the screen.
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocation(220,40);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        
        
    }

    public static void main(String[] args) {
        createGuiAndShow();
    }
}
