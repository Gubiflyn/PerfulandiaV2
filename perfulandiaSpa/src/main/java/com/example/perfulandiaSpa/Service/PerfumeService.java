package com.example.perfulandiaSpa.Service;

import com.example.perfulandiaSpa.Model.Perfume;
import com.example.perfulandiaSpa.Repository.PerfumeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PerfumeService {
    @Autowired
    private PerfumeRepository perfumeRepository;

    public List<Perfume> getPerfumes() {
        return perfumeRepository.obtenerPerfumes();
    }

    public Perfume savPerfume(Perfume perfume) {
        return perfumeRepository.guardar(perfume);
    }

    public Perfume getPerfumeId(int id) {
        return perfumeRepository.buscarPorId(id);
    }

    public Perfume updatePerfume(Perfume perfume) {
        return perfumeRepository.actualizar(perfume);
    }

    public String deletePerfume(int id) {
        perfumeRepository.eliminar(id);
        return "Perfume eliminado";
    }



    //--------------------------------//
    public int totalPerfumes(){
        return perfumeRepository.obtenerPerfumes().size();
    }

    //--------------------------------//
    public int totalPerfumesV2(){
        return perfumeRepository.totalPerfumes();
    }


    //METODO PARA REDUCIR EL STOCK
    public boolean reducirStock(int id) {
        Perfume perfume = perfumeRepository.buscarPorId(id);
        if (perfume != null && perfume.getStock() > 0 ) {
            perfume.setStock(perfume.getStock() - 1);
            perfumeRepository.actualizar(perfume);
            return true;
        }
        return false;
    }
}
