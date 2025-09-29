package model.dao;

import model.vo.Especialidade;
import model.vo.TipoProblema;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TipoProblemaDAO {

    public void inserirTipoProblema(TipoProblema tipoProblema){
        String sql = "INSERT INTO TB_TIPO_PROBLEMA (nome_tipo_problema) VALUES (?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tipoProblema.getNome());
            ps.execute();
            System.out.println("Tipo de Problema inserido com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Tipo de Problema: " + e.getMessage());
        }
    }

    public List<TipoProblema> listarTiposProblemas(){
        //criar a lista de Tipos de Problemas
        List<TipoProblema> tiposProblemas = new ArrayList<TipoProblema>();

        //configurar a query
        String sql = "SELECT * FROM TB_TIPO_PROBLEMA";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id_tipo_problema = rs.getInt(1);
                String nome_tipo_problema = rs.getString(2);

                tiposProblemas.add(new TipoProblema(id_tipo_problema, nome_tipo_problema));
            }

            rs.close();
            ps.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tiposProblemas;
    }

    public void atualizarTipoProblema(TipoProblema tipoProblema) {
        System.out.println(" --- atualizando o Tipo de Problema " + tipoProblema.getNome() + " --- ");

        String sql = "UPDATE TB_TIPO_PROBLEMA" + " SET NOME_TIPO_PROBLEMA = ? WHERE ID_TIPO_PROBLEMA = ? ";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tipoProblema.getNome());
            ps.setInt(2, tipoProblema.getId());
            ps.execute();
            System.out.println("Tipo de problema atualizado com sucesso!");

            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirTipoProblema(int id){
        String sql = "DELETE FROM TB_TIPO_PROBLEMA WHERE ID_TIPO_PROBLEMA = ?";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Tipo de problema excluído com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir Tipo de problema!");
            e.printStackTrace();
        }
    }

}
