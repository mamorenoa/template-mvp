package com.template.presentation.detail;

import java.io.Serializable;

public class DetailBundle implements Serializable {

    private String nameService;
    private Integer idService;

    public DetailBundle(String nameService, Integer idService){
        this.nameService = nameService;
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public Integer getIdService() {
        return idService;
    }

    public void setIdService(Integer idService) {
        this.idService = idService;
    }
}
