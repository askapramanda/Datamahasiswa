/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springHibernate.service;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springHibernate.dao.BarangDao;
import springHibernate.model.Barang;

/**
 *
 * @author hp
 */
@Service("BarangService")
@Transactional(readOnly = true)
public class BarangServiceImpl implements BarangService {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Transactional
    @Override
    public void save(Barang barang){
        sessionFactory.getCurrentSession().save(barang);
    }
    
    @Transactional
    @Override
    public void update(Barang barang){
        sessionFactory.getCurrentSession().update(barang);
    }
    
    @Transactional
    @Override
    public void delete(Barang barang){
        sessionFactory.getCurrentSession().delete(barang);
    }
    
    @Transactional
    @Override
    public Barang getBarang(String idBarang){
        return (Barang) sessionFactory.getCurrentSession().get(Barang.class, idBarang);
    }
    
    @Transactional
    @Override
    public List<Barang> getBarangs(){
        return sessionFactory.getCurrentSession().createCriteria(Barang.class).list();
    }
    
}
