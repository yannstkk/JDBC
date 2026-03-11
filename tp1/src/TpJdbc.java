import java.sql.*;
import oracle.jdbc.pool.OracleDataSource;

public class TpJdbc {
    private static OracleDataSource ods; // Source de données partagée
    private Connection connect; // Connexion unique par instance
    private Statement stmt; // Pour exécuter des requêtes SQL
    private PreparedStatement ps;   // Q5
    private CallableStatement csInsererLigne;   // Q6 (optionnel, sinon local dans la méthode)


    public TpJdbc(String login, String password) {
        this.seConnecter(login, password);

        try {
            this.stmt = this.connect.createStatement();
            this.ps = this.connect.prepareStatement("SELECT id, texte FROM JFROOS.TABLE_TEST WHERE texte LIKE ?"); 
        } catch (SQLException e) {
            System.err.println(" Erreur lors de la création du Statement : " + e.getErrorCode() + " " + e.getMessage());
        }
    }

 
    public void seConnecter(String login, String password) {
        try {
            
            
            ods = new OracleDataSource();
            
            ods.setURL("jdbc:oracle:thin:@oracle.fil.univ-lille.fr:1521:filora");
            ods.setUser(login);
            ods.setPassword(password);

            this.connect = ods.getConnection();
            System.out.println(" Connexion réussie !");


        } catch (SQLException e) {
            System.err.println(" Erreur de connexion : " + e.getErrorCode() + " " + e.getMessage());
            e.printStackTrace();
        }
    }


    public void lireTableTest() {
        ResultSet rs = null;
        try {
            rs = stmt.executeQuery("SELECT * FROM JFROOS.TABLE_TEST");

            System.out.println("\n Contenu de la table JFROOS.TABLE_TEST :");
            while (rs.next()) {
                int id = rs.getInt("id");
                String texte = rs.getString("texte");
                System.out.println(" ID : " + id + " | Texte : " + texte);
            }
        } catch (SQLException e) {
            System.err.println(" Erreur lors de la lecture de la table : " + e.getErrorCode() + " " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                System.err.println("Erreur lors de la fermeture du ResultSet : " + e.getMessage());
            }
        }
    }


        public void lireTableTestAmeliore(String s) {
        ResultSet rs = null;
        try {
            // le % permet “contient”
            ps.setString(1, "%" + s + "%");

            rs = ps.executeQuery();

            System.out.println("\nLignes dont texte contient '" + s + "' :");
            while (rs.next()) {
                int id = rs.getInt("id");
                String texte = rs.getString("texte");
                System.out.println("ID : " + id + " | Texte : " + texte);
            }
        } catch (SQLException e) {
            System.err.println("Erreur lireTableTestAmeliore : " + e.getErrorCode() + " " + e.getMessage());
        } finally {
            try { if (rs != null) rs.close(); } 
            catch (SQLException e) { System.err.println("Erreur fermeture ResultSet : " + e.getMessage()); }
        }
    }

    public void insererLigne(String s) {
        CallableStatement cs = null;
        try {
            cs = connect.prepareCall("{call  ? = JFROOS.inserer_ligne(?)}");
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setString(2, s);
            cs.execute();

            int id = cs.getInt(1);
            System.out.println("Ligne insérée : ID = " + id + ", Texte = '" + s + "'");

        } catch (SQLException e) {
            System.err.println("Erreur lors de l'insertion : " + e.getErrorCode() + " " + e.getMessage());
        } finally {
            try { if (cs != null) cs.close(); } 
            catch (SQLException e) { System.err.println("Erreur fermeture CallableStatement : " + e.getMessage()); }
        }
    }


    public void seDeconnecter() {
        try {
            if (stmt != null) stmt.close();
            if (connect != null) {
                connect.close();
                System.out.println("Connexion fermée.");
            }
        } catch (SQLException e) {
            System.err.println(" Erreur lors de la fermeture de la connexion !");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        try {
            TpJdbc jdbc = new TpJdbc("ZAIDI", "valeriana");

            jdbc.lireTableTest();

            jdbc.seDeconnecter();
        } catch (Exception e) {
            System.err.println(" Erreur lors de l'exécution : " + e.getMessage());
        }
    }
}
