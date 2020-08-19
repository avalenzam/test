package com.telefonica.eof.repository;

import java.util.List;

public interface SvaOfferingRepository {

    public List<String> findIdComponent( String lobType, String tipoOperation, String flagRetencion);
    
    
}
