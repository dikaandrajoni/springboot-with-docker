package com.dika.crud_provinsi.repository;

import com.dika.crud_provinsi.model.KabupatenKota;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface KabupatenRepository extends JpaRepository<KabupatenKota, Integer> {
}
