package model.dao;

import model.vo.Consulta;
import model.vo.Especialidade;
import model.vo.Medico;
import model.vo.Paciente;
import util.ConnectionManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConsultaDAO {

    public void inserirConsulta(Consulta consulta){

        // Obter o objeto Paciente e Médico a partir da Consulta
        Paciente paciente = consulta.getPaciente();
        Medico medico = consulta.getMedico();

        String sql = "INSERT INTO TB_CONSULTA (id_paciente, id_medico, data_e_hora_inicio, data_e_hora_fim) VALUES (?,?,?,?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, paciente.getId());
            ps.setInt(2, medico.getId());
            ps.setTimestamp(3, Timestamp.valueOf(consulta.getDataEHoraInicio()));
            ps.setTimestamp(4, Timestamp.valueOf(consulta.getDataEHoraFim()));
            ps.execute();
            System.out.println("Consulta inserida com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Consulta: " + e.getMessage());
        }
    }

    public List<Consulta> listarConsultas() {
        List<Consulta> consultas = new ArrayList<>();
        String sql = "SELECT * FROM TB_CONSULTA";

        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Consulta consulta = new Consulta();
                consulta.setId(rs.getInt("id_consulta"));
                consulta.setDataEHoraInicio(rs.getTimestamp("data_e_hora_inicio").toLocalDateTime());
                consulta.setDataEHoraFim(rs.getTimestamp("data_e_hora_fim").toLocalDateTime());

                // Paciente associado
                Paciente paciente = new Paciente();
                paciente.setId(rs.getInt("id_paciente"));
                consulta.setPaciente(paciente);

                // Médico associado
                Medico medico = new Medico();
                medico.setId(rs.getInt("id_medico"));
                consulta.setMedico(medico);

                consultas.add(consulta);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return consultas;
    }



}
