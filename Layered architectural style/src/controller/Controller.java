package controller;

import data.PhoneNumberBean;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 上午11:48
 * To change this template use File | Settings | File Templates.
 */
public interface Controller {
    public void addPhoneNumber(String phoneNumber,String firstName,String lastName);
    public List<PhoneNumberBean> viewAllPhoneNumber();
    public Boolean deletePhoneNumber(String phoneNumber,String firstName,String lastName);
    public List<PhoneNumberBean> searchPhoneNumber(String firstName,String lastName);
    public Boolean modifyPhoneNumber(String phoneNumber,String newPhoneNumber,String firstName,String lastName);
}
