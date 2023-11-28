/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package springHibernate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springHibernate.view.BarangView;
import springHibernate.service.BarangService;

/**
 *
 * @author hp
 */
public class App {
    private static ApplicationContext applicationContext;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring-configuration.xml");
        new BarangView().setVisible(true);
    }
    
    public static BarangService getBarangService(){
        return (BarangService) applicationContext.getBean("BarangService");
    }
    
}
