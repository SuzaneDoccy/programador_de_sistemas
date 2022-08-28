package com.mycompany.lojavirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Livraria {

    public void armazenaLivro(String nomep, double precoUnitario) {

        String sql = "INSERT INTO livraria (nomep, precoUnitario) VALUES ('?','?') ";
        BancodeDados bd = new BancodeDados();

        try {
            Connection conexao = bd.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nomep);
            pstmt.setDouble(2, precoUnitario);
            pstmt.execute();

            bd.close(pstmt);
            bd.close(conexao);
            System.out.println("Produto adicionado com sucesso");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public int buscaLugarLivro(String nomep) {
        
        String sql = "SELECT * FROM livraria WHERE nome = " + nomep + "";
        BancodeDados bd = new BancodeDados();
        int lugarLivro = 0;

        try {
            Connection conexao = bd.conectar();
            Statement stmt = conexao.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            if (result != null) {
                while (result.next());
                lugarLivro = result.getInt("id");
            }
            bd.close(result);
            bd.close(stmt);
            bd.close(conexao);
            return lugarLivro;

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SQL" + e.getSQLState());

        }
        return 0;
    }

    public void removeLivro(String nomep) {
        int posicaoEncontrada = this.buscaLugarLivro(nomep);
        if (posicaoEncontrada == 0) {
            System.out.println("Produto não encontrado na livraria.");
            return;
        }
        String sql = "DELETE FROM livraria WHERE id = ?";
        BancodeDados bd = new BancodeDados();

        try {
            Connection conexao = bd.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, posicaoEncontrada);
            bd.close(pstmt);
            bd.close(conexao);
            System.out.println("Produto" + posicaoEncontrada + "excluído com sucesso.");
            return;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimeLivro(int index) throws IndexOutOfBoundsException {
        if (index <= 0) {
            System.out.println("Posição informada é inválida. A lista da livraria começa na posição 1");
            return;
        }

        String sql = "SELECT * FROM livraria WHERE id = ?";
        BancodeDados bd = new BancodeDados();

        try {
            boolean achou = false;
            Connection conexao = bd.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, index);
            ResultSet result = pstmt.executeQuery();

            while (result.next()) {
                achou = true;
                System.out.println("Na posição:" + result.getInt("id") + "temos:");
                System.out.println("Nome:" + result.getString("nome"));
                System.out.println("Preço:" + result.getDouble("preco"));
            }

            if (!achou) {
                System.out.println("Não há produto nessa posição.");
            }
            bd.close(result);
            bd.close(pstmt);
            bd.close(conexao);
            return;

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimeLivraria() {
        BancodeDados bd = new BancodeDados();
        String sql = "SELECT * FROM livraria ORDER BY nomep ASC";

        try {
            Connection conexao = bd.conectar();
            Statement stmt = conexao.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            boolean temRegistro = false;

            while (result.next()) {
                temRegistro = true;
                System.out.println("Na posição:" + result.getInt("id") + "temos:");
                System.out.println("Nome:" + result.getString("nome"));
                System.out.println("Idade:" + result.getInt("Idade"));
                System.out.println("Preço:" + result.getDouble("preco"));
                System.out.println("----------------------------------------------");
            }

            if (temRegistro) {
                System.out.println("A lista da livraria está vazia.");
            }
            bd.close(result);
            bd.close(stmt);
            bd.close(conexao);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Livro temLivroNaPosicao(int index) {
        String sql = "SELECT * FROM livraria WHERE id = " + index + "";
        BancodeDados bd = new BancodeDados();
        boolean achou = false;

        try {
            Connection conexao = bd.conectar();
            Statement stmt = conexao.createStatement();
            ResultSet result = stmt.executeQuery(sql);
            Livro livro = null;
            while (result.next()) {
                livro = new Livro(
                        result.getString("nome"),
                        result.getFloat("preco")
                );
                break;
            }
            bd.close(result);
            bd.close(stmt);
            bd.close(conexao);
            return livro;

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SQL" + e.getSQLState());

        }
        return null;
    }

    public void atualizaLivraria(int index, String nomep, double precoUnitario) {
        if (this.temLivroNaPosicao(index) == null) {
            System.out.println("Não há livro nessa posição");
            return;
        }
        String sql = "UPDATE cadastro SET nomeC = ?, precoUnitario = ? WHERE id = ?";
        BancodeDados bd = new BancodeDados();
        try {
            Connection conexao = bd.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nomep);
            pstmt.setDouble(2, precoUnitario);
            pstmt.setInt(3, index);
            pstmt.execute();

            System.out.println("Livraria atualizada com sucesso");
            bd.close(pstmt);
            bd.close(conexao);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
