package org.example;

import java.sql.*;


public class App 
{
    public static final String DB_URL = "jdbc:postgresql://localhost/dvdrental";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "admin159";
    public static void main( String[] args )
    {
        Connection connection = null;
       // String sql = "SELECT * FROM film";

       // String insertSql = "INSERT INTO film(title, release_year,language_id) VALUES ('deneme',2000,1)";
       // String prSql = "INSERT INTO film(title, release_year,language_id) VALUES (?,?,?)";
       // burada prestatemnt ıcın sql kodu yazıyoruz fakat degerlerı sonradan gırmek ıstedıgımız ıcın soru ısaretı bırakıyoruz

        /* String stSql = "UPDATE film SET title = 'heydegisti' Where film_id = 1002";
        String prSql = "UPDATE film SET title = ? Where film_id = ?";
        burada kayıt guncellemeyı iki yöntemle yaptık
         */


        String stSql = "Delete FROM film WHERE film_id = 1007";
        String prSql = "Delete FROM film WHERE film_id = ?";


        try{
            connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
            System.out.println("baglanti basarili");

             Statement st = connection.createStatement();
            st.executeUpdate(stSql);
            System.out.println("1007 silindi ");



            PreparedStatement prst = connection.prepareStatement(prSql);
            prst.setInt(1,1003);
            System.out.println("1003 silindi");
            prst.executeUpdate();
            prst.close();
            st.close();
            connection.close();





            /* Statement st = connection.createStatement();
            st.executeUpdate(stSql);
            statement olusturarak guncelleme yaptık
             */

            /*
            PreparedStatement prst = connection.prepareStatement(prSql);
            prst.setString(1,"heydegisti2");
            prst.setInt(2,1007);
            prst.executeUpdate();
            prst.close();
            burada da prestatement olusturarak guncelleme yaptık
             */



           /*

            PreparedStatement prst = connection.prepareStatement(prSql);
            prst.setString(1,"heyy");
            prst.setInt(2,2000);
            prst.setInt(3,2);
            prst.executeUpdate();
            prst.close();

            */


            // Statement st = connection.createStatement();
            // System.out.println(st.executeUpdate(insertSql));
            //Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            // değer vermemizin sebebi first ve last metodunu kullanmak






           /* ResultSet data = st.executeQuery(sql);

            data.next();
            data.next();
            data.last();    // veritabanındaki son satıra ulaşır
            data.absolute(2); // veritabanındaki istenilen satira ulaşır
            System.out.println(data.getString("title"));

            while (data.next()){
                System.out.println("ID: " + data.getInt( "film_id"));
                System.out.println("Title: " + data.getString( "title"));
                System.out.println("Release Year: " + data.getInt( "release_year"));
                System.out.println("******************************************");
            } */

        }
        catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
