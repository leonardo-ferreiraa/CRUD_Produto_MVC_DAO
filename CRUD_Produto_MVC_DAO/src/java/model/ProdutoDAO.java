/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import util.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author alunos
 */
public class ProdutoDAO {

    public void cadastrar(Produto p) throws ClassNotFoundException, SQLException {
        //se conecta com a classe conexao.java
        Connection con = Conexao.getConexao();
        //uma um comando do SQL para inserir um dado
        PreparedStatement comando = con.prepareStatement("insert into produtos(descricao,preco,quantidade,fornecedor,setor,data,tipo)values(?,?,?,?,?,?,?)");
        comando.setString(1, p.getDescricao());
        comando.setDouble(2, p.getPreco());
        comando.setInt(3,p.getQuantidade());
        comando.setString(4,p.getFornecedor());
        comando.setInt(5,p.getSetor());
        comando.setString(6,p.getData());
        comando.setString(7,p.getTipo());
        
        comando.execute();
        con.close();
    }

    public void deletar(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("delete from produtos where id=?");
        comando.setInt(1, p.getId());
        comando.execute();
        con.close();
    }

    public void update(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("update produtos set descricao = ?, preco = ?, quantidade = ?, fornecedor = ?, data = ?, tipo = ? where id = ?");
        comando.setString(1, p.getDescricao());
        comando.setDouble(2, p.getPreco());
        comando.setInt(3,p.getQuantidade());
        comando.setString(4,p.getFornecedor());
        comando.setInt(5,p.getSetor());
        comando.setString(6,p.getData());
        comando.setString(7,p.getTipo());
        comando.setInt(8, p.getId());
        comando.execute();
        con.close();
    }

    public void select(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos");
        comando.execute();
        con.close();
    }

    public Produto consultarById(Produto p) throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos where id= ?");
        comando.setInt(1, p.getId());
        ResultSet rs = comando.executeQuery();
        Produto prod = new Produto();
        if (rs.next()) {
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setPreco(rs.getDouble("preco"));
            prod.setQuantidade(rs.getInt("quantidade"));
            prod.setFornecedor(rs.getString("fornecedor"));
            prod.setSetor(rs.getInt("setor"));
            prod.setData(rs.getString("data"));
            prod.setTipo(rs.getString("tipo"));
            
        }
        return prod;
    }

    public List<Produto> consultarTodos() throws ClassNotFoundException, SQLException {
        Connection con = Conexao.getConexao();
        PreparedStatement comando = con.prepareStatement("select * from produtos");
        ResultSet rs = comando.executeQuery();
        
        List<Produto> lprod = new ArrayList<Produto>();
        while (rs.next()) {
            Produto prod = new Produto();
            prod.setId(rs.getInt("id"));
            prod.setDescricao(rs.getString("descricao"));
            prod.setPreco(rs.getDouble ("preco"));
            prod.setQuantidade(rs.getInt("quantidade"));
            prod.setFornecedor(rs.getString("fornecedor"));
            prod.setSetor(rs.getInt("setor"));
            prod.setData(rs.getString("data"));
            prod.setTipo(rs.getString("tipo"));
            lprod.add(prod);
            
        }
        return lprod;
        
    }
}
