package sust.buildingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeletePanel extends JPanel implements ActionListener {
    JLabel noLabel;//ס����
    JTextField noText;
    JScrollPane scroll;//�������
    // JTable table;
    JButton button;

    public DeletePanel(){
        this.setSize(500,700);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.init();
        //this.refreshTabel();
        this.setVisible(true);


    }

    //��ʼ�����
    private void init(){
        noLabel=new JLabel("������ס����");
        noLabel.setSize(90,30);
        noLabel.setLocation(30,20);
        noText=new JTextField();
        noText.setSize(180,30);
        noText.setLocation(120,20);
        button=new JButton("ɾ��");
        button.setSize(80,30);
        button.setLocation(120,220);


        this.add(noLabel);
        this.add(noText);
        this.add(button);

     //ɾ����ť�¼�
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              int no= Integer.parseInt(noText.getText());
              DatabaseLoad data=new DatabaseLoad();
              if(data.isExist(no)){
                  data.remove(no);
                  JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
              }else{
                  JOptionPane.showMessageDialog(null,"���ݿ�����쳣");
              }

            }
        });





    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
