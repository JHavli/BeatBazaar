package jhavli.musicStore.BeatBazaar.service;

import jhavli.musicStore.BeatBazaar.model.Instrument;
import jhavli.musicStore.BeatBazaar.repository.InstrumentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstrumentService {
    private final InstrumentRepository instrumentRepository;

    public InstrumentService(InstrumentRepository instrumentRepository) {
        this.instrumentRepository = instrumentRepository;
    }

    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    public Instrument saveInstrument(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    public List<Instrument> getInstrumentsByGenre(String genre) {
        return instrumentRepository.findByGenresContains(genre);
    }
}
