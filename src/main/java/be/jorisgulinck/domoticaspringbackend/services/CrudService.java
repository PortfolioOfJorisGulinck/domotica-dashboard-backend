package be.jorisgulinck.domoticaspringbackend.services;

import java.util.List;

public interface CrudService<T> {

    public T save(T entity);

    public T getById(int id);

    public List<T> getAll();

    public void delete(int id);

}
