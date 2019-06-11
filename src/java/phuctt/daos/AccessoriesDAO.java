/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.daos;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import phuctt.db.DBConnection;
import phuctt.dtos.AccessoriesDTO;

/**
 *
 * @author Thien Phuc
 */
public class AccessoriesDAO implements Serializable {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public AccessoriesDAO() {
    }
    
    private void closeConnection() throws Exception {
        if (rs != null) rs.close();
        if (ps != null) ps.close();
        if (conn != null) conn.close();
    }
    
    public boolean insert(AccessoriesDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            
            String sql = "INSERT INTO "
                    + "tbl_Accessories(AccessoryID, AccessoryName, Brand, Description, Price, isDelete) "
                    + "VALUES(?,?,?,?,?,?)";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getId());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getBrand());
            ps.setString(4, dto.getDescription());
            ps.setFloat(5, dto.getPrice());
            ps.setBoolean(6, false);
            
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public List<AccessoriesDTO> findByLikeBrand(String search) throws Exception {
        List<AccessoriesDTO> result = null;
        try {
            conn = DBConnection.getConnection();
            
            String sql = "SELECT AccessoryID, AccessoryName, Brand, Description, Price FROM tbl_Accessories WHERE brand LIKE ? AND isDelete = ?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, "%" +search+ "%");
            ps.setBoolean(2, false);
            
            rs = ps.executeQuery();
            
            String id, name, brand, desc;
            float price;
            AccessoriesDTO dto = null;
            result = new ArrayList<>();
            
            while (rs.next()) {
                id = rs.getString("AccessoryID");
                name = rs.getString("AccessoryName");
                desc = rs.getString("Description");
                brand = rs.getString("Brand");
                price = rs.getFloat("Price");
                
                dto = new AccessoriesDTO(id, name, brand, desc, price);
                result.add(dto);
            }
        } finally {
            closeConnection();
        }
        return result;
    }
    
    public boolean delete(String id) throws Exception {
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            
            String sql = "DELETE FROM tbl_Accessories WHERE AccessoryID = ?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
    
    public AccessoriesDTO findByID(String id) throws Exception {
        AccessoriesDTO dto = null;
        try {
            conn = DBConnection.getConnection();
            
            String sql = "SELECT AccessoryName, Brand, Description, Price FROM tbl_Accessories WHERE AccessoryID = ?";
            
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            
            rs = ps.executeQuery();
            
            if (rs.next()) {
                String name = rs.getString("AccessoryName");
                String brand = rs.getString("Brand");
                String desc = rs.getString("Description");
                float price = rs.getFloat("Price");
                
                dto = new AccessoriesDTO(id, name, brand, desc, price);
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    
    public boolean update(AccessoriesDTO dto) throws Exception {
        boolean check = false;
        try {
            conn = DBConnection.getConnection();
            
            String sql = "UPDATE tbl_Accessories SET AccessoryName = ?, Brand = ?, Description = ?, Price = ? WHERE AccessoryID = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, dto.getName());
            ps.setString(2, dto.getBrand());
            ps.setString(3, dto.getDescription());
            ps.setFloat(4, dto.getPrice());
            ps.setString(5, dto.getId());
            
            check = ps.executeUpdate() > 0;
        } finally {
            closeConnection();
        }
        return check;
    }
}
