package com.mycompany.lojavirtual;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Tabela_BD {

    public void criarC() {
        String sql = "CREATE TABLE IF NOT EXISTS cadastro("
                + "id_c INT NOT NULLAUTO_INCREMENT,"
                + "nomeC VARCHAR(255) NOT NULL,"
                + "idade INT NOT NULL,"
                + "telefone INT NOT NULL,"
                + "email VARCHAR(255) NOT NULL,"
                + "PRIMARY KEY (id_c))";

        BancodeDados bd = new BancodeDados();

        try {
            Connection conexao = bd.conectar();
            Statement stmt = conexao.createStatement();
            stmt.execute(sql);
            bd.close(stmt);
            bd.close(conexao);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void criarP() {
        String sql = "CREATE TABLE IF NOT EXISTS livraria("
                + "id_p INT NOT NULLAUTO_INCREMENT,"
                + "nomep VARCHAR(255) NOT NULL,"
                + "precoUnitario DOUBLE NOT NULL"
                + "PRIMARY KEY (id_p))";

        BancodeDados bd = new BancodeDados();

        try {
            Connection conexao = bd.conectar();
            Statement stmt = conexao.createStatement();
            stmt.execute(sql);
            bd.close(stmt);
            bd.close(conexao);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
