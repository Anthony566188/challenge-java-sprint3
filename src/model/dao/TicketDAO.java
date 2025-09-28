package model.dao;

import model.vo.*;
import util.ConnectionManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO {

    public int inserirTicket(Ticket ticket) {
        Paciente paciente = ticket.getPaciente();
        TipoProblema tipoProblema = ticket.getTipoProblema();
        Consulta consulta = ticket.getConsulta();

        String sql = "INSERT INTO TB_TICKET (id_paciente, id_tipo_problema, id_consulta) VALUES (?,?,?)";

        String[] colunasRetorno = { "ID_TICKET" }; // Array com o nome da coluna de ID
        try (Connection conn = ConnectionManager.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, colunasRetorno)) {

            ps.setInt(1, paciente.getId());
            ps.setInt(2, tipoProblema.getId());
            ps.setInt(3, consulta.getId());
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int idGerado = rs.getInt(1);
                //System.out.println("Ticket criado com ID: " + idGerado);
                return idGerado;
            }
        } catch (SQLException e) {
            System.err.println("Erro ao criar Ticket: " + e.getMessage());
        }
        return -1; // se deu erro
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

//                rs.close();
//                ps.close();
//                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    // Listar apenas os tickets associado a um paciente
    public List<Ticket> listarTicketsPorPaciente(int idPaciente) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM TB_TICKET WHERE id_paciente = ?";

        try {

            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idPaciente);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id_ticket = rs.getInt("id_ticket");
                int id_tipo_problema = rs.getInt("id_tipo_problema");
                int id_consulta = rs.getInt("id_consulta");

                Paciente paciente = new Paciente(idPaciente);
                TipoProblema tipoProblema = new TipoProblema(id_tipo_problema);
                Consulta consulta = new Consulta(id_consulta);

                tickets.add(new Ticket(id_ticket, paciente, tipoProblema, consulta));
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public List<Ticket> listarTicketsPorTipoProblema(int idTipoProblema) {
        List<Ticket> tickets = new ArrayList<>();
        String sql = "SELECT * FROM TB_TICKET WHERE id_tipo_problema = ?";
        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, idTipoProblema);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id_ticket = rs.getInt("id_ticket");
                int id_paciente = rs.getInt("id_paciente");
                int id_consulta = rs.getInt("id_consulta");

                TipoProblema tipoProblema = new TipoProblema(idTipoProblema);
                Paciente paciente = new Paciente(id_paciente);
                Consulta consulta = new Consulta(id_consulta);

                tickets.add(new Ticket(id_ticket, paciente, tipoProblema, consulta));

                rs.close();
                ps.close();
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }


    public void excluirTicket(int id){
        String sql = "DELETE FROM TB_TICKET WHERE ID_TICKET = ?";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Ticket excluído com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir Ticket!");
            e.printStackTrace();
        }
    }

}
