package hu.elte.haladojava.stream.hard;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Given deniro.csv as input the output should
 *  - list the years ranked by the average scores (scores of the movies in the same year)
 *  - order is descending
 *
 */
public class DeNiroMovies {

  public static void main(String[] args) throws IOException, URISyntaxException {
    String resourceName = "/deniro.csv";
    Path path = Paths.get(DeNiroMovies.class.getResource(resourceName).toURI());
    Files
            .lines(path)
            .skip(1)
            .map(Movie::new)
            .sorted(Comparator.comparing(movie -> movie.year));
  }

  private static class Movie {
    private final int year;
    private final int score;
    private final String title;

    Movie(String lineAsString) {
      List<String> lineAsStringArray = Arrays
              .stream(lineAsString.split(","))
              .map(element -> {
                String result = element.strip();
                result = result.replace("\"", "");;
                return result;
              }).collect(Collectors.toList());

      year = Integer.parseInt(lineAsStringArray.get(0));
      score = Integer.parseInt(lineAsStringArray.get(1));
      title = lineAsStringArray.get(2);
    }

    @Override
    public String toString() {
      return "Movie{" +
              "year=" + year +
              ", score=" + score +
              ", title='" + title + '\'' +
              '}';
    }
  }

  private static class YearAndAverageScore {
    private int year;
    private double averageScore;

    YearAndAverageScore(int year, int averageScore) {
      this.year = year;
      this.averageScore = averageScore;
    }
  }
}
