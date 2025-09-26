package model.dao;

import model.vo.LoginPaciente;
import model.vo.Paciente;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {

    public void inserirPaciente(Paciente paciente){
        String sql = "INSERT INTO TB_PACIENTE (cpf_paciente, nome_paciente, rg_paciente," +
                " data_nascimento_paciente, endereco_paciente) VALUES (?,?,?,?,?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, paciente.getCpf());
            ps.setString(2, paciente.getNome());
            ps.setString(3, paciente.getRg());
            ps.setString(4, paciente.getDataNascimento());
            ps.setString(5, paciente.getEndereco());

            ps.execute();
            System.out.println("Paciente inserido com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Paciente: " + e.getMessage());
        }
    }

    public List<Paciente> listarPacientes(){
        //criar a lista de tickets
        List<Paciente> pacientes = new ArrayList<Paciente>();

        //configurar a query
        String sql = "SELECT * FROM TB_PACIENTE";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id_paciente = rs.getInt(1);
                String cpf_paciente = rs.getString(2);
                String nome_paciente = rs.getString(3);
                String rg_paciente = rs.getString(4);
                String data_nascimento_paciente = rs.getString(5);
                String endereco_paciente = rs.getString(6);

                pacientes.add(new Paciente(id_paciente, cpf_paciente, nome_paciente, rg_paciente, data_nascimento_paciente, endereco_paciente));
            }

            ps.close();
            rs.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pacientes;
    }

    public void excluirPaciente(int id){
        String sql = "DELETE FROM TB_PACIENTE WHERE ID_PACIENTE = ?";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Paciente excluído com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir o Paciente!");
            e.printStackTrace();
        }
    }

}
