package model.dao;

import model.vo.*;
import util.ConnectionManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public List<Ticket> listarTickets(){
        //criar a lista de Tickets
        List<Ticket> tickets = new ArrayList<Ticket>();

        //configurar a query
        String sql = "SELECT * FROM TB_TICKET";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id_ticket = rs.getInt(1);
                int id_paciente = rs.getInt(2);
                int id_tipo_problema = rs.getInt(3);
                int id_consulta = rs.getInt(4);

                Paciente paciente = new Paciente(id_paciente);
                TipoProblema tipoProblema = new TipoProblema(id_tipo_problema);
                Consulta consulta = new Consulta(id_consulta);

                tickets.add(new Ticket(id_ticket, paciente, tipoProblema, consulta));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

}
