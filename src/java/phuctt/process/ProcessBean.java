/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuctt.process;

import java.io.Serializable;
import java.util.List;
import phuctt.daos.AccessoriesDAO;
import phuctt.dtos.AccessoriesDTO;

/**
 *
 * @author Thien Phuc
 */
public class ProcessBean implements Serializable {
    private AccessoriesDTO dto;
    private String search, id;

    public ProcessBean() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public AccessoriesDTO getDto() {
        return dto;
    }

    public void setDto(AccessoriesDTO dto) {
        this.dto = dto;
    }
    
    public boolean insert() throws Exception {
        return (new AccessoriesDAO()).insert(dto);
    }
    
    public List<AccessoriesDTO> searchByLikeBrand() throws Exception{
        return (new AccessoriesDAO()).findByLikeBrand(search);
    }
    
    public boolean delete() throws Exception {
        return (new AccessoriesDAO()).delete(id);
    }
    
    public AccessoriesDTO findByID() throws Exception {
        return (new AccessoriesDAO()).findByID(id);
    }
    
    public boolean update() throws Exception {
        return (new AccessoriesDAO()).update(dto);
    }
}
