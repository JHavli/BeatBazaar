package jhavli.musicStore.BeatBazaar.repository;

import jhavli.musicStore.BeatBazaar.model.Instrument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface InstrumentRepository extends MongoRepository<Instrument, String> {
    List<Instrument> findByGenresContains(String genre);
}
