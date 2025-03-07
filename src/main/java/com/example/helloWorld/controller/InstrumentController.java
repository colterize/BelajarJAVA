package com.example.helloWorld.controller;

import com.example.helloWorld.dto.Instrument;
import com.example.helloWorld.repository.InstrumentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/instruments")
@RequiredArgsConstructor
public class InstrumentController {

    private final InstrumentRepository instrumentRepository;

    @GetMapping
    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    @PostMapping
    public Instrument createInstrument(@RequestBody Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @PostMapping("/find")
    public Optional<Instrument> findInstrument(@RequestBody Instrument instrument) {
        log.info("Request Find: {}", instrument.getId());
        return instrumentRepository.findById(instrument.getId());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteInstrument(@RequestBody Instrument instrument) {
        log.info("Request Delete: {}", instrument.getId());
        if (instrumentRepository.existsById(instrument.getId())) {
            instrumentRepository.deleteById(instrument.getId());
            return ResponseEntity.ok("Instrument deleted successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Instrument not found");
        }
    }
}
