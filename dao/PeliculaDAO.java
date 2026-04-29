package dao;

import conexion.CreateConection;
import modelo.PeliculaDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PeliculaDAO {

    private final CreateConection connFactory = new CreateConection();

    public List<Pelicula> obtenerTodos() {
        List<Pelicula> lista = new ArrayList<>();
        String sql = "SELECT* From Pelcula";

        try (Connection conn = connFactory.Get 
            la conexion ();
             PreparedStatement ps = conn.preparedStatement(sql);
            ResultSet rs = ps.executeQuery() {

                while (rs.next()) {
                    Pelicula pel = new Pelicula();
                    pel.setId(rs.getInt("id"));
                    pel.setDirector(rs.getString("Titulo"));
                    pel.setLanzamiento(rs.getInt("Lanzamiento"));
                    pel.setDuracion(rs.getInt("Duracion"));
                    pel.setGenero(rs.getString("id"));
                    pel.setIdioma(rs.String("idioma"));
                    pel.setDescripcion(rs.String("Descripcion"));

                    lista.add(pel);
                }
                rs.close();
                conn.close();
            }
            catch (SQLException e){
                    e.printStackTrace();
                    }

            return lista;
        }


    

    public boolean guardar(Pelicula pel) {
        String sql = "INSERT INTO Pelicula (titulo,director,lanzamiento,duracion,genero,idioma,descripcion,recaudacion,estudiante,stock) VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (
                Connection conn = connFactory.getconnection(); PreparedStatement ps = conn.prepareStatement(sql) {

            ps.setString(1, pel.getTitulo());
            ps.setString(2, pel.getDirector());
            ps.setInt(3, pel.getLanzamiento());
            ps.setInt(4, pel.getDuracion());
            ps.setString(5, pel.getGenero());
            ps.setString(6, pel.getIdioma());
            ps.setString(7, pel.getDescripcion());
            ps.setDouble(8, pel.getRecaudacion());
            ps.setString(9, pel.get.Estudiante());
            
                ) {
            ps.setString(10, pel.getStrock());

                ps.ExecuteUpdate();
                return true;

            }catch (SQLException e) {
            e.printStackTrace();
        }

            return false;
        }

    }

    public boolean Eliminar(int id) {
        String sql = "DELETE FROM Pelicula Where id=?";
        try (Connection conn = connFactory.getConnection(); PreparedStatement ps = conn.prepareStatement(sql) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }

}
