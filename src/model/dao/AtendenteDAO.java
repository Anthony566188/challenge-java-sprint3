package model.dao;

import model.vo.Atendente;
import model.vo.Paciente;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AtendenteDAO {

    public void inserirAtendente(Atendente atendente){
        String sql = "INSERT INTO TB_ATENDENTE (nome_atendente, email_atendente) VALUES (?,?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, atendente.getNome());
            ps.setString(2, atendente.getEmail());
            ps.execute();
            System.out.println("Atendente inserido com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Atendente: " + e.getMessage());
        }
    }

    public List<Atendente> listarAtendentes(){
        //criar a lista de atendentes
        List<Atendente> atendentes = new ArrayList<Atendente>();

        //configurar a query
        String sql = "SELECT * FROM TB_ATENDENTE";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id_atendente = rs.getInt(1);
                String nome_atendente = rs.getString(2);
                String email_atendente = rs.getString(3);

                atendentes.add(new Atendente(id_atendente, nome_atendente, email_atendente));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return atendentes;
    }

}
