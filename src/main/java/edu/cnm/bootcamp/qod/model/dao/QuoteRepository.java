package edu.cnm.bootcamp.qod.model.dao;

import edu.cnm.bootcamp.qod.model.entity.Quote;
import edu.cnm.bootcamp.qod.model.entity.Source;
import java.util.List;
import java.util.Optional;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface QuoteRepository extends CrudRepository<Quote, Long> {

  List<Quote> findAllByTextContainingOrderByText(String fragment);

  List<Quote> findAllByOrderByText();

  List<Quote> findAllBySourceContainingOrderBySourceAscTextAsc(String fragment);

  List<Quote> findAllBySourceOrderByText(Source source);

  Optional<Quote> findFirstBySourceAndId(Source source, long quoteId);


  //List<Quote> findAllBySourceContainingAndTextContainingOrderBySourceAscTextAsc(
  //    String source, String text);

  @Query(value = "SELECT * FROM Quote ORDER BY RANDOM() FETCH FIRST 1 ROW ONLY", nativeQuery = true)
  Optional<Quote> findRandom();

}
