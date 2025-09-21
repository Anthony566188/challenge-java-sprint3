package view;

import controller.LoginManagerController;

public class LoginManagerView {

    private LoginManagerController controller;

    public LoginManagerView(){
        controller = new LoginManagerController();
    }

    public void autenticarUsuario() {
        controller.autenticar();
    }
}
