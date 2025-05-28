package com.example.perfulandiaSpa.Controller;
import com.example.perfulandiaSpa.Model.Perfume;
import com.example.perfulandiaSpa.Service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;




@RestController
@RequestMapping("/api/v1/perfumes")
public class PerfumeController {
    @Autowired
    private PerfumeService perfumeService;

    @GetMapping
    public List<Perfume> listarPerfumes() {
        return perfumeService.getPerfumes();
    }
    
    @PostMapping
    public Perfume agregarPerfume(@RequestBody Perfume perfume) {
        return perfumeService.savPerfume(perfume);
    }
    
    @GetMapping("{id}")
    public Perfume buscarPerfume(@PathVariable int id){
        return perfumeService.getPerfumeId(id);
    }    
    

    @PutMapping("{id}")
    public Perfume actualizaPerfume(@PathVariable int id, @RequestBody Perfume perfume) {
        return perfumeService.updatePerfume(perfume);
    }
    
    @DeleteMapping("{id}")
    public String eliminarPerfume(@PathVariable int id) {
        return perfumeService.deletePerfume(id);
    }

    @GetMapping("/total")
    public int totalPerfumes() {
        return perfumeService.totalPerfumes();
    }
        


}
