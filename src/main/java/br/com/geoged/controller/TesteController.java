package br.com.geoged.controller;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
public class TesteController {

  @GetMapping()
  public ResponseEntity<String> testaRest() {
    return ResponseEntity.ok().body("TUDO NORMAL");
  }
}
