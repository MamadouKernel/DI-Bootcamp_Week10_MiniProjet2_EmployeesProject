package com.miniprojet.employees.dao;

import com.miniprojet.employees.exceptions.ResourceNotFoundException;

import java.util.List;

/**
 * Provides alls the CRUD methodes found in ths API
 *
 * @param <T>
 */
public interface IDao<T> {
    /**
     * Find all elements of type T
     *
     * @return All the T-elements list
     */
    public List<T> findAll();

    /**
     * Find the T-element by ID passed in param
     *
     * @param id
     * @return the T-element who has this ID
     */
    public T findById(int id) throws ResourceNotFoundException;

    /**
     * Save the T-element
     *
     * @param t
     */
    public T create(T t);

    /**
     * Update the T-element
     *
     * @param t
     */
    public T update(T t);

    /**
     * delete the T-element
     *
     * @param t
     */
    public void delete(T t);

    /**
     * Delete the T-element by ID
     *
     * @param id
     */
    public void delete(int id);
}
