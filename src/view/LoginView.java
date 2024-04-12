package view;

import business.UserManager;
import core.Helper;
import entity.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends Layout{
    private JPanel container;
    private JPanel w_tap;
    private JLabel lbl_welcome;
    private JLabel lbl_welcome2;
    private JTextField fld_username;
    private JPasswordField fld_password;
    private JButton btn_login;
    private JLabel lbl_username;
    private JLabel lbl_password;
    private JPanel w_button;

    private  final UserManager userManager;


    public  LoginView(){
        this.userManager= new UserManager();

        add(container);
        this.guiInitilaze(400,400);
        btn_login.addActionListener(e -> {
            JTextField[] checkFieldList = { this.fld_username, this.fld_password};
            if (Helper.isFieldListEmpty(checkFieldList)){
                Helper.showMsg("fill");
            }else{
                User loginUser = this.userManager.findByLogin(this.fld_username.getText(),this.fld_password.getText());
                if(loginUser== null){
                    Helper.showMsg("notFound");
                }else {
                    new AdminView(loginUser);
                    dispose();
                }
            }

        });
    }


}
