package com.example.CrudSpringBoot.Repository;

import com.example.CrudSpringBoot.Entity.Tarjeta;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarjetaRepository extends PagingAndSortingRepository<Tarjeta,Long> {
}
