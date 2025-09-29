package model.dao;

import model.vo.Especialidade;
import model.vo.Medico;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MedicoDAO {

    public void inserirMedico(Medico medico){

        // Obter o objeto Especialidade a partir do Medico
        Especialidade especialidade = medico.getEspecialidade();

        // Acessar o ID da Especialidade diretamente do objeto
        int id_especialidade = especialidade.getId();

        String sql = "INSERT INTO TB_MEDICO (id_especialidade, nome_medico) VALUES (?,?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id_especialidade);
            ps.setString(2, medico.getNome());
            ps.execute();
            System.out.println("Médico inserido com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Médico: " + e.getMessage());
        }
    }

    public List<Medico> listarMedicos(){
        List<Medico> medicos = new ArrayList<Medico>();

        String sql = "SELECT * FROM TB_MEDICO";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                int id_medico = rs.getInt(1);
                int id_especialidade = rs.getInt(2);
                String nome_medico = rs.getString(3);

                Especialidade especialidade = new Especialidade(id_especialidade);

                medicos.add(new Medico(id_medico, especialidade, nome_medico));
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }

}
