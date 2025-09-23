package model.dao;

import model.vo.LoginPaciente;
import model.vo.Paciente;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginPacienteDAO {

    public void inserirLoginPaciente(LoginPaciente loginPaciente){

        // Obter o objeto Paciente a partir do LoginPaciente
        Paciente paciente = loginPaciente.getPaciente();

        // Acessar o ID do paciente diretamente do objeto
        int id_paciente = paciente.getId();

        String sql = "INSERT INTO TB_LOGIN_PACIENTE (id_paciente, senha, login) VALUES (?, ?, ?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_paciente);
            ps.setString(2, loginPaciente.getSenha());
            ps.setString(3, loginPaciente.getLogin());

            ps.executeUpdate();
            System.out.println("Login do Paciente adicionado com sucesso!");

            ps.close();
            conn.close();

        } catch (Exception e) {
            System.err.println("Erro ao inserir LoginPaciente: " + e.getMessage());
        }
    }

    public Paciente autenticarPaciente(){

        String sql = "SELECT * FROM TB_LOGIN_PACIENTE WHERE senha = ? AND login = ?";

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
                int idPaciente = rs.getInt("id_paciente");

                Paciente pacienteAutenticado = new Paciente();
                pacienteAutenticado.setId(idPaciente);

                rs.close();
                ps.close();
                conn.close();
                return pacienteAutenticado;
            } else {
                System.out.println("Login ou senha inválidos!");
                return null;
            }



        } catch (Exception e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());
            return null;
        }
    }

}
