package com.mgomez.comidita.servicios;

import com.mgomez.comidita.domain.models.Etiqueta;
import com.mgomez.comidita.domain.models.Ingrediente;
import com.mgomez.comidita.domain.models.IngredienteReceta;
import com.mgomez.comidita.domain.models.Receta;
import com.mgomez.comidita.domain.records.ingrediente.IngredienteConCantidad;
import com.mgomez.comidita.domain.records.receta.AddReceta;
import com.mgomez.comidita.domain.records.receta.EtiquetarReceta;
import com.mgomez.comidita.domain.records.receta.ListarReceta;
import com.mgomez.comidita.domain.repos.EtiquetaRepository;
import com.mgomez.comidita.domain.repos.IngredienteRecetaRepository;
import com.mgomez.comidita.domain.repos.IngredienteRepository;
import com.mgomez.comidita.domain.repos.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecetaServicio {

    @Autowired
    private RecetaRepository recetaRepository;
    @Autowired
    private IngredienteRepository ingredienteRepository;
    @Autowired
    private IngredienteRecetaRepository ingredienteRecetaRepository;
    @Autowired
    private EtiquetaRepository etiquetaRepository;

    public Receta encontrarPorId(Long id) {
        return recetaRepository.findById(id).orElse(null);
    }

    public Receta etiquetarReceta(EtiquetarReceta data) {
        Receta receta = encontrarPorId(data.idReceta());
        var etiquetas = data.etiquetas();
        var r = receta.getListaEtiquetasReceta();
        for (Etiqueta etiquetaNueva : etiquetas) {
            if (!r.contains(etiquetaNueva)) r.add(etiquetaNueva);
        }
        receta.setListaEtiquetasReceta(r);
        recetaRepository.save(receta);
        return receta;
    }

    public void eliminarActivo(Long id) {
        Receta receta = encontrarPorId(id);
        receta.setActivo(false);
        recetaRepository.save(receta);
    }

    public Receta guardarRecetaNueva(AddReceta addReceta) {

        Receta receta = new Receta(addReceta);
        List<IngredienteReceta> ingredienteRecetaList = new ArrayList<>();
        var listaIngredientesCantidades = addReceta.listaIngredientesConCantidad();
        for (IngredienteConCantidad i : listaIngredientesCantidades) {
            Ingrediente ingrediente = ingredienteRepository.findById(i.idIng()).orElse(null);
            IngredienteReceta ingredienteReceta = new IngredienteReceta(ingrediente,receta, i.unidad(),i.cantidad());
            ingredienteRecetaRepository.save(ingredienteReceta);
            ingredienteRecetaList.add(ingredienteReceta);
        }
        receta.setListaIngredientes(ingredienteRecetaList);
        return recetaRepository.save(receta);
    }


    public List<Receta> listaRecetasActivas() {
        return (List<Receta>) recetaRepository.findAllByActivoTrue();
    }
}
