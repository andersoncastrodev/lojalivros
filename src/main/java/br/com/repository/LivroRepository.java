package br.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.domian.Livro;

public interface LivroRepository extends JpaRepository<Livro, Integer> {
	
}
