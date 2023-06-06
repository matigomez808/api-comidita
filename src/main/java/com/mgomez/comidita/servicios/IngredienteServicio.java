package com.mgomez.comidita.servicios;

import com.mgomez.comidita.domain.models.Etiqueta;
import com.mgomez.comidita.domain.models.Ingrediente;
import com.mgomez.comidita.domain.records.ingrediente.AddIngrediente;
import com.mgomez.comidita.domain.records.ingrediente.EtiquetarIngrediente;
import com.mgomez.comidita.domain.repos.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IngredienteServicio {
    @Autowired
    IngredienteRepository ingredienteRepository;

    public Ingrediente guardarIngredienteNuevo(AddIngrediente addIngrediente) {
        return ingredienteRepository.save(new Ingrediente(addIngrediente));
    }

    public Ingrediente encontrarPorId(Long id) {
        var optionalIngrediente = ingredienteRepository.findById(id);
        return optionalIngrediente.orElse(null);
    }

    public Ingrediente etiquetarIngrediente(EtiquetarIngrediente data) {
        Ingrediente ingrediente = encontrarPorId(data.idIngrediente());
        var etiquetas = data.etiquetas();
        var i = ingrediente.getListaEtiquetasIngrediente();
        for (Etiqueta etiquetaNueva : etiquetas) {
            if (!i.contains(etiquetaNueva)) i.add(etiquetaNueva);
        }
        ingrediente.setListaEtiquetasIngrediente(i);
        ingredienteRepository.save(ingrediente);
        return ingrediente;
    }

    public void eliminarActivo(Long id) {
        Ingrediente ingrediente = encontrarPorId(id);
        ingrediente.setActivo(false);
        ingredienteRepository.save(ingrediente);
    }

    public List<Ingrediente> listarIngredientes() {
        return (List<Ingrediente>) ingredienteRepository.findAllByActivoTrue();
    }

}
