package jhavli.musicStore.BeatBazaar.controller;

import jhavli.musicStore.BeatBazaar.model.Instrument;
import jhavli.musicStore.BeatBazaar.service.InstrumentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class InstrumentController {
    private final InstrumentService instrumentService;

    public InstrumentController(InstrumentService instrumentService) {
        this.instrumentService = instrumentService;
    }

    @GetMapping("/")
    public String getAllInstruments(Model model) {
        List<Instrument> instruments = instrumentService.getAllInstruments();
        model.addAttribute("instruments", instruments);
        return "instrument-list";
    }

    @GetMapping("/genres/{genre}")
    public String getInstrumentsByGenre(@PathVariable String genre, Model model) {
        List<Instrument> instruments = instrumentService.getInstrumentsByGenre(genre);
        model.addAttribute("instruments", instruments);
        return "instrument-list";
    }

    @GetMapping("/instruments/new")
    public String createInstrumentForm(Model model) {
        model.addAttribute("instrument", new Instrument("123", "That Instrument", 59.99, List.of("Rock", "Pop", "Folk")));
        return "instrument-form";
    }

    @PostMapping("/instruments")
    public String createInstrument(@ModelAttribute Instrument instrument) {
        instrumentService.saveInstrument(instrument);
        return "redirect:/";
    }
}
