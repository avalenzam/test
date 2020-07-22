package com.telefonica.eof.repository;

import java.util.List;

public interface SvaOfferingRepository {

    public List<String> getIdComponent( String lobType, String tipoOperation, String flagRetencion);
    
    
}
