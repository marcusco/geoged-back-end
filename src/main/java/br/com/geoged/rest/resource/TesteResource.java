package br.com.geoged.rest.resource;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/teste", produces = MediaType.APPLICATION_JSON_VALUE)
public class TesteResource {

  @GetMapping()
  public ResponseEntity<String> testaRest() {
    return ResponseEntity.ok().body("TUDO NORMAL");
  }
}
