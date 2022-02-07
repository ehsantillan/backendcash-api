package com.esanti.backendcash.util;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;

public class UtilMapper {
	
	@Autowired	
	ModelMapper mapper;
	
	
	/**
	 * Maps the Page {@code entities} of <code>T</code> type which have to be mapped as input to {@code dtoClass} Page
	 * of mapped object with <code>D</code> type.
	 *
	 * @param <D> - type of objects in result page
	 * @param <T> - type of entity in <code>entityPage</code>
	 * @param entities - page of entities that needs to be mapped
	 * @param dtoClass - class of result page element
	 * @return page - mapped page with objects of type <code>D</code>.
	 * @NB <code>dtoClass</code> must has NoArgsConstructor!
	 */
	public  <D, T> Page<D> mapEntityPageIntoDtoPage(Page<T> entities, Class<D> dtoClass) {
	    return entities.map(objectEntity -> mapper.map(objectEntity, dtoClass));
	} 
	
	/**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param <D>      type of result object.
     * @param <T>      type of source object to map from.
     * @param entity   entity that needs to be mapped.
     * @param outClass class of result object.
     * @return new object of <code>outClass</code> type.
     */
    public  <D, T> D map(final T entity, Class<D> outClass) {
        return entity == null ? null : mapper.map(entity, outClass);
    }
	
	 /**
     * <p>Note: outClass object must have default constructor with no arguments</p>
     *
     * @param entityList list of entities that needs to be mapped
     * @param outCLass   class of result list element
     * @param <D>        type of objects in result list
     * @param <T>        type of entity in <code>entityList</code>
     * @return list of mapped object with <code><D></code> type.
     */
    public  <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }
    
 }
