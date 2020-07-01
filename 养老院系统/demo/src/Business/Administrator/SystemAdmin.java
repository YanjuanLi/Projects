/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Administrator;

/**
 *
 * @author Liyanjuan
 */
public class SystemAdmin {
    private String name;
    private int id;
    private static int count = 1;
    
    private String password;
    
    

    public SystemAdmin() {
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }

   

    

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

  
}
