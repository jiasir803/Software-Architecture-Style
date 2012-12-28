package presentation;

import controller.Controller;
import controller.impl.MainController;
import data.PhoneNumberBean;
import service.PhoneNumberManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nekosama
 * Date: 12-12-28
 * Time: 下午3:03
 * To change this template use File | Settings | File Templates.
 */
public class MainFrame {
    private JPanel panel1;
    private JList list1;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JButton addPhoneNumberButton;
    private JButton modifyPhoneNumberButton;
    private JButton searchPhoneNumberButton;
    private JButton viewPhoneNumberButton;
    private JButton deletePhoneNumberButton;
    private JButton exitButton;


    private Controller controller;

    public void go(){
        JFrame frame = new JFrame("MainFrame");
        frame.setContentPane(new MainFrame().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainFrame() {
        DefaultListModel listModel=new DefaultListModel();
        list1.setModel(listModel);
        controller=new MainController(new PhoneNumberManager());


        searchPhoneNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName=textField1.getText();
                String lastName=textField2.getText();
                List<PhoneNumberBean> list=controller.searchPhoneNumber(firstName,lastName);
                int size=list.size();
                JOptionPane.showMessageDialog(panel1,size+"results are found");

                DefaultListModel tmpModel= (DefaultListModel) list1.getModel();
                tmpModel.removeAllElements();
                for(PhoneNumberBean bean:list){
                    String line=bean.getFirstName()+" "+bean.getLastName()+"   "+bean.getPhoneNumber();
                    tmpModel.add(tmpModel.getSize(),line);
                }
                list1.setModel(tmpModel);
            }
        });
        viewPhoneNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<PhoneNumberBean> list=controller.viewAllPhoneNumber();
                int size=list.size();
                JOptionPane.showMessageDialog(panel1,size+"results are found");

                DefaultListModel tmpModel= (DefaultListModel) list1.getModel();
                tmpModel.removeAllElements();
                for(PhoneNumberBean bean:list){
                    String line=bean.getFirstName()+" "+bean.getLastName()+"   "+bean.getPhoneNumber();
                    tmpModel.add(tmpModel.getSize(),line);
                }
                list1.setModel(tmpModel);
            }
        });
        addPhoneNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName=textField1.getText();
                String lastNmae=textField2.getText();
                String phoneNumber=textField3.getText();

                controller.addPhoneNumber(phoneNumber,firstName,lastNmae);
                JOptionPane.showMessageDialog(panel1,"operation succeed");
            }
        });

        modifyPhoneNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=list1.getSelectedIndex();
                if(index==-1){
                    JOptionPane.showMessageDialog(panel1,"please select an item in the list left first");
                    return;
                }
                DefaultListModel model= (DefaultListModel) list1.getModel();
                String line= (String) model.get(index);
                String[] items=line.split(" ");
                String firstName=items[0];
                String lastName=items[1];
                String phoneNumber=items[4];
                String newPhoneNumber=textField3.getText();

                boolean isSucceed=controller.modifyPhoneNumber(phoneNumber,newPhoneNumber,firstName,lastName);
                if(isSucceed){
                    JOptionPane.showMessageDialog(panel1,"operation succeed");
                }else{
                    JOptionPane.showMessageDialog(panel1,"operation failed");
                }
            }
        });
        deletePhoneNumberButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index=list1.getSelectedIndex();
                if(index==-1){
                    JOptionPane.showMessageDialog(panel1,"please select an item in the list left first");
                    return;
                }
                DefaultListModel model= (DefaultListModel) list1.getModel();
                String line= (String) model.get(index);
                String[] items=line.split(" ");
                String firstName=items[0];
                String lastName=items[1];
                String phoneNumber=items[4];

                boolean isSucceed=controller.deletePhoneNumber(phoneNumber,firstName,lastName);
                if(isSucceed){
                    JOptionPane.showMessageDialog(panel1,"operation succeed");
                }else{
                    JOptionPane.showMessageDialog(panel1,"operation failed");
                }
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option=JOptionPane.showConfirmDialog(panel1,"confirm to exit?","",JOptionPane.YES_NO_OPTION);
                if(option==JOptionPane.YES_OPTION){
                    System.exit(0);
                }else
                    return;
            }
        });
    }
}
