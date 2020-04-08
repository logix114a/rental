package com.noblens.rental;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class RentalController {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private BienRepository bienRepository;
	
	
	@GetMapping(path = "bienlist")
	public Iterable<Bien> bienlist() {
		/*Sort test = new Sort(Sort.Direction.ASC, "id");*/
		Iterable<Bien> bien = this.bienRepository.findAll();
		return bien;
	}
	
	  @PostMapping(value="/creerbien")
		public ResponseEntity<Map<String,String>> bienadd(@RequestBody Bien bien) {    	
			bien.setLast_updated_dttm(new Date());
			bien.setLast_updated_source("ODN");
			bien.setCreated_dttm(new Date());
			bien.setCreated_source("ODN");
			bien = this.bienRepository.save(bien);
			Map<String,String> response = new HashMap<String, String>();
			response.put("ok", "success saving data");
			log.info("sauvegarde la foret");
			return ResponseEntity.accepted().body(response);
		}

	//Récupérer un produit par son Id
	    @GetMapping(value="/biendetaille/{id}")
	    public Optional<Bien> biendetaille(@PathVariable int id) {
	    	Optional<Bien> bien = this.bienRepository.findById((long) id);
	        return bien;
	    }  
}
