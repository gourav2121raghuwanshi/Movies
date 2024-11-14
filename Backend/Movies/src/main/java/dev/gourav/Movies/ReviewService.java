package dev.gourav.Movies;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MongoTemplate mongoTemplate;

    public  Review createReview(String reviewBody,String imdbId){
        Review review=reviewRepository.insert(new Review(reviewBody));
   // template is used to perform custom query
        mongoTemplate.update(Movie.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review.getId())).first();
return review;
    }

    public Review getReviewById(String reviewId) {
        return reviewRepository.findById(new ObjectId(reviewId)).orElse(null);
    }
}
