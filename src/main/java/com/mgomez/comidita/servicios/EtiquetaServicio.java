package com.mgomez.comidita.servicios;

import com.mgomez.comidita.domain.models.Etiqueta;
import com.mgomez.comidita.domain.records.etiqueta.AddEtiqueta;
import com.mgomez.comidita.domain.repos.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtiquetaServicio {

    @Autowired
    private EtiquetaRepository etiquetaRepository;

    public void guardarEtiquetaNueva(AddEtiqueta data) {
        etiquetaRepository.save(new Etiqueta(data));
    }

    public List<Etiqueta> listarEtiquetasActivas() {
        return (List<Etiqueta>) etiquetaRepository.findAllByActivoTrue();
    }
}
