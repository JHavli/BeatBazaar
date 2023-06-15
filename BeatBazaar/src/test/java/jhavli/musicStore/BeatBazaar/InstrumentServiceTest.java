package jhavli.musicStore.BeatBazaar;


import jhavli.musicStore.BeatBazaar.model.Instrument;
import jhavli.musicStore.BeatBazaar.repository.InstrumentRepository;
import jhavli.musicStore.BeatBazaar.service.InstrumentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class InstrumentServiceTest {

    @Mock
    private InstrumentRepository instrumentRepository;

    private InstrumentService instrumentService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        instrumentService = new InstrumentService(instrumentRepository);
    }

    @Test
    public void testGetAllInstruments() {
        // Mock the repository to return a list of instruments
        List<Instrument> instruments = new ArrayList<>();
        instruments.add(new Instrument("123", "Guitar", 12.99, List.of()));
        instruments.add(new Instrument("1234", "Piano", 25.99, List.of()));
        when(instrumentRepository.findAll()).thenReturn(instruments);

        // Call the service method
        List<Instrument> result = instrumentService.getAllInstruments();

        // Verify the result
        assertEquals(2, result.size());
        assertEquals("Guitar", result.get(0).getName());
        assertEquals("Piano", result.get(1).getName());
    }


    @Test
    public void testSaveInstrument() {
        // Create a new instrument
        Instrument instrument = new Instrument("123","Violin", 1500.0, List.of("Classical"));

        // Call the service method
        instrumentService.saveInstrument(instrument);

        // Verify that the repository's save method was called
        verify(instrumentRepository, times(1)).save(instrument);
    }


}
