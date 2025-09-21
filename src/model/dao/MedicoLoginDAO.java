package model.dao;

import model.vo.Atendente;
import model.vo.LoginAtendente;
import model.vo.Medico;
import model.vo.MedicoLogin;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class MedicoLoginDAO {

    public void inserirMedicoLogin(MedicoLogin medicoLogin){

        // Obter o objeto Médico a partir do MedicoLogin
        Medico medico = medicoLogin.getMedico();

        // Acessar o ID do Médico diretamente do objeto
        int id_medico = medico.getId();

        String sql = "INSERT INTO TB_MEDICO_LOGIN (id_medico, login, senha) VALUES (?, ?, ?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_medico);
            ps.setString(2, medicoLogin.getLogin());
            ps.setString(3, medicoLogin.getSenha());

            ps.executeUpdate();
            System.out.println("Login do Médico adicionado com sucesso!");

            ps.close();
            conn.close();

        } catch (Exception e) {
            System.err.println("Erro ao inserir o Login do Médico: " + e.getMessage());
        }
    }

    public void excluirMedicoLogin(int id){
        String sql = "DELETE FROM TB_MEDICO_LOGIN WHERE ID_MEDICO = ?";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Login do Médico excluído com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao excluir o Login do Médico!");
            e.printStackTrace();
        }
    }

    public void autenticarMedico(){

        String sql = "SELECT * FROM TB_MEDICO_LOGIN WHERE login = ? AND senha = ?";

        Scanner sc = new Scanner(System.in);

        System.out.print("Login: ");
        String login = sc.nextLine();
        System.out.print("Senha: ");
        String senha = sc.nextLine();

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, login);
            ps.setString(2, senha);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login realizado com sucesso!");
//                int idMedico = rs.getInt("id_medico");
//                System.out.println("ID do Médico autenticado: " + idMedico);
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
