package com.mgomez.comidita.servicios;

import com.mgomez.comidita.domain.models.Etiqueta;
import com.mgomez.comidita.domain.models.Ingrediente;
import com.mgomez.comidita.domain.records.ingrediente.AddIngrediente;
import com.mgomez.comidita.domain.records.ingrediente.EtiquetarIngrediente;
import com.mgomez.comidita.domain.repos.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredienteServicio {
    @Autowired
    IngredienteRepository ingredienteRepository;

    public Ingrediente guardarIngredienteNuevo(AddIngrediente addIngrediente) {
        return ingredienteRepository.save(new Ingrediente(addIngrediente));
    }

    public Ingrediente findByID(Long id) {
        return ingredienteRepository.getReferenceById(id);
    }

    public Ingrediente etiquetarIngrediente(EtiquetarIngrediente data) {
        Ingrediente ingrediente = ingredienteRepository.getReferenceById(data.idIngrediente());
        var etiquetas = data.etiquetas();
        var i = ingrediente.getListaEtiquetasIngrediente();
        for (Etiqueta etiquetaNueva : etiquetas) {
            if (!i.contains(etiquetaNueva)) i.add(etiquetaNueva);
        }
        ingrediente.setListaEtiquetasIngrediente(i);
        ingredienteRepository.saveAndFlush(ingrediente);
        return ingrediente;
    }

    public void eliminarActivo(Long id) {
        Ingrediente ingrediente = ingredienteRepository.getReferenceById(id);
        ingrediente.setActivo(false);
        ingredienteRepository.saveAndFlush(ingrediente);
    }

}
