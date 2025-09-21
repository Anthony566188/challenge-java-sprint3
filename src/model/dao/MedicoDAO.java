package model.dao;

import model.vo.Especialidade;
import model.vo.Medico;
import model.vo.Paciente;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
