package sust.buildingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginForm extends JFrame  implements ActionListener {
  private JLabel littleLabel;
   private  JLabel userLabel;
   private  JLabel passwordLabel;// ��ǩ����
   private JTextField userText;
   private JPasswordField passWordText;//�ı������
   private JButton lgButton;
   private JButton exButton;//��ť����

    public LoginForm() {
        this.setSize(500, 400);//��С
        this.setTitle("��¼����");//����
        this.setLayout(null);//������Ĭ�ϲ��ַ�ʽ����Ϊ�޲���

        littleLabel = new JLabel("¥�����ϵͳ");
        littleLabel.setSize(200, 40);
        littleLabel.setLocation(150, 10);
        Font font1 = new Font("����", Font.BOLD, 24);
        littleLabel.setFont(font1);


        userLabel = new JLabel("�û���");//��ǩ1���û���
        userLabel.setSize(100, 40);
        userLabel.setLocation(80, 50);
        Font font = new Font("����", Font.BOLD, 20);//��������
        userLabel.setFont(font);


        passwordLabel = new JLabel("�� ��");//��ǩ2������
        passwordLabel.setSize(100, 40);
        passwordLabel.setLocation(80, 100);
        passwordLabel.setFont(font);

        userText = new JTextField();//�����û������ı���
        userText.setSize(180, 30);
        userText.setLocation(160, 50);

        passWordText= new JPasswordField();//����������ı���
        passWordText.setSize(180, 30);
        passWordText.setLocation(160, 100);

        JButton lgButton = new JButton("��¼");
        lgButton.setSize(80, 30);
        lgButton.setLocation(100, 180);

        JButton exButton = new JButton("�˳�");
        exButton.setSize(80, 30);
        exButton.setLocation(190, 180);

        this.add(littleLabel);
        this.add(userLabel);
        this.add( passwordLabel);
        this.add(userText);
        this.add(passWordText);
        this.add(lgButton);
        this.add(exButton);

        this.setVisible(true);

        //��¼��ť�¼�
        lgButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {//������ȷ�����˵�����
                if (userText.getText().trim().equals("gaga") && passWordText.getText().trim().equals("123456")) {
                    Menu menu = new Menu();
                    dispose();
                }else{//���򵯳�������ʾ
                    JOptionPane.showMessageDialog(null,"�������󣡣���");
                    dispose();
                }


            }
        });

        //�˳���ť�¼�
        exButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
