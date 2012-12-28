package service;

import data.Factory;
import data.PhoneNumberBean;
import data.PhoneNumberDao;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午11:29
 * To change this template use File | Settings | File Templates.
 */
public class PhoneNumberManager {
    PhoneNumberDao dao= Factory.getPhoneNumberDao();

    public void addPhoneNumber(String phoneNumber,String firstName,String lastName){
        PhoneNumberBean bean=new PhoneNumberBean();
        bean.setPhoneNumber(phoneNumber);
        bean.setFirstName(firstName);
        bean.setLastName(lastName);
        dao.insert(bean);
    }

    public List<PhoneNumberBean> viewAllPhoneNumber(){
        List<PhoneNumberBean> list=dao.getAll();
        return list;
    }

    public Boolean deletePhoneNumber(String phoneNumber,String firstName,String lastName){
        PhoneNumberBean bean=dao.searchByName_phone(phoneNumber,firstName,lastName);
        if(bean==null)
            return false;
        dao.delete(bean);
        return true;
    }

    public List<PhoneNumberBean> searchPhoneNumber(String firstName,String lastName){
        List<PhoneNumberBean> list=dao.searchByName(firstName,lastName);
        return list;
    }

    public Boolean modifyPhoneNumber(String phoneNumber,String newPhoneNumber,String firstName,String lastName){
        PhoneNumberBean bean=dao.searchByName_phone(phoneNumber,firstName,lastName);
        if(bean==null)
            return false;

        bean.setPhoneNumber(newPhoneNumber);
        dao.update(bean);
        return true;
    }
}
