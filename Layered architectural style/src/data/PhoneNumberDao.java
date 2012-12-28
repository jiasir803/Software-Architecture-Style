package data;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午10:28
 * To change this template use File | Settings | File Templates.
 */
public class PhoneNumberDao {
    public void insert(PhoneNumberBean phoneNumberBean){
        Connection connection=Factory.getConnection();
        try {
            PreparedStatement stmt=connection.prepareStatement("insert into phoneNumber(phone_number,first_name,last_name) values(?,?,?)");
            stmt.setString(1,phoneNumberBean.getPhoneNumber());
            stmt.setString(2,phoneNumberBean.getFirstName());
            stmt.setString(3,phoneNumberBean.getLastName());
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Factory.closeConnection(connection);
    }

    public void delete(PhoneNumberBean phoneNumberBean){
        Connection connection=Factory.getConnection();
        try {
            PreparedStatement stmt=connection.prepareStatement("delete from phoneNumber where id=?");
            stmt.setInt(1,phoneNumberBean.getId());
            stmt.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        Factory.closeConnection(connection);
    }

    public void update(PhoneNumberBean phoneNumberBean){
        Connection connection=Factory.getConnection();
        try {
            PreparedStatement stmt=connection.prepareStatement("update phoneNumber set phone_number=? where id=?");
            stmt.setString(1,phoneNumberBean.getPhoneNumber());
            stmt.setInt(2,phoneNumberBean.getId());
            stmt.executeQuery();
        } catch (SQLException e) {//To change body of catch statement use File | Settings | File Templates.
        }
        Factory.closeConnection(connection);
    }

    public List<PhoneNumberBean> getAll(){
        Connection connection=Factory.getConnection();
        List<PhoneNumberBean> list=new ArrayList<PhoneNumberBean>();
        try {
            PreparedStatement stmt=connection.prepareStatement("select * from phoneNumber");
            ResultSet resultSet=stmt.executeQuery();
            while (resultSet.next()){
                PhoneNumberBean phoneNumberBean=new PhoneNumberBean();
                phoneNumberBean.setId(resultSet.getInt(1));
                phoneNumberBean.setPhoneNumber(resultSet.getString(2));
                phoneNumberBean.setFirstName(resultSet.getString(3));
                phoneNumberBean.setLastName(resultSet.getString(4));
                list.add(phoneNumberBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Factory.closeConnection(connection);
        return list;
    }

    public PhoneNumberBean searchByName_phone(String phoneNumber, String firstName,String lastName){
        Connection connection=Factory.getConnection();
        List<PhoneNumberBean> list=new ArrayList<PhoneNumberBean>();
        try {
            PreparedStatement stmt=connection.prepareStatement("select * from phoneNumber where phone_number=? and first_name=? and last_name=?");
            stmt.setString(1,phoneNumber);
            stmt.setString(2,firstName);
            stmt.setString(3,lastName);
            ResultSet resultSet=stmt.executeQuery();
            while (resultSet.next()){
                PhoneNumberBean phoneNumberBean=new PhoneNumberBean();
                phoneNumberBean.setId(resultSet.getInt(1));
                phoneNumberBean.setPhoneNumber(resultSet.getString(2));
                phoneNumberBean.setFirstName(resultSet.getString(3));
                phoneNumberBean.setLastName(resultSet.getString(4));
                list.add(phoneNumberBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Factory.closeConnection(connection);
        if(list.size()==0)
            return null;
        else
            return list.get(0);
    }

    public  List<PhoneNumberBean> searchByName(String firstName,String lastName){
        Connection connection=Factory.getConnection();
        List<PhoneNumberBean> list=new ArrayList<PhoneNumberBean>();
        try {
            PreparedStatement stmt=connection.prepareStatement("select * from phoneNumber where first_name=? and last_name=?");
            stmt.setString(1,firstName);
            stmt.setString(2,lastName);
            ResultSet resultSet=stmt.executeQuery();
            while (resultSet.next()){
                PhoneNumberBean phoneNumberBean=new PhoneNumberBean();
                phoneNumberBean.setId(resultSet.getInt(1));
                phoneNumberBean.setPhoneNumber(resultSet.getString(2));
                phoneNumberBean.setFirstName(resultSet.getString(3));
                phoneNumberBean.setLastName(resultSet.getString(4));
                list.add(phoneNumberBean);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        Factory.closeConnection(connection);
        return list;
    }
}
