package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRatingRepository extends JpaRepository<Rating, Long> {
}
