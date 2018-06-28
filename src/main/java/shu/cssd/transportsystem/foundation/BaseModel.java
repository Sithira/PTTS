/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shu.cssd.transportsystem.foundation;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author sithira
 */
public class BaseModel implements Serializable {

    public String id;
    
    public Date created_at, updated_at;
    
    private SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");

    public BaseModel()
    {
        this.id = UUID.randomUUID().toString();
        
        Date date = new Date();
        
        this.created_at = date;
        this.updated_at = date;
        
    }
}
