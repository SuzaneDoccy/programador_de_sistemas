package com.mycompany.lojavirtual;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Cadastro {

    public void armazenaCliente(String nomeC, int idade, String telefone, String email) {
        if (this.buscaPosicaoCliente(nomeC) != 0) {
            System.out.println("Este cliente já foi adicionada na lista da lojinha");
            return;
        }
        String sql = "INSERT INTO cadastro (nomeC, idade, telefone, email) VALUES ('?','?','?','?') ";
        BancodeDados bd = new BancodeDados();

        try {
            Connection conexao = bd.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nomeC);
            pstmt.setInt(2, idade);
            pstmt.setString(3, telefone);
            pstmt.setString(4, email);
            pstmt.execute();

            bd.close(pstmt);
            bd.close(conexao);
            System.out.println("Cadastro concluído com sucesso");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return;
    }

    public int buscaPosicaoCliente(String nomeC) {
        String sql = "SELECT * FROM cadastro WHERE nome = " + nomeC + "";
        BancodeDados bd = new BancodeDados();
        int posicaoEncontrada = 0;

        try {
            Connection conexao = bd.conectar();
            Statement stmt = conexao.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            if (result != null) {
                while (result.next());
                posicaoEncontrada = result.getInt("id");
            }
            bd.close(result);
            bd.close(stmt);
            bd.close(conexao);
            return posicaoEncontrada;

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SQL" + e.getSQLState());

        }
        return 0;
    }

    public void removeCliente(String nomeC) {
        int posicaoEncontrada = this.buscaPosicaoCliente(nomeC);
        if (posicaoEncontrada == 0) {
            System.out.println("Cliente não encontrado na lista.");
            return;
        }
        String sql = "DELETE FROM cadastro WHERE id = ?";
        BancodeDados bd = new BancodeDados();

        try {
            Connection conexao = bd.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setInt(1, posicaoEncontrada);
            bd.close(pstmt);
            bd.close(conexao);
            System.out.println("Cadastro" + posicaoEncontrada + "excluído com sucesso.");
            return;
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void imprimeCliente(int index) throws IndexOutOfBoundsException {
        if (index <= 0) {
            System.out.println("Posição informada é inválida. A lista começa na posição 1");
            return;
        }

        String sql = "SELECT * FROM cadastro WHERE id = ?";
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
                System.out.println("Idade:" + result.getInt("idade"));
                System.out.println("Altura:" + result.getDouble("altura"));
            }

            if (!achou) {
                System.out.println("Não há registro nessa posição.");
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
        return;
    }

    public void imprimeClientes() {
        BancodeDados bd = new BancodeDados();
        String sql = "SELECT * FROM cadastro ORDER BY nomeC ASC";

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
                System.out.println("Altura:" + result.getDouble("altura"));
                System.out.println("----------------------------------------------");
            }

            if (temRegistro) {
                System.out.println("A lista de cadastro está vazio.");
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

    public boolean temCadastroNaPosicao(int index) {
        String sql = "SELECT * FROM cadastro WHERE id = " + index + "";
        BancodeDados bd = new BancodeDados();
        boolean achou = false;

        try {
            Connection conexao = bd.conectar();
            Statement stmt = conexao.createStatement();
            ResultSet result = stmt.executeQuery(sql);

            while (result.next()) {
                achou = true;
            }
            bd.close(result);
            bd.close(stmt);
            bd.close(conexao);
            return achou;

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage() + "SQL" + e.getSQLState());

        }
        return false;
    }

    public void atualizaCadastro(int index, String nomeC, int idade, String telefone, String email) {
        if (!this.temCadastroNaPosicao(index)) {
            System.out.println("Não há cadastro nessa posição");
            return;
        }
        String sql = "UPDATE cadastro SET nomeC = ?, idade = ?, telefone = ?, email = ? WHERE id = ?";
        BancodeDados bd = new BancodeDados();
        try {
            Connection conexao = bd.conectar();
            PreparedStatement pstmt = conexao.prepareStatement(sql);
            pstmt.setString(1, nomeC);
            pstmt.setInt(2, idade);
            pstmt.setString(3, telefone);
            pstmt.setString(4, email);
            pstmt.setInt(5, index);
            pstmt.execute();

            System.out.println("Cadastro atualizado com sucesso");
            bd.close(pstmt);
            bd.close(conexao);

        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
