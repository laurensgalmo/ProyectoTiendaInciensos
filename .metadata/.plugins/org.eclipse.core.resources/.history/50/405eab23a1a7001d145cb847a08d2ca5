package rf.ficheros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rf.ficheros.modelos.Country;
import rf.ficheros.util.MontadorSQL;
import rf.ficheros.util.OracleJDBC;

public class CountryDao implements CountryDaoI {

	private static Connection conn;

	public final static String SQL_LEER_TODOS_COUNTRY = "Select * from countries_LGM";
	public final static String SQL_LEER_COUNTRY_POR_ID = "Select * from COUNTRIES where COUNTRY_ID =  1";
	public final static String SQL_LEER_COUNTRY_POR_ID2 = "Select * from COUNTRIES_LGM where country_id=?";
	public final static String SQL_ACTUALIZAR_COUNTRY = "Update countries_LGM set Country_id = ?, country_name = ?, region_id = ?, where country_id = ?";
	public final static String SQL_BORRAR_COUNTRY = "Delete countries_LGM where country_id = ?";

	public CountryDao() throws SQLException {
		OracleJDBC ora = new OracleJDBC();
		conn = ora.abrir();
	}

	@Override
	public Country leerUno(String country_id) throws Exception {
		ResultSet rs = null;
	
		try {
			// Statement stm = conn.createStatement();
			// rs = stm.executeQuery(SQL_LEER_COUNTRY_POR_ID + " " + country_id + " ");
			PreparedStatement ps = conn.prepareStatement(SQL_LEER_COUNTRY_POR_ID2);
			ps.setString(1, country_id);
			rs = ps.executeQuery();
			rs.next();
			return carga(rs);
		} catch (SQLException e) {
			throw new Exception(SQL_LEER_COUNTRY_POR_ID + " " + e.getMessage());

		}
	}

	@Override
	public List<Country> leerTodos() throws Exception {
		ResultSet rs = null;
		List<Country> salida = new ArrayList<>();

		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(SQL_LEER_TODOS_COUNTRY);

			while (rs.next()) {
				salida.add(carga(rs));
			}
		} catch (SQLException e) {
			throw new Exception(SQL_LEER_TODOS_COUNTRY + " " + e.getMessage());
		}
		return salida;
	}

	@Override
	/**
	 * public int actualizar(Country country) throws SQLException {
	 * PreparedStatement ps = conn.prepareStatement(SQL_ACTUALIZAR_COUNTRY);
	 * ps.setString(1, country.getCountry_id()); ps.setString(2,
	 * country.getCountry_name()); ps.setString(3, country.getRegion_id());
	 * ps.setString(4, country.getCountry_id());
	 * 
	 * return ps.executeUpdate(); }
	 */

	public int actualizar(Country country) throws SQLException {
		String sql = "Update countries_LGM set " + montaSqlU(country);
		sql += " where ";
		sql = MontadorSQL.addSalida(sql, "country_id", country.getCountry_id(), ",");
		System.out.println(sql);
		Statement stm = conn.createStatement();
		return stm.executeUpdate(sql);
	}

	@Override
	public int delete(Country country) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SQL_BORRAR_COUNTRY);
		ps.setString(1, country.getCountry_id());

		return ps.executeUpdate();
	}

	@Override
	public int delete(String country_id) throws SQLException {
		PreparedStatement ps = conn.prepareStatement(SQL_BORRAR_COUNTRY);
		ps.setString(1, country_id);

		return ps.executeUpdate();
	}

	@Override
	public Country insert(Country country) throws SQLException {
		String sql = "insert into countries_LGM set " + montaSqlU(country);
		System.out.println(sql);
		Statement stm = conn.createStatement();
		stm.executeUpdate(sql);
		return country;
	}

	public Country carga(ResultSet rs) throws SQLException {
		Country ctr = new Country();
		ctr.setCountry_id(rs.getString("Country_id"));
		ctr.setCountry_name(rs.getString("country_name"));
		ctr.setCountry_id(rs.getString("region_id"));
		return ctr;

	}

	public String montaSqlU(Country country) {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, "country_id", country.getCountry_id(), ",");
		salida = MontadorSQL.addSalida(salida, "country_name", country.getCountry_name(), ",");
		salida = MontadorSQL.addSalida(salida, "region_id", country.getRegion_id(), ",");

		return salida;
	}

	public String montaSqlI(Country country) {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, "", country.getCountry_id(), ",");
		salida = MontadorSQL.addSalida(salida, "", country.getCountry_name(), ",");
		salida = MontadorSQL.addSalida(salida, "", country.getRegion_id(), ",");

		return salida;
	}

}
