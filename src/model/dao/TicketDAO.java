package model.dao;

import model.vo.*;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class TicketDAO {

    public void inserirTicket(Ticket ticket){

        // Obter o objeto Paciente, TipoProblema e Consulta a partir do Ticket
        Paciente paciente = ticket.getPaciente();
        TipoProblema tipoProblema = ticket.getTipoProblema();
        Consulta consulta = ticket.getConsulta();

        String sql = "INSERT INTO TB_TICKET (id_paciente, id_tipo_problema, id_consulta) VALUES (?,?,?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, paciente.getId());
            ps.setInt(2, tipoProblema.getId());
            ps.setInt(3, consulta.getId());
            ps.execute();
            System.out.println("Ticket criado com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao criar Ticket: " + e.getMessage());
        }
    }
}
