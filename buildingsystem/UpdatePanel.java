package sust.buildingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UpdatePanel extends JPanel implements ActionListener {
    JLabel noLabel;//ס����
    JLabel numLabel;//��ס����
    JTextField noText;
    JTextField numText;
    JButton button;

    public UpdatePanel(){
        this.setSize(500,700);
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        this.init();

        this.setVisible(true);
    }

    //��ʼ�����
    private void init(){
        noLabel=new JLabel("������ס����");
        noLabel.setSize(90,30);
        noLabel.setLocation(30,20);
        numLabel=new JLabel("����������");
        numLabel.setSize(90,30);
        numLabel.setLocation(30,70);
        noText=new JTextField();
        noText.setSize(180,30);
        noText.setLocation(120,20);
        numText=new JTextField();
        numText.setSize(180,30);
        numText.setLocation(120,70);
        button=new JButton("�޸�");
        button.setSize(80,30);
        button.setLocation(120,220);


        this.add(noLabel);
        this.add(numLabel);
        this.add(noText);
        this.add(numText);
        this.add(button);

        button.addActionListener(new ActionListener() {//���°�ť�¼�
            @Override
            public void actionPerformed(ActionEvent e) {
                DatabaseLoad data=new DatabaseLoad();
                int no=Integer.parseInt(noText.getText());
                if(data.isExist(no)){
                    int number=Integer.parseInt(numText.getText());//
                    data.update(no,number);
                    JOptionPane.showMessageDialog(null,"�޸ĳɹ�");
                }else{
                    JOptionPane.showMessageDialog(null,"����ס���Ų��Ϸ�");
                }
            }
        });




    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
