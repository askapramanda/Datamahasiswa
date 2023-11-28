/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springHibernate.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import springHibernate.App;
import springHibernate.configuration.BarangTableModel;
import springHibernate.model.Barang;
import springHibernate.model.JenisBarang;
import springHibernate.view.BarangView;

/**
 *
 * @author hp
 */
public class BarangController {
   private final BarangView barangView;
    private BarangTableModel barangTableModel;
    private List<Barang> barangs;
    
    public BarangController(BarangView barangView) {
        this.barangView = barangView;
    }

    public void tampilData() {
        barangs = App.getBarangService().getBarangs();
        barangTableModel = new BarangTableModel(barangs);
        this.barangView.getTabel().setModel(barangTableModel);
    }
    
    public void show(){
        int index = this.barangView.getTabel().getSelectedRow();

        this.barangView.getIdBarang().setText(String.valueOf(this.barangView.getTabel().getValueAt(index, 0)));
        this.barangView.getNamaBarang().setText(String.valueOf(this.barangView.getTabel().getValueAt(index, 1)));
        this.barangView.getJenisBarang().setText(String.valueOf(this.barangView.getTabel().getValueAt(index, 2)));
        this.barangView.getTanggalKadaluarsa().setText(String.valueOf(this.barangView.getTabel().getValueAt(index, 3)));
    }
    
    public void clear() {
        this.barangView.getIdBarang().setText("");
        this.barangView.getNamaBarang().setText("");
        this.barangView.getJenisBarang().setText("");
        this.barangView.getTanggalKadaluarsa().setText("");
    }
    
    public void saveBarang() {
        Barang barang = new Barang();
        barang.setNamaBarang(this.barangView.getNamaBarang().getText());
        barang.setJenisBarang(JenisBarang.valueOf(this.barangView.getJenisBarang().getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            barang.setTanggalKadaluarsa(dateFormat.parse(this.barangView.getTanggalKadaluarsa().getText()));
        } catch (ParseException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }

        App.getBarangService().save(barang);
        JOptionPane.showMessageDialog(null, "Data Berhasil di Simpan", "info",JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }

    public void updateBarang() {
        Barang barang = new Barang();
        barang.setIdBarang(this.barangView.getIdBarang().getText());
        barang.setNamaBarang(this.barangView.getNamaBarang().getText());
        barang.setJenisBarang(JenisBarang.valueOf(this.barangView.getJenisBarang().getText()));
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            barang.setTanggalKadaluarsa(dateFormat.parse(this.barangView.getTanggalKadaluarsa().getText()));
        } catch (ParseException ex) {
            Logger.getLogger(BarangController.class.getName()).log(Level.SEVERE, null, ex);
        }

        App.getBarangService().update(barang);
        JOptionPane.showMessageDialog(null, "Data Berhasil di Edit", "info",
        JOptionPane.INFORMATION_MESSAGE);
        clear();
        tampilData();
    }
    
    public void deleteBarang() {
        if (this.barangView.getIdBarang().getText() == null) {
            JOptionPane.showMessageDialog(null, "Barang belum dipilih", "error",JOptionPane.ERROR_MESSAGE);
        } else {
            Barang barang = new Barang();
            barang.setIdBarang(this.barangView.getIdBarang().getText());
            int pilih = JOptionPane.showConfirmDialog(null,"Apakah data ingin dihapus ?", "Warning", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (pilih == JOptionPane.YES_OPTION) {
                App.getBarangService().delete(barang);
                JOptionPane.showMessageDialog(null,"Data Berhasil di Hapus", "info",JOptionPane.INFORMATION_MESSAGE);
                clear();
                tampilData();
            }
        }
    }
    
}