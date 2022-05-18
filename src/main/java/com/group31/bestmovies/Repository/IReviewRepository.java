package com.group31.bestmovies.Repository;

import com.group31.bestmovies.Model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReviewRepository extends JpaRepository<Review, Long> {
}
