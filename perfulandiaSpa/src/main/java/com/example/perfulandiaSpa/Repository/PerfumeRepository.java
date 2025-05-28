package com.example.perfulandiaSpa.Repository;

import com.example.perfulandiaSpa.Model.Perfume;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PerfumeRepository {
    private List<Perfume> listaPerfumes = new ArrayList<>();

    public PerfumeRepository(){
        //Agregar perfumes por defecto
        listaPerfumes.add(new Perfume(1, "J'adore", "Dior", 120000, 100.0,1));
        listaPerfumes.add(new Perfume(2, "Black Opium", "Yves Saint Laurent", 95000, 90.0,100));
        listaPerfumes.add(new Perfume(3, "Light Blue", "Dolce & Gabbana", 85000, 50.0,100));
        listaPerfumes.add(new Perfume(4, "Sauvage", "Dior", 110000, 100.0,100));
        listaPerfumes.add(new Perfume(5, "La Vie Est Belle", "Lancôme", 105000, 80.0,100));
        listaPerfumes.add(new Perfume(6, "Chanel N°5", "Chanel", 130000, 100.0,100));
        listaPerfumes.add(new Perfume(7, "Black Orchid", "Tom Ford", 220000, 50.0,100));
        listaPerfumes.add(new Perfume(8, "Shalimar", "Guerlain", 90000, 90.0,100));
        listaPerfumes.add(new Perfume(9, "Acqua di Giò", "Giorgio Armani", 75000, 75.0,100));
        listaPerfumes.add(new Perfume(10, "Viva la Juicy", "Juicy Couture", 65000, 100.0,100));

    }

    //Metodo para retornar nuestro perfumes
    public List<Perfume> obtenerPerfumes(){
        return listaPerfumes;
    }

    //buscar un perfume por su id
    public Perfume buscarPorId(int id) {
        for (Perfume perfume : listaPerfumes) {
            if (perfume.getId() == id) {
                return perfume;
            }
        }
        return null;
    }

    //buscar perfume por su nombre
    public Perfume buscarPorNombre(String nombre) {
        for (Perfume perfume : listaPerfumes) {
            if (perfume.getNombre().equals(nombre)) {
                return perfume;
            }
        }
        return null;
    }


    public Perfume guardar(Perfume per){
        long nuevoId = 1;
        for (Perfume p : listaPerfumes) {
            if (p.getId() >= nuevoId) {
                nuevoId = p.getId() + 1;
            }
        }

        Perfume perfume = new Perfume();
        perfume.setId((int) nuevoId);
        perfume.setNombre(per.getNombre());
        perfume.setMarca(per.getMarca());
        perfume.setPrecio(per.getPrecio());
        perfume.setMl(per.getMl());

        listaPerfumes.add(perfume);

        return perfume;
    }
    
    
    public Perfume actualizar(Perfume per) {
        int id = 0;
        int idPosicion = 0;

        for (int i = 0; i < listaPerfumes.size(); i++) {
            if (listaPerfumes.get(i).getId() == per.getId()) {
                id = per.getId();
                idPosicion = i;

            }
        }

        Perfume perfume1 = new Perfume();
        perfume1.setId(id);
        perfume1.setNombre(per.getNombre());
        perfume1.setMarca(per.getMarca());
        perfume1.setPrecio(per.getPrecio());
        perfume1.setMl(per.getMl());
        perfume1.setStock(per.getStock());

        listaPerfumes.set(idPosicion, perfume1);
        return perfume1;
    }


    public void eliminar(int id){
        listaPerfumes.removeIf(x -> x.getId() == id); 
    }


    public int totalPerfumes() {
        return listaPerfumes.size();
    }




}
