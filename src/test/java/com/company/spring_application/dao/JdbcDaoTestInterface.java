package com.company.spring_application.dao;

public interface JdbcDaoTestInterface {
    public void aSavingWasSuccesful() throws Exception;

    public void bDeletingWasSuccessful() throws Exception;

    public void cUpdatingWasSuccessful() throws Exception;

    public void dGetAllReturnsProperValues() throws Exception;

    public void eGetLastIdWorksCorrectly() throws Exception;
}
