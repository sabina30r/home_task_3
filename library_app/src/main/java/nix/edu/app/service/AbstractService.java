package nix.edu.app.service;

import nix.edu.data.entity.AbstractEntity;

import java.util.List;

public interface AbstractService<T extends AbstractEntity> {

    void saveOrUpdate(T t);
    T findById(Long id);
    List<T> findAll();
    void remove(Long id);
}
