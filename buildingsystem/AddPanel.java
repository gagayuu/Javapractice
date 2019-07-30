package sust.buildingsystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPanel extends JPanel implements ActionListener {
    JLabel noLabel;//ס����
    JLabel numLabel;//��ס����
    JLabel nameLabel;//��������
    JLabel sexLabel;//ס���Ա�
    JComboBox sexCom;//�����Ա�������
    JTextField noText;
    JTextField numText;
    JTextField nameText;
    JButton button;

    public AddPanel(){
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
        nameLabel=new JLabel("�����뻧����");
        nameLabel.setSize(90,30);
        nameLabel.setLocation(30,120);
        sexLabel =new JLabel("��ѡ���Ա�");
        sexLabel.setSize(90,30);
        sexLabel.setLocation(30,170);
        noText=new JTextField();
        noText.setSize(180,30);
        noText.setLocation(120,20);
        numText=new JTextField();
        numText.setSize(180,30);
        numText.setLocation(120,70);
        nameText=new JTextField();
        nameText.setSize(180,30);
        nameText.setLocation(120,120);
        sexCom=new JComboBox();
        sexCom.setSize(180,30);
        sexCom.setLocation(120,170);
        sexCom.addItem("��");
        sexCom.addItem("Ů");
        button=new JButton("���");
        button.setSize(80,30);
        button.setLocation(120,220);


        this.add(noLabel);
        this.add(numLabel);
        this.add(nameLabel);
        this.add(sexLabel);
        this.add(sexCom);
        this.add(noText);
        this.add(numText);
        this.add(nameText);
        this.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int no=Integer.parseInt(noText.getText());
                int number=Integer.parseInt(numText.getText());
                String name=nameText.getText();
                String sex=sexCom.getSelectedItem().toString();
                DatabaseLoad data=new DatabaseLoad();
                if(!data.isExist(no)){
                    People people=new People();
                    people.setNo(no);
                    people.setNumber(number);
                    people.setName(name);
                    people.setSex(sex);
                    data.add(people);
                    JOptionPane.showMessageDialog(null,"��ӳɹ�");
                }else{
                    JOptionPane.showMessageDialog(null,"�����ס�����Ѵ���");
                }

            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
