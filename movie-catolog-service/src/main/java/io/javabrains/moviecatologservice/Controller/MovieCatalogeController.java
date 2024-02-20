package io.javabrains.moviecatologservice.Controller;

import io.javabrains.moviecatologservice.models.CatalogItem;
import io.javabrains.moviecatologservice.models.Movie;
import io.javabrains.moviecatologservice.models.Rating;
import io.javabrains.moviecatologservice.models.UserRatings;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogeController {

  RestTemplate rt;
  RestClient restClient;
  RestClient.Builder restClientBuilder;

  public MovieCatalogeController(
    RestTemplate rt,
    RestClient restClient,
    RestClient.Builder restClientBuilder
  ) {
    this.rt = rt;
    this.restClient = restClient;
    this.restClientBuilder = restClientBuilder;
  }

  @GetMapping("/{userId}")
  public List<CatalogItem> getCatalog(@PathVariable("userId") String userId) {
    // get all rated movies ids -- hard coded way - no rest call
    // List<Rating> ratings = Arrays.asList(
    // new Rating(1000, 3),
    // new Rating(1002, 5),
    // new Rating(1003, 4));

    // ---------------------------------------

    // hitting ratings api by restclient
    // UserRatings ratings1 =
    // restClient.get().uri("http://ratings-data-service/ratingsdata/users/" +
    // userId)
    // .retrieve()
    // .body(UserRatings.class);
    // -----------
    // hitting ratings api by restclientBuilder
    UserRatings ratings1 = restClientBuilder
      .build()
      .get()
      .uri("http://ratings-data-service/ratingsdata/users/" + userId)
      .retrieve()
      .body(UserRatings.class);

    //
    // hitting ratings api by restTemplate
    // UserRatings ratings1 =
    // rt.getForObject("http://ratings-data-service/ratingsdata/users/" +
    // userId, UserRatings.class);

    return ratings1
      .getUser_ratings()
      .stream()
      .map(rating -> {
        // hitting movie api by resttemplate
        // ------------------------------
        // Movie movie = rt.getForObject("http://movie-info-service/movies/" +
        // rating.getMovieId(), Movie.class);
        // ------------------------------

        // hiiting movies api by using restclient
        // -----------------------------
        // Movie movie = restClient.get().uri("http://movie-info-service/movies/" +
        // rating.getMovieId()).retrieve()
        // .body(Movie.class);
        // -----------------------------

        // hiiting movies api by using restclientBuilder
        // -----------------------------
        Movie movie = restClientBuilder
          .build()
          .get()
          .uri("http://movie-info-service/movies/" + rating.getMovieId())
          .retrieve()
          .body(Movie.class);
        // -----------------------------

        // create each catlog item for each rating
        return new CatalogItem(
          movie.getName(),
          "suit build",
          rating.getRating()
        );
      })
      .collect(Collectors.toList());
    // for each movie id call info serviceand get details
    // put them all together

    // return Collections.singletonList(new CatalogItem("iron man 1", "iron builds
    // the suit", 5));

  }
}
