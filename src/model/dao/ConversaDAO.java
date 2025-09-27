package model.dao;

import model.vo.Atendente;
import model.vo.Conversa;
import model.vo.Ticket;
import util.ConnectionManager;

import java.sql.*;

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
}
