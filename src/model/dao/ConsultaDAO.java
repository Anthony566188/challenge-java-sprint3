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

    public List<Consulta> listarConsultas(){
        //criar a lista de Consultas
        List<Consulta> consultas = new ArrayList<Consulta>();

        //configurar a query
        String sql = "SELECT * FROM TB_CONSULTA";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id_consulta = rs.getInt(1);
                int id_paciente = rs.getInt(2);
                int id_medico = rs.getInt(3);
                LocalDateTime data_e_hora_inicio = rs.getTimestamp(4).toLocalDateTime();
                LocalDateTime data_e_hora_fim = rs.getTimestamp(5).toLocalDateTime();

                Paciente paciente = new Paciente(id_paciente);
                Medico medico = new Medico(id_medico);

                consultas.add(new Consulta(id_consulta, paciente, medico, data_e_hora_inicio, data_e_hora_fim));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consultas;
    }

}
