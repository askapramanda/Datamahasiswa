/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springHibernate.dao;
import java.util.List;
import springHibernate.model.Barang;
/**
 *
 * @author hp
 */
public interface BarangDao {
    public void save(Barang barang);
    public void update(Barang barang);
    public void delete(Barang barang);
    public Barang getBarang(String idBarang);
    public List<Barang> getBarangs();
}
