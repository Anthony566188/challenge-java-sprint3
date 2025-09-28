package model.dao;

import model.vo.*;
import util.ConnectionManager;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConversaDAO {

    public void inserirConversa(Conversa conversa){

        Atendente atendente = conversa.getAtendente();
        Ticket ticket = conversa.getTicket();

        String sql = "INSERT INTO TB_CONVERSA(id_atendente, id_ticket, nome_ticket, anexo_ticket, descricao_ticket, status, data_e_hora) VALUES (?,?,?,?,?,?,?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, atendente.getId());
            ps.setInt(2, ticket.getId());
            ps.setString(3, conversa.getNome_ticket());
            ps.setNull(4, Types.BLOB); // Aqui enviará um valor nulo já que o banco espera um BLOB
            ps.setString(5, conversa.getDescricao_ticket());
            ps.setString(6, conversa.getStatus());
            ps.setTimestamp(7, Timestamp.valueOf(conversa.getData_e_hora()));

            System.out.println("Ticket criado com sucesso!");
            ps.execute();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao criar Conversa: " + e.getMessage());
        }
    }

    public List<Conversa> listarConversas(){
        List<Conversa> conversas = new ArrayList<Conversa>();

        String sql = "SELECT id_ticket, nome_ticket, descricao_ticket, status, data_e_hora FROM TB_CONVERSA";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id_ticket = rs.getInt("id_ticket");
                String nome_ticket = rs.getString("nome_ticket");
                String descricao = rs.getString("descricao_ticket");
                String status = rs.getString("status");
                LocalDateTime data_e_hora = rs.getTimestamp("data_e_hora").toLocalDateTime();

                Ticket ticket = new Ticket(id_ticket);

                conversas.add(new Conversa(ticket, nome_ticket, descricao, status, data_e_hora));

//                rs.close();
//                ps.close();
//                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conversas;
    }

    public void atualizarStatusTicket(Conversa conversa) {

        String sql = "UPDATE TB_CONVERSA" + " SET STATUS = ? "
                + " WHERE ID_TICKET = ? ";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, conversa.getStatus());
            ps.setInt(2, conversa.getTicket().getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void pacienteAtualizarTicket(Conversa conversa) {
        String sql = "UPDATE TB_CONVERSA SET NOME_TICKET = ?, DESCRICAO_TICKET = ?, DATA_E_HORA = ? WHERE ID_TICKET = ?";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, conversa.getNome_ticket());
            ps.setString(2, conversa.getDescricao_ticket());
            ps.setTimestamp(3, Timestamp.valueOf(conversa.getData_e_hora()));
            ps.setInt(4, conversa.getTicket().getId());

            ps.execute();


            System.out.println("Ticket atualizado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void excluirCoversa(int id) {
        String sql = "DELETE FROM TB_CONVERSA WHERE id_ticket = ?";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir Conversa!");
            e.printStackTrace();
        }
    }
}
