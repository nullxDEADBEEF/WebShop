package com.nullxdeadbeef.webshop.repository;

public interface ICrudRepository<T> {
    public void create( T object );
    public T read( Long id );
    public boolean update( T object );
    public boolean delete( Long id );
}
