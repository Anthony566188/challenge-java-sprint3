package model.dao;

import model.vo.Atendente;
import model.vo.Especialidade;
import model.vo.Medico;
import model.vo.Paciente;
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
        //criar a lista de médicos
        List<Medico> medicos = new ArrayList<Medico>();

        //configurar a query
        String sql = "SELECT * FROM TB_MEDICO";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id_medico = rs.getInt(1);
                int id_especialidade = rs.getInt(2);
                String nome_medico = rs.getString(3);

                Especialidade especialidade = new Especialidade(id_especialidade);

                medicos.add(new Medico(id_medico, especialidade, nome_medico));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicos;
    }

}
