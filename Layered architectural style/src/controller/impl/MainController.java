package controller.impl;

import controller.Controller;
import data.PhoneNumberBean;
import service.PhoneNumberManager;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 下午2:59
 * To change this template use File | Settings | File Templates.
 */
public class MainController implements Controller{
    private PhoneNumberManager phoneNumberManager;

    public MainController(PhoneNumberManager phoneNumberManager) {
        this.phoneNumberManager = phoneNumberManager;
    }

    @Override
    public void addPhoneNumber(String phoneNumber, String firstName, String lastName) {
        phoneNumberManager.addPhoneNumber(phoneNumber,firstName,lastName);
    }

    @Override
    public List<PhoneNumberBean> viewAllPhoneNumber() {
        return phoneNumberManager.viewAllPhoneNumber();
    }

    @Override
    public Boolean deletePhoneNumber(String phoneNumber, String firstName, String lastName) {
        return phoneNumberManager.deletePhoneNumber(phoneNumber,firstName,lastName);
    }

    @Override
    public List<PhoneNumberBean> searchPhoneNumber(String firstName, String lastName) {
        return phoneNumberManager.searchPhoneNumber(firstName,lastName);
    }

    @Override
    public Boolean modifyPhoneNumber(String phoneNumber, String newPhoneNumber, String firstName, String lastName) {
        return phoneNumberManager.modifyPhoneNumber(phoneNumber,newPhoneNumber,firstName,lastName);
    }
}
