package sust.buildingsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame implements ActionListener {
    JMenuBar bar;//�˵���
    JMenu menu;//�˵�
    JMenuItem[] items;//�˵�������
    JPanel panel;


    public Menu() {
        this.setSize(500, 800);
        this.setLayout(null);
        this.initMenu();

        this.setVisible(true);
    }

    public void initMenu() {//��ʼ���˵�
        bar = new JMenuBar();
        //�����˵�
        menu = new JMenu("��ѡ��");
        //�����˵���
        String[] itemNames = {"����ס����Ϣ", "����ס����Ϣ", "ɾ��ס����Ϣ", "�޸�ס����Ϣ"};
        items = new JMenuItem[itemNames.length];
        for (int i = 0; i < items.length; i++) {
            items[i] = new JMenuItem(itemNames[i]);

            items[i].addActionListener(this);
            menu.add(items[i]);
        }
        bar.add(menu);
        this.setJMenuBar(bar);//���ô����еĲ˵���

    }


    @Override
    public void actionPerformed(ActionEvent e) {//ѡ��˵��ͬ�¼����ֲ�ͬ���
        JMenuItem item = (JMenuItem) e.getSource();
        if (panel != null) {
            this.remove(panel);
        }
        if (item.getText().equals("����ס����Ϣ")) {
            panel = new SearchPanel();//��������ס����Ϣ������
            panel.setLocation(0, 20);
            this.add(panel);
            this.repaint();
        } else {
            if (item.getText().equals("����ס����Ϣ")) {
                panel = new AddPanel();
                panel.setLocation(0, 20);
                this.add(panel);
                this.repaint();
            } else {
                if (item.getText().equals("ɾ��ס����Ϣ")) {
                    panel = new DeletePanel();
                    panel.setLocation(0, 20);
                    this.add(panel);
                    this.repaint();
                } else {
                    if (item.getText().equals("�޸�ס����Ϣ")) {
                        panel = new UpdatePanel();
                        panel.setLocation(0, 20);
                        this.add(panel);
                        this.repaint();
                    }
                }
            }


        }


    }
}
