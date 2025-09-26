package model.dao;

import model.vo.Especialidade;
import util.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {

    public void inserirEspecialidade(Especialidade especialidade){
        String sql = "INSERT INTO TB_ESPECIALIDADE (nome_especialidade) VALUES (?)";

        try {

            Connection conn = ConnectionManager.getConnection();

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, especialidade.getNome());
            ps.execute();
            System.out.println("Especialidade inserida com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir Especialidade: " + e.getMessage());
        }
    }

    public List<Especialidade> listarEspecialidades(){
        //criar a lista de especialidades
        List<Especialidade> especialidades = new ArrayList<Especialidade>();

        //configurar a query
        String sql = "SELECT * FROM TB_ESPECIALIDADE";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            //preparar o objeto para receber os dados do Oracle
            ResultSet rs = ps.executeQuery();

            // percorrer o ResultSet
            while(rs.next()) {
                int id_especialidade = rs.getInt(1);
                String nome_especialidade = rs.getString(2);

                especialidades.add(new Especialidade(id_especialidade, nome_especialidade));
            }

            rs.close();
            ps.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return especialidades;
    }

    public void excluirEspecialidade(int id){
        String sql = "DELETE FROM TB_ESPECIALIDADE WHERE ID_ESPECIALIDADE = ?";

        try {
            Connection conn = ConnectionManager.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            System.out.println("Especialidade excluida com sucesso!");

            ps.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir o Especialidade!");
            e.printStackTrace();
        }
    }

}
