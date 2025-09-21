package model.dao;

import model.vo.Atendente;
import model.vo.LoginAtendente;
import model.vo.LoginPaciente;
import model.vo.Paciente;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginAtendenteDAO {

    public void inserirLoginAtendente(LoginAtendente loginAtendente){

        // Obter o objeto Atendente a partir do LoginAtendente
        Atendente atendente = loginAtendente.getAtendente();

        // Acessar o ID do atendente diretamente do objeto
        int id_atendente = atendente.getId();

        String sql = "INSERT INTO TB_LOGIN_ATENDENTE (id_atendente, senha, login) VALUES (?, ?, ?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_atendente);
            ps.setString(2, loginAtendente.getSenha());
            ps.setString(3, loginAtendente.getLogin());

            ps.executeUpdate();
            System.out.println("Login do Atendente adicionado com sucesso!");

            ps.close();
            conn.close();

        } catch (Exception e) {
            System.err.println("Erro ao inserir o Login do Atendente: " + e.getMessage());
        }
    }

    public void autenticarAtendente(){

        String sql = "SELECT * FROM TB_LOGIN_ATENDENTE WHERE senha = ? AND login = ?";

        Scanner sc = new Scanner(System.in);

        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, senha);
            ps.setString(2, login);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login realizado com sucesso!");
//                int idAtendente = rs.getInt("id_atendente");
//                System.out.println("ID do Atendente autenticado: " + idAtendente);
            } else {
                System.out.println("Login ou senha inválidos!");
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (Exception e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());

        }
    }

}
