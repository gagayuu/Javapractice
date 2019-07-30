    package sust.buildingsystem;

    import java.sql.*;
    import java.util.ArrayList;
    import java.util.List;

    public class DatabaseLoad {

        public static void main(String[] args) {
    //        People people = query(6);//��ѯһ����¼����ӡ
    //        System.out.print("No��"+people.getNo()+" ");
    //        System.out.print("Number��"+people.getNumber()+" ");
    //        System.out.print("Name��"+people.getName()+" ");
    //        System.out.print("Sex��"+people.getSex()+" ");

          update(1,6);//����

    //        List<People> list = new ArrayList<>();//��ѯ���в���ӡ
    //        list = queryAll();
    //        for (int i = 0; i < list.size(); i++) {
    //            People people = list.get(i);
    //            System.out.print("No��"+people.getNo()+" ");
    //            System.out.print("Number��"+people.getNumber()+" ");
    //            System.out.print("Name��"+people.getName()+" ");
    //            System.out.print("Sex��"+people.getSex()+" ");
    //            System.out.println();
    //        }

//        People people = new People();//���һ����¼
//        people.setNo(1);
//        people.setName("����");
//        people.setNumber(3);
//        people.setSex("��");
//       add(people);


    //    remove(1);//ɾ��һ����¼
        }

        public static void remove(int no) {//�����������ɾ����Ӧ��Ϣ
            Connection c = null;//�������ݿ����Ӷ���
            PreparedStatement s = null;//����sql���ִ�ж���
            ResultSet set = null;//�����
            try {
                String sql = "delete from build_info where no=?;";//sqlִ�����
                Class.forName("com.mysql.jdbc.Driver");//���ض�Ӧ��jdbc����
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";//���������ַ���
                String username = "root";//����Ա
                String password = "gagayu123";//����
                c = DriverManager.getConnection(url, username, password);
                s = c.prepareStatement(sql);
                s.setInt(1, no);
                s.execute();//ִ��sql���
                s.close();//�ر����ݿ�ִ�����`
                c.close();//�ر����ݿ�����
            } catch (ClassNotFoundException e) {
                System.out.println("û���ҵ���Ӧ�����ݿ�������");
            } catch (SQLException e) {
                System.out.println("���ݿ�����ʧ�ܻ����ݿ����ʧ��");
            }
        }



        public static void add(People people) {//���һ����¼

            try {
                String sql = "insert into build_info (no,number, name, sex) values (?,?,?,?)";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useUnicode=true&characterEncoding=utf8&useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c = DriverManager.getConnection(url, username, password);
                PreparedStatement s = c.prepareStatement(sql);
                s.setInt(1,people.getNo());
                s.setInt(2, people.getNumber());
                s.setString(3, people.getName());
                s.setString(4, people.getSex());
                System.out.println(s);
                s.execute();
                s.close();
                c.close();
            } catch (ClassNotFoundException e) {
                System.out.println("û���ҵ���Ӧ�����ݿ�������");
            } catch (SQLException e) {
                System.out.println("���ݿ�����ʧ�ܻ����ݿ����ʧ��");
            }

        }

        public static List<People> queryAll() {//ʹ�ö�̬����(People����)���ز�ѯ������Ϣ�Ľ��
            List<People> list = new ArrayList<>();//ʵ����list����
            try {
                ResultSet rs = null;//���ݿ��б�ʾ����������ݱ�
                String sql = "select no,number,name,sex from build_info";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c = DriverManager.getConnection(url, username, password);
                PreparedStatement s = c.prepareStatement(sql);
                rs = s.executeQuery(sql);
               while(rs.next()){//ѭ�����������
                    People people = new People();//ʵ����people����
                    people.setNo(rs.getInt(1));//set����Ϊget������ֵ
                    people.setNumber(rs.getInt(2));
                    people.setName(rs.getString(3));
                    people.setSex(rs.getString(4));
                    list.add(people);
                }
                rs.close();
                s.close();
                c.close();
            } catch (ClassNotFoundException e) {
                System.out.println("û���ҵ���Ӧ�����ݿ�������");
            } catch (SQLException e) {
                System.out.println("���ݿ�����ʧ�ܻ����ݿ����ʧ��");
            }
            return list;
        }


        public static void update(int no,int newNumber){//�޸�һ�����ݣ�ֻ���޸���ס����
            try {
                String sql = "update build_info set number=? where no=?;";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c = DriverManager.getConnection(url, username, password);
                PreparedStatement s = c.prepareStatement(sql);
                s.setInt(1,newNumber);
                s.setInt(2,no);
                s.execute();
                s.close();
                c.close();
            } catch (ClassNotFoundException e) {
                System.out.println("û���ҵ���Ӧ�����ݿ�������");
            } catch (SQLException e) {
                System.out.println("���ݿ�����ʧ�ܻ����ݿ����ʧ��");
            }
        }



        public static People query(int no){//��ѯһ����¼
            People people = new People();
            try {
                ResultSet rs = null;
                String sql = "select * from build_info where no=?;";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c = DriverManager.getConnection(url, username, password);
                PreparedStatement s = c.prepareStatement(sql);
                s.setInt(1,no);
                System.out.println(s);
                rs = s.executeQuery();
                while (rs.next()){
                    people.setNo(rs.getInt("no"));
                    people.setNumber(rs.getInt("number"));
                    people.setName(rs.getString("name"));
                    people.setSex(rs.getString("sex"));
                }
            }catch (ClassNotFoundException e) {
                System.out.println("û���ҵ���Ӧ�����ݿ�������");
            } catch (SQLException e) {
                System.out.println("���ݿ�����ʧ�ܻ����ݿ����ʧ��");
            }
            return people;
        }



        public  boolean isExist(int no) {//�жϽ���������Ƿ������ݿ��д���
            List<People> list =new ArrayList<>();
            try {
                ResultSet rs = null;
                String sql = "select * from build_info where no="+String.valueOf(no)+";";
                Class.forName("com.mysql.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/build_people?useSSL=false";
                String username = "root";
                String password = "gagayu123";
                Connection c=DriverManager.getConnection(url,username,password);
                PreparedStatement s=c.prepareStatement(sql);
                rs= s.executeQuery(sql);
                while(rs.next()){
                    People people=new People();
                    people.setNo(rs.getInt(1));
                    people.setNumber(rs.getInt(2));
                    people.setName(rs.getString(3));
                    people.setSex(rs.getString(4));
                    list.add(people);
                }
                rs.close();
                s.close();
                c.close();
            } catch (ClassNotFoundException e) {
                System.out.println("û���ҵ���Ӧ�����ݿ�������");
            } catch (SQLException e) {
                System.out.println("���ݿ�����ʧ�ܻ����ݿ����ʧ��");
            }

            if(list.size()==1){//�ҵ�һ����ؼ�¼�򷵻�true
                return true;
            }else {//���������Ϊδ�ҵ���¼�����
                return false;
            }
        }
    }
