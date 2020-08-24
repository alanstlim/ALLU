
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Alan S'
 */
public class Conexao {
    public Statement stm; //Preparar e realizar pesquisas no DB - Padrão
    public ResultSet rs; // Armazenar dados no DB - Padrão
    public Connection con; //Conexão com o DB - Padrão
    
    //-- No caso de outro tipo de DB EDITAR apenas as variaveis abaixo 
    private String driver = "com.mysql.jdbc.Driver"; //Driver da conexão
    private String url = "jdbc:mysql://127.0.0.1/lag"; // Caminho da conexão
    // --
    
   
    //-- Editar Usuario e Senha do DB 
    private String usuario = "root"; // Usuário do DB
    private String senha = ""; // Senha do DB
    // -- 
    
     public void conectar(){ // Metodo para Conectar ao DB
      try {
            System.setProperty("jdbc.Drivers", driver); // Seta as propriedades do driver
            con = DriverManager.getConnection(url, usuario, senha); // Realiza a conexão com o DB
            System.out.println("Conectado com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Falha na Conexão! \n Erro: "+ ex.getMessage());
        }
    }
    
    public void executaSQL(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            System.out.println("Falha no ExecutaSQL! \n Erro: "+ ex.getMessage());
        }
        
        
    }
    
    
    public void desconecta(){ // Metodo para Desconectar ao DB
        try{
            con.close(); // Fechando Conexão
            System.out.println("Desconectado com Sucesso!");
        } catch (SQLException ex) {
            System.out.println("Falha ao Desconectar! \n Erro: "+ ex.getMessage());
        }
    }
}
